package com.chinatelecom.ismp.sp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis.message.SOAPHeaderElement;
import org.apache.axis.types.URI;
import org.apache.axis.types.URI.MalformedURIException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.chinatelecom.util.HttpProxy;
import cn.com.chinatelecom.util.MD5;
import cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ChargingInformation;
import cn.com.chinatelecom.www.schema.ctcc.common.v2_1.SimpleReference;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsBindingStub;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceLocator;

import com.alibaba.fastjson.JSONObject;
import com.chinatelecom.ismp.sp.req.NotifyManagementInfoReq;
import com.chinatelecom.ismp.sp.req.OrderRelationUpdateNotifyReq;
import com.chinatelecom.ismp.sp.req.SPWithdrawSubscriptionReq;
import com.chinatelecom.ismp.sp.req.ServiceConsumeNotifyReq;
import com.chinatelecom.ismp.sp.rsp.NotifyManagementInfoRsp;
import com.chinatelecom.ismp.sp.rsp.Response;


@javax.jws.WebService(endpointInterface = "com.chinatelecom.ismp.sp.IsmpSpEngine", targetNamespace = "http://sp.ismp.chinatelecom.com", serviceName = "IsmpSpEngineService", portName = "IsmpSpEngine")
public class IsmpSpEngineImpl{

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Response orderRelationUpdateNotify(OrderRelationUpdateNotifyReq orderRelationUpdateNotifyReq) {
		System.out.println("==========调用订购关系更新URL接口IsmpSpEngineImpl开始==========");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/chinatelecom/ismp/sp/jdbcContext.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");

		String userId = orderRelationUpdateNotifyReq.getUserID();
		int opType = orderRelationUpdateNotifyReq.getOPType();
		System.out.println("原始opType:"+opType);
		if (opType == 0) {
			opType = 2;
		}
		String streamNo = orderRelationUpdateNotifyReq.getStreamingNo();
		String productId = orderRelationUpdateNotifyReq.getProductID().getValue();
		System.out.println("userId:"+userId);
		System.out.println("opType:"+opType);
		System.out.println("streamNo:"+streamNo);
		System.out.println("productId:"+productId);
		//查询参数
		System.out.println("查询参数开始...");
		String sql = new StringBuffer("select c.cp_id,c.cp_access_num,p.access_num,c.cp_status_update_url,p.price,p.description,p.ismp_bussiness_id,c.sp_id ")
				.append(" from cp_user c,product_info p ")
				.append(" where p.ismp_product_id=? and p.cp_id=c.cp_id and c.verify_status=1 and p.verify_status=1")
				.toString();
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,productId);
		int cpId = 0;
		String accessNum = null;
		String accessNumRight = null;
		String cpStatusUpdateUrl = null;
		String description = null;
		String code = null;
		String spId= null;
		int price = 0;
		if (list != null && list.size() > 0) {
			cpId = Integer.parseInt(list.get(0).get("cp_id") + "");
			accessNum = list.get(0).get("cp_access_num") + "" + list.get(0).get("access_num");
			accessNumRight = accessNum.substring(10, accessNum.length());
			cpStatusUpdateUrl = list.get(0).get("cp_status_update_url") + "";
			price = Integer.parseInt(list.get(0).get("price") + "");
			description = list.get(0).get("description") + "";
			code = list.get(0).get("ismp_bussiness_id") + "";
			spId=list.get(0).get("sp_id")+"";
			System.out.println("cp_id:" + cpId);
			System.out.println("access_num:" + accessNum);
			System.out.println("access_num_right:" + accessNumRight);
			System.out.println("cp_status_update_url:" + cpStatusUpdateUrl);
			System.out.println("price:" + price);
			System.out.println("description:" + description);
			System.out.println("code:" + code);
			System.out.println("spId:"+spId);
			System.out.println("查询参数成功！");
		} else {
			System.out.println("查询参数失败！");
			return null;
		}

		// 判断号码归属地
//		String location = null;
//		String url = "http://virtual.paipai.com/extinfo/GetMobileProductInfo?";
//		HttpProxy httpProxy = new HttpProxy();
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("amount", "10000");
//		params.put("mobile", userId);
//		try {
//			String result = httpProxy.httpGet(url, null, params, "utf-8");
//			JSONObject loc = JSONObject.parseObject(result.substring(result
//					.indexOf("(") + 1, result.indexOf(")")));
//			location = loc.getString("province") + loc.getString("cityname");
//			System.out.println("location:" + location);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("查询参数结束...");

		String correlator=(int) (Math.random() * 100) + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		// 向CP上行用户请求
		System.out.println("订购关系更新URL接口向CP上行用户请求开始...");
		HttpClient client = new HttpClient();
		// 使用POST方法
		PostMethod method = new PostMethod(cpStatusUpdateUrl);
		String p = new StringBuffer("{\"user_id\":" + "\"" + userId + "\"" + ",")
				.append("\"access_num\":" + "\"" + accessNum + "\"" + ",")
				.append("\"ismp_product_id\":" + "\"" + productId + "\"" + ",")
				.append("\"op_type\":" + "\"" + opType + "\"" + ",")
				.append("\"stream_no\":" + "\"" + streamNo + "\"" + ",")
				.append("\"correlator\":" + "\"" + correlator + "\"" + "}")
				.toString();
		System.out.println("向CP上行的参数params是是：" + p);
		method.addParameter("params", p);
		HttpMethodParams param = method.getParams();
		param.setContentCharset("UTF-8");
		InputStream stream = null;
		BufferedReader br = null;
		JSONObject jsonObject = null;
		try {
			client.executeMethod(method);
			// 打印服务器返回的状态
			System.out.println("-----" + method.getStatusLine());
			// 打印返回的信息
			stream = method.getResponseBodyAsStream();
			br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
			// CP返回的参数(JSON字符串)
			StringBuffer buf = new StringBuffer();
			String line;
			while (null != (line = br.readLine())) {
				buf.append(line).append("\n");
			}
			if (buf.toString().trim().equals("") || buf.toString() == null) {
				System.out.println("CP未返回内容");
				return null;
			}
			System.out.println("CP返回的参数是:" + buf.toString());
			jsonObject = JSONObject.parseObject(buf.toString());
			// 判断CP黑名单（1代表黑名单）
			int blackflag = 0;
			if (jsonObject.getInteger("blackflag") != null) {
				blackflag = jsonObject.getInteger("blackflag");
			}
			if (blackflag == 1) {
				System.out.println("该号码在CP黑名单内！");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				stream.close();
				// 释放连接
				method.releaseConnection();
				System.out.println("订购关系更新URL接口向CP上行用户请求结束...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		MutliThread m = new MutliThread(userId,accessNum,description,price,code,spId,productId,correlator,jsonObject);
		Thread t = new Thread(m);
		t.start();

		//再次向user_order插入数据
		System.out.println("向user_order表添加记录开始...");
		sql="insert into user_order(user_id,ismp_product_id,access_num,op_type,stream_no,createtime,correlator,linkId) values(?,?,?,?,?,sysdate(),?,'')";
		int row=jdbcTemplate.update(sql,userId,productId,accessNum,opType,streamNo,correlator);
		if (row >= 1) {
			System.out.println("向user_order表添加记录成功！");
		} else {
			System.out.println("向user_order表添加记录失败！");
			return null;
		}
		System.out.println("向user_order表添加记录结束...");
		//返回订购成功标示
		Response response=new Response();
		response.setResultCode(0);
		response.setStreamingNo(streamNo);
		System.out.println("====================调用订购关系更新URL接口IsmpSpEngineImpl结束====================");
		return response;
	}
	public class MutliThread implements Runnable{
		private String userId;
		private String accessNum;
		private String description;
		private int price;
		private String code;
		private String spId;
		private String productId;
		private String correlator;
		private JSONObject jsonObject;
		MutliThread(String userId,String accessNum,String description,int price,String code,String spId,String productId,String correlator,JSONObject jsonObject){
			this.userId = userId;
			this.accessNum = accessNum;
			this.description = description;
			this.price = price;
			this.code = code;
			this.spId = spId;
			this.productId = productId;
			this.correlator = correlator;
			this.jsonObject = jsonObject;
		}
		public void run(){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("userId:"+userId+";accessNum:"+accessNum+";spId:"+spId+";productId:"+productId+";correlatro:"+correlator);
			//send message
			// 向用户下行短信
			System.out.println("订购关系更新URL接口向用户下行短信开始...");
			// 设置参数address
			URI[] addresses = new URI[1];
			try {
				addresses[0] = new org.apache.axis.types.URI("tel:+86" + userId);
			} catch (MalformedURIException e1) {
				e1.printStackTrace();
				System.out.println("向用户下行短信发生异常！");
			}
			System.out.println("address:" + "tel:+86" + userId);
			// 设置参数senderName
			System.out.println("senderName:" + accessNum);
			// 设置参数messages
			String messages = jsonObject.getString("content");
			System.out.println("messages:" + messages);
			// 设置参数chargingObject
			ChargingInformation charging = new ChargingInformation();
			charging.setDescription(description);
			charging.setAmount(new BigDecimal(1));
			charging.setCurrency(price + "");
			charging.setCode(code);
			System.out.println("description:" + description);
			System.out.println("amount:" + 1);
			System.out.println("currency:" + price);
			System.out.println("code:" + code);
			// 设置参数simpleReference
			SimpleReference receiptRequest = new SimpleReference();
			try {
				receiptRequest.setEndpoint(new org.apache.axis.types.URI(
						"http://202.102.41.186:9250/ismp/SmsNotification?wsdl"));
			} catch (MalformedURIException e1) {
				e1.printStackTrace();
				System.out.println("向用户下行短信发生异常！");
			}
			receiptRequest.setInterfaceName("SmsNotification");
			receiptRequest.setCorrelator(correlator);
			System.out.println("correlator:" + receiptRequest.getCorrelator());

			String SPID = spId; // SPID
			String Token = "2wsx@WSX"; // 密钥
			String ProductID = productId; // 产品编号 "21位的产品编号,1开头"
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
			Date nowtime = new Date();
			String timeStamp = dateFormat.format(nowtime); // 当前时间
			SOAPHeaderElement SoapHeader = new SOAPHeaderElement(
					"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1",
					"RequestSOAPHeader");
		/* 设置SOAP Header */
			String result = null;
			try {
				SoapHeader.addChildElement("spId").addTextNode(SPID);// SpID
				SoapHeader.addChildElement("timeStamp").addTextNode(timeStamp);
				SoapHeader.addChildElement("spPassword").addTextNode(
						MD5.compile(SPID + Token + timeStamp).toUpperCase()); // MD5加密
				SoapHeader.addChildElement("productId").addTextNode(ProductID);
				SoapHeader.addChildElement("OA").addTextNode("tel:+86" + userId);
				// SoapHeader.addChildElement("FA").addTextNode("tel:+86"+user_id);
				SoapHeader.addChildElement("multicastMessaging").addTextNode(
						"false"); // 是否群发
			/* 初始化Web Service Client */
				SendSmsServiceLocator ssl = new SendSmsServiceLocator();
				SendSms sendSms = ssl.getSendSms(new java.net.URL(
						"http://221.228.17.35:9081/SendSmsService"));
				((SendSmsBindingStub) sendSms).setHeader(SoapHeader);
				result = sendSms.sendSms(addresses, accessNum, charging, messages,
						receiptRequest);
				System.out.println("下行返回值result:" + result);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("向用户下行短信发生异常！");
				//return null;
			} finally{
				System.out.println("订购关系更新URL接口向用户下行短信结束...");
			}
		}
	}
	public Response spWithdrawSubscription(
			SPWithdrawSubscriptionReq spWithdrawSubscriptionReqPara) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public Response serviceConsumeNotify(
			ServiceConsumeNotifyReq serviceConsumeNotifyReqPara) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public NotifyManagementInfoRsp notifyManagementInfo(
			NotifyManagementInfoReq notifyManagementInfoReq) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}