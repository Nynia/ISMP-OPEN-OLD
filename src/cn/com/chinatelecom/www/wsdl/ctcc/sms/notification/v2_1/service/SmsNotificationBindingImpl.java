
package cn.com.chinatelecom.www.wsdl.ctcc.sms.notification.v2_1.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;

import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.jdbc.core.JdbcTemplate;


import com.alibaba.fastjson.JSONObject;

import cn.com.chinatelecom.schema.ctcc.sms.v2_1.SmsMessage;
import cn.com.chinatelecom.util.MD5;
import cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ChargingInformation;
import cn.com.chinatelecom.www.schema.ctcc.common.v2_1.SimpleReference;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsBindingStub;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceLocator;

public class SmsNotificationBindingImpl implements cn.com.chinatelecom.www.wsdl.ctcc.sms.notification.v2_1._interface.SmsNotification{
	
	private String linkId;
	
	private String spId;
	
	public void setLinkId(String linkId){
		this.linkId=linkId;
	}
	
	public void setSpId(String spId) {
		this.spId = spId;
	}

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void notifySmsReception(java.lang.String registrationIdentifier, cn.com.chinatelecom.www.schema.ctcc.sms.v2_1.SmsMessage message) throws java.rmi.RemoteException {

	}

    public void notifySmsDeliveryReceipt(java.lang.String correlator, cn.com.chinatelecom.www.schema.ctcc.sms.v2_1.DeliveryInformation deliveryStatus) throws java.rmi.RemoteException {

    }
    
    public void notifySmsReceptionWithLinkId(String linkId,String spId,SmsMessage smsMessage){
    	System.out.println("SmsNotificationBingingImpl.notifySmsReceptionWithLinkId()被调用！");
    	String messageValue=smsMessage.getMessage();//上行信息
    	String senderAddress=smsMessage.getSenderAddress();//手机号
		String smsServiceActivationNumber=smsMessage.getSmsServiceActivationNumber();//接入号
		String accessNumLeft = smsServiceActivationNumber.substring(0, 10);//接入号（左）
		String accessNumRight = smsServiceActivationNumber.substring(10,smsServiceActivationNumber.length());//接入号（右）
		//特殊处理
		if (accessNumLeft.equals("1065966420")) {
			accessNumLeft = smsServiceActivationNumber.substring(0, 11);
			accessNumRight = smsServiceActivationNumber.substring(11,smsServiceActivationNumber.length());
			System.out.println(accessNumLeft+"+"+accessNumRight);
		}
		//根据接入号及命令字查询ismp编号、命令字、cp状态更新URL、价格、介绍等
		System.out.println("查询参数开始...");
		String sql=new StringBuffer("select p.ismp_product_id,p.orderstring_type,u.cp_status_update_url,p.price,p.description ")
			.append(" from product_info p,cp_user u ")
			.append(" where u.cp_access_num=? and p.access_num=? ")
			.append(" and p.order_string like ? and p.verify_status=1 and u.verify_status=1 and p.cp_id=u.cp_id;")
			.toString();
		List<Map<String, Object>> list=null;
		//判断messageValue是否有扩展字符串
		if(messageValue.indexOf("#")!=-1){
			String[] messageValues=messageValue.split("#");
			list= jdbcTemplate.queryForList(sql,accessNumLeft, accessNumRight, messageValues[0]+"%");
		}
		else{
			list= jdbcTemplate.queryForList(sql,accessNumLeft, accessNumRight, messageValue+"%");
		}
		String ismpProductId = null;
		String cpStatusUpdateUrl = null;
		String price = null;
		String description = null;
		int opType = 3;
		if (list != null && list.size() > 0) {
			ismpProductId = list.get(0).get("ismp_product_id") + "";
			System.out.println("ismp_product_id:" + ismpProductId);
			opType = Integer.parseInt(list.get(0).get("orderstring_type")+ "");
			System.out.println("op_type:" + opType);
			cpStatusUpdateUrl=list.get(0).get("cp_status_update_url")+"";
			System.out.println("cp_status_update_url:"+cpStatusUpdateUrl);
			price = list.get(0).get("price") + "";
			System.out.println("price:"+price);
			description = list.get(0).get("description") + "";
			System.out.println("description:"+description);
			System.out.println("查询参数成功！");
		}
		else{
			System.out.println("查询参数失败！");
			ismpProductId="";
			System.out.println("ismp_product_id:" + ismpProductId);
			opType=0;
			System.out.println("op_type:" + opType);
			cpStatusUpdateUrl="";
			System.out.println("cp_status_update_url:"+cpStatusUpdateUrl);
		}
		System.out.println("查询参数结束...");
		//向user_order表添加记录
		System.out.println("向user_order表添加记录开始...");
		String correlator=(int) (Math.random() * 100) + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		sql = "insert into user_order(user_id,ismp_product_id,access_num,op_type,stream_no,message,createTime,correlator,linkId) values(?,?,?,?,'',?,sysdate(),?,?)";
		int row = jdbcTemplate.update(sql,senderAddress,ismpProductId,smsServiceActivationNumber,opType,messageValue,correlator,linkId);
		if (row >= 1) {
			System.out.println("向user_order表添加记录成功！");
		} else {
			System.out.println("向user_order表添加记录失败！");
		}
		System.out.println("向user_order表添加记录结束...");
		//向CP上行用户请求
		if("".equals(cpStatusUpdateUrl)){
			System.out.println("查询不到cpStatusUpdateUrl，终止向CP上行用户请求！");
			return;
		}else{
			System.out.println("向CP上行用户请求开始...");
			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod(cpStatusUpdateUrl);
			String smsMessage2 = new StringBuffer("{\"user_id\":" +"\""+ senderAddress +"\""+ ",")
				.append("\"access_num\":" +"\""+ smsServiceActivationNumber +"\""+ ",")
				.append("\"order_string\":" +"\""+ messageValue +"\""+ ",")
				.append("\"ismp_product_id\":" +"\""+ ismpProductId +"\""+ ",")
				.append("\"linkId\":" +"\""+ linkId +"\""+ ",")
				.append("\"correlator\":" +"\""+ correlator +"\""+ "}")
				.toString();
			System.out.println("向CP上行的参数params是:"+smsMessage2);
			method.addParameter("params", smsMessage2);
			HttpMethodParams param = method.getParams();
			param.setContentCharset("UTF-8");
			InputStream stream = null;
			BufferedReader br = null;
			String content=null;
			try {
				client.executeMethod(method);
				//打印状态信息
				System.out.println(method.getStatusLine());
				stream = method.getResponseBodyAsStream();
				br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
				StringBuffer buf = new StringBuffer();
				String line;
				while (null != (line = br.readLine())) {
					buf.append(line).append("\n");
				}
				if (buf.toString().trim().equals("") || buf.toString() == null) {
					System.out.println("CP未返回内容");
					return;
				}
				System.out.println("CP返回的内容是:" + buf.toString());
				JSONObject jsonObject = JSONObject.parseObject(buf.toString());
				content = jsonObject.getString("content");
				//判断CP黑名单（1代表黑名单）
				int blackflag=0;
				if(jsonObject.getInteger("blackflag")!=null){
					blackflag=jsonObject.getInteger("blackflag");
				}
				if(blackflag==1){
					System.out.println("该号码在CP黑名单内！");
					return;
				}
			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					br.close();
					stream.close();
					method.releaseConnection();
					System.out.println("向CP上行用户请求结束...");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//设置SOAP Header
			System.out.println("向用户下行短信开始...");
			String SPID = spId; //SPID
			String Token = "2wsx@WSX"; //密钥
			String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date()); //时间戳
			SOAPHeaderElement SoapHeader = new SOAPHeaderElement("http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1","RequestSOAPHeader");
			try {
				SoapHeader.addChildElement("spId").addTextNode(SPID); // SpID
				SoapHeader.addChildElement("timeStamp").addTextNode(timeStamp);
				SoapHeader.addChildElement("spPassword").addTextNode(MD5.compile(SPID + Token + timeStamp).toUpperCase()); // MD5加密
				if(linkId!=null){
					SoapHeader.addChildElement("linkId").addTextNode(linkId);
				}
				SoapHeader.addChildElement("productId").addTextNode(ismpProductId);
				SoapHeader.addChildElement("OA").addTextNode("tel:+86" + senderAddress);
//				SoapHeader.addChildElement("FA").addTextNode("tel:+86" + userId);
				SoapHeader.addChildElement("multicastMessaging").addTextNode("false"); // 群发
				SendSmsServiceLocator ssl = new SendSmsServiceLocator();
				SendSms sendSms = ssl.getSendSms(new java.net.URL("http://221.228.17.35:9081/SendSmsService"));
				((SendSmsBindingStub) sendSms).setHeader(SoapHeader); 
				org.apache.axis.types.URI[] addresses = new org.apache.axis.types.URI[1];
				addresses[0] = new org.apache.axis.types.URI("tel:+86" + senderAddress);
				ChargingInformation charging = new ChargingInformation();//资费类
				charging.setDescription(description);
				charging.setAmount(new BigDecimal(1));
				charging.setCurrency(price);
				charging.setCode(ismpProductId);
				SimpleReference receiptRequest = new SimpleReference();//回调类
				receiptRequest.setEndpoint(new org.apache.axis.types.URI("http://202.102.113.194/ismp/SmsNotification?wsdl"));
				receiptRequest.setInterfaceName("SmsNotification");
				receiptRequest.setCorrelator(correlator);
				//向用户下行短信
				String result = sendSms.sendSms(addresses, smsServiceActivationNumber, charging, content, receiptRequest);
				System.out.println("点播result:"+result);
			}
			catch(cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ServiceException e){
				System. out.println("MessageId:" + e.getMessageId());
				System. out.println("Text:" + e.getText());
				if(e.getVariables()!=null){
					String[] variables = e.getVariables();
					for (int i = 0; i < variables. length; i++) {
						System. out.println("Variable:" + variables[i]);
					}
				}
			}
			catch (cn.com.chinatelecom.www.schema.ctcc.common.v2_1.PolicyException e)
			{
				System. out.println("MessageId:" + e.getMessageId());
				System. out.println("Text:" + e.getText());
				if(e.getVariables()!=null){
					String[] variables = e.getVariables();
					for (int i = 0; i < variables. length; i++) {
						 System. out.println("Variable:" + variables[i]);
					}
				}
			}
			catch (MalformedURLException e) {
				 e.printStackTrace();
			}
			catch (SOAPException e) {
				 e.printStackTrace();
			}
			catch (MalformedURIException e) {
				 e.printStackTrace();
			} 
			catch (RemoteException e) {
				 e.printStackTrace();
			} 
			catch (ServiceException e) {
				e.printStackTrace();
			}
			finally{
				System.out.println("向用户下行短信结束...");
			}
		}
		
		
		
    }
    
}
