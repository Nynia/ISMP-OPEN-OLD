package cn.com.chinatelecom.wsdl.ctcc.sms.notification.v2_1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSONObject;

import cn.com.chinatelecom.schema.ctcc.sms.v2_1.DeliveryInformation;
import cn.com.chinatelecom.schema.ctcc.sms.v2_1.SmsMessage;
import cn.com.chinatelecom.util.HttpProxy;

@javax.jws.WebService(endpointInterface = "cn.com.chinatelecom.wsdl.ctcc.sms.notification.v2_1.service.SmsNotification", targetNamespace = "http://www.chinatelecom.com.cn/wsdl/ctcc/sms/notification/v2_1/service", serviceName = "SmsNotificationService", portName = "SmsNotification")
public class SmsNotificationImpl {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void notifySmsReception(String registrationIdentifier,
			SmsMessage message) {
		System.out.println("==========消息通知回调接口notifySmsReception方法被调用==========");
		System.out.println("registrationIdentifier:"+registrationIdentifier);
		System.out.println("message"+message.getMessage());
		System.out.println("senderAddress"+message.getSenderAddress());
		System.out.println("smsServiceActivationNumber"+message.getSmsServiceActivationNumber());
	}

	public void notifySmsDeliveryReceipt(String correlator,
			DeliveryInformation deliveryStatus) {
		System.out.println("==========状态通知回调接口notifySmsDeliveryReceipt方法调用开始==========");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/chinatelecom/ismp/sp/jdbcContext.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		System.out.println("correlator:" + correlator);
		String address = deliveryStatus.getAddress();
		if(address.contains("tel:")){
			address=address.replace("tel:", "");
		}
		System.out.println("address:" + address);
		String deliveryStatusValue=deliveryStatus.getDeliveryStatus()+"";
		System.out.println(deliveryStatusValue);
		System.out.println("查询参数开始...");
		int orderStatus = 1;//状态（1正常2失败）
		int cpId = 0;//CP主键
		String accessNum=null;
		int opType=0;
		String cpStatusUpdateUrl = "";//CP状态更新URL
		int price=0;
		String linkId="";
		String streamNo="";
		String productName="";
		//根据correlator查询CP主键、接入号（右）、订购类型、CP状态更新URL、价格等
		String sql = "select p.cp_id,p.access_num,u.op_type,c.cp_status_update_url,p.price,u.linkId,u.stream_no,p.product_name from user_order u,product_info p,cp_user c where u.correlator=? and u.ismp_product_id=p.ismp_product_id and p.cp_id=c.cp_id";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,correlator);
		if (list != null && list.size() > 0) {
			cpId=Integer.parseInt(list.get(0).get("cp_id")+"");
			accessNum=list.get(0).get("access_num")+"";
			opType=Integer.parseInt(list.get(0).get("op_type")+"");
			cpStatusUpdateUrl=list.get(0).get("cp_status_update_url")+"";
			price=Integer.parseInt(list.get(0).get("price")+"");
			linkId=list.get(0).get("linkId")+"";
			streamNo=list.get(0).get("stream_no")+"";
			productName=list.get(0).get("product_name")+"";
			System.out.println("根据correlator查询CP主键、接入号（右）、订购类型、CP状态更新URL、价格等参数成功！");
		} else {
			orderStatus = 0;
			System.out.println("根据correlator查询CP主键、接入号（右）、订购类型、CP状态更新URL、价格等参数失败！");
		}
		//判断是否是点播，如是，则判断状态报告
		if(opType==1){
			if("DELIVERED_TO_TERMINAL".equals(deliveryStatusValue)){
				orderStatus = 1;
			}
			else{
				orderStatus = 0;
			}
		}
		System.out.println("查询参数结束...");
		
		// 通知CP
		System.out.println("通知CP订购结果开始...");
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(cpStatusUpdateUrl);
		// 1代表订购成功
		String orderResult = new StringBuffer("{\"result\":" + "\"" + orderStatus + "\"" + ",")
			.append("\"user_id\":" + "\"" + address + "\"" + ",")
			.append("\"correlator\":" + "\"" + correlator + "\"" + ",")
			.append("\"linkId\":" + "\"" + linkId + "\"" + ",")
			.append("\"stream_no\":" + "\"" + streamNo + "\"" + "}")
			.toString();
		System.out.println("传给cp的订购结果参数orderResult是" + orderResult);
		method.addParameter("orderResult", orderResult);
		HttpMethodParams param = method.getParams();
		param.setContentCharset("UTF-8");
		try {
			client.executeMethod(method);
			System.out.println("-----" + method.getStatusLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			method.releaseConnection();
			System.out.println("通知CP订购结果结束...");
		}
		if(orderStatus!=1){
			return;
		}
//		//查询号码归属地
//		String url = "http://virtual.paipai.com/extinfo/GetMobileProductInfo?";
//		HttpProxy httpProxy = new HttpProxy();
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("amount","10000");
//		params.put("mobile",address);
//		String location="";
//		try {
//			String result = httpProxy.httpGet(url, null, params, "utf-8");
//			JSONObject loc = JSONObject.parseObject(result.substring(result.indexOf("(") + 1, result.indexOf(")")));
//			location = loc.getString("province") + loc.getString("cityname");
//			System.out.println("location:"+location);
//		} catch (Exception e) {
//			System.out.println("查询归属地失败！");
//			e.printStackTrace();
//		}
		
		//向output_list表添加记录
		System.out.println("向output_list表添加记录开始...");
		sql="insert into output_list(user_id,cp_id,access_num,orderstring_type,order_time,price,correlator,product_name) values(?,?,?,?,sysdate(),?,?,?)";
		try {
			jdbcTemplate.update(sql, address, cpId, accessNum, opType, price,correlator,productName);
			System.out.println("向output_list表添加记录成功!");
		} catch (Exception e) {
			System.out.println("向output_list表添加记录失败!");
			e.printStackTrace();
		}finally{
			System.out.println("向output_list表添加记录结束...");
			System.out.println("==========状态通知回调接口notifySmsDeliveryReceipt方法调用结束==========");
			System.out.println("====================流程结束！====================");
		}
		
	}

}