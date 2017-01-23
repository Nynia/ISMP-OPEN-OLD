package cn.com.chinatelecom.util;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.types.URI.MalformedURIException;
import cn.com.chinatelecom.util.MD5;
import cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ChargingInformation;
import cn.com.chinatelecom.www.schema.ctcc.common.v2_1.PolicyException;
import cn.com.chinatelecom.www.schema.ctcc.common.v2_1.SimpleReference;
import cn.com.chinatelecom.www.schema.ctcc.sms.v2_1.DeliveryInformation;
import
cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsBindingStub;
import
cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceLocator;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms;

public class SendSmsTest {
	
	public static void main(String[] args) {
		
		 String webserviceUrl = "http://221.228.17.35:9081/SendSmsService";
		 String SPID = "11103730"; // SPID
		 String Token = "2wsx@WSX"; // 密钥
		 String DestNum = "tel:+8618118999630"; // 发送号码
		 String ProductID = "111000000000000123456"; // 产品编号
		 String ServiceID = "211000000000000011647"; // 业务编号
		 String TimeStamp = dateString(); // 当前时间
		 String senderName = "10659661001432"; // 短信主叫号码，在浙江ISAG实际无效， ISAG会读取业务部署时候的接入号
		 String message = "测试短信"; // 短信内容
		 SOAPHeaderElement SoapHeader = new SOAPHeaderElement(
				 "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1",
				 "RequestSOAPHeader");
		 SendSms sendSms=null;
		 String result=null;
		 try {
			 /* 初始化Web Service Client */
			 SendSmsServiceLocator ssl = new SendSmsServiceLocator();
			 sendSms = ssl.getSendSms(new java.net.URL(webserviceUrl));
			 /* 设置SOAP Header */
			 SoapHeader.addChildElement("spId").addTextNode(SPID); // SpID
			 SoapHeader.addChildElement("timeStamp").addTextNode(TimeStamp);
			 SoapHeader.addChildElement("spPassword").addTextNode(
			 MD5.compile(SPID + Token + TimeStamp).toUpperCase()); // MD5加密
			 SoapHeader.addChildElement("productId").addTextNode(ProductID);
			 SoapHeader.addChildElement("OA").addTextNode(DestNum);
			 SoapHeader.addChildElement("FA").addTextNode(DestNum);
			 SoapHeader.addChildElement("multicastMessaging").addTextNode("false"); // 是否群发
			 ((SendSmsBindingStub) sendSms).setHeader(SoapHeader); // 添加SOAP头
			 /* 设置被叫号码 */
			 org.apache.axis.types.URI[] addresses = new org.apache.axis.types.URI[1];
			 addresses[0] = new org.apache.axis.types.URI(DestNum);
			 /* 设置ChargingInformation */
			 ChargingInformation charging = new ChargingInformation();
			 charging.setDescription("gm"); // 描述
			 charging.setAmount(new BigDecimal(1)); // 扣费数目
			 charging.setCode(ServiceID); // 业务代码
			 charging.setCurrency("0");
			 /* 设置SimpleReference */
			 SimpleReference receiptRequest = new SimpleReference();
			 receiptRequest.setCorrelator("1001559"); // 序号自己随机增加
			 receiptRequest.setInterfaceName("SmsNotificationService");
			 receiptRequest.setEndpoint(new org.apache.axis.types.URI(
					 "http://202.102.113.167/ismp/ismpEndpointServlet"));
			 /* 发送短信 */
			 result = sendSms.sendSms(addresses, senderName, charging,
					 message, receiptRequest);
			 System. out.println("result:" + result);
		 } catch(cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ServiceException e) 
		 	{
			 //鉴权失败
			 System. out.println("MessageId:" + e.getMessageId());
			 System. out.println("Text:" + e.getText());
			 String[] variables = e.getVariables();
			 for (int i = 0; i < variables. length; i++) {
			 System. out.println("Variable:" + variables[i]);
			 }
			} catch (cn.com.chinatelecom.www.schema.ctcc.common.v2_1.PolicyException e)
			{
			 System. out.println("MessageId:" + e.getMessageId());
			 System. out.println("Text:" + e.getText());
			 String[] variables = e.getVariables();
			 for (int i = 0; i < variables. length; i++) {
			 System. out.println("Variable:" + variables[i]);
			 }
			 } catch (MalformedURLException e) {
			 e.printStackTrace();
			 } catch (ServiceException e) {
			 e.printStackTrace();
			 } catch (SOAPException e) {
			 e.printStackTrace();
			 } catch (MalformedURIException e) {
			 e.printStackTrace();
			 } catch (RemoteException e) {
			 e.printStackTrace();
			 }
			 //等待10秒以后再查询
			 try {
				 Thread. sleep(10000);
			 } catch (InterruptedException e) {
			 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
			 DeliveryInformation[] delvierinfo=null;
			 try {
				delvierinfo = sendSms.getSmsDeliveryStatus(result);
			 } catch (PolicyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } catch (cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 for (int i = 0; i < delvierinfo. length; i++) {
				 System.out.println("发送号码： " + delvierinfo[i].getAddress());
				 System.out.println("发送状态： " + delvierinfo[i].getDeliveryStatus());
			 }
		}
	
	private static String dateString() {
		 SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		 return sdf.format(new Date());
	}
}
