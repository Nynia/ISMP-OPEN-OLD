package cn.com.chinatelecom.sms;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.rpc.ServiceException;
import org.apache.axis.message.SOAPHeaderElement;
import cn.com.chinatelecom.util.MD5;
import cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ChargingInformation;
import cn.com.chinatelecom.www.schema.ctcc.common.v2_1.SimpleReference;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms;
import
cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsBindingStub;
import
cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceLocator;

public class SMS {

	private java.lang.String SendSms_address =
		"http://localhost:9080/SendSmsService/services/SendSms";
		private String SPID = "";
		private String Token = "";
		private SendSmsServiceLocator ssl;
		private SendSms sendSms;
		private String receiptRequestUrl = "";
		private String receiptRequestInterfaceName = "notifySmsDeliveryReception";
		private ChargingInformation chargingInformation = new ChargingInformation();
		
		public SMS(String spid, String token, String ws_address,
		 String receiptrequestUrl) throws MalformedURLException,
		 ServiceException {
		 this. SendSms_address = ws_address;
		 this. ssl = new SendSmsServiceLocator();
		 this. receiptRequestUrl = receiptrequestUrl;
		 this. sendSms = ssl.getSendSms(new java.net.URL(this. SendSms_address));
		 this. SPID = spid;
		 this. Token = token;
		 this. chargingInformation.setDescription("Free");
		 this. chargingInformation.setAmount(new BigDecimal(1)); // 扣费数目
		 this. chargingInformation.setCurrency("0");
		 }
		
		public void SetChargingInformation(ChargingInformation charginginformation){
			//设置计费规则
			this. chargingInformation=charginginformation;
		}
		
		public Result SendSms(String sendnum, String destnum, String message,
		 String productid, String serviceid) {
		 String[] destnumarray = new String[1];
		 destnumarray[0] = destnum;
		 return SendSms(sendnum, destnumarray, message, productid, serviceid);
		}
		
		public Result SendSms(String sendnum, String[] destnum, String message,
		 String productid, String serviceid) {
		try {
			 // 设置SoapHeader
			 SOAPHeaderElement SoapHeader = new SOAPHeaderElement(
			 "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1",
			 "RequestSOAPHeader");
			 String TimeStamp = dateString();
			 SoapHeader.addChildElement("spId").addTextNode(this. SPID); // SpID
			 SoapHeader.addChildElement("timeStamp").addTextNode(TimeStamp);
			 SoapHeader.addChildElement("spPassword").addTextNode(
			 MD5. compile(SPID + Token + TimeStamp).toUpperCase()); // MD5加密
			 SoapHeader.addChildElement("productId").addTextNode(productid);
			 if (destnum. length == 1) {
			 SoapHeader.addChildElement("OA").addTextNode(
			 FormatMsisdn(destnum[0]));
			 SoapHeader.addChildElement("FA").addTextNode(
			 FormatMsisdn(destnum[0]));
			 SoapHeader.addChildElement("multicastMessaging").addTextNode(
			 "false"); // 是否群发
			 } else {
			 SoapHeader.addChildElement("multicastMessaging").addTextNode(
			 "true"); // 是否群发
			 }
			 ((SendSmsBindingStub) this. sendSms).setHeader(SoapHeader); // 添加SOAP头
			 /* 设置被叫号码 */
			 org.apache.axis.types.URI[] addresses = new org.apache.axis.types.URI[destnum. length];
			 for (int i = 0; i < destnum. length; i++) {
			 destnum[i] = FormatMsisdn(destnum[i]);
			 addresses[i] = new org.apache.axis.types.URI(destnum[i]);
			 }
			 /* 设置ChargingInformation */
			 this. chargingInformation.setCode(serviceid); // 业务代码
			 /* 设置SimpleReference */
			 SimpleReference receiptRequest = new SimpleReference();
			 String Correlator = getCorrelator();
			 receiptRequest.setCorrelator(Correlator); // 序号自己随机增加
			 receiptRequest.setInterfaceName(this. receiptRequestInterfaceName);
			 receiptRequest.setEndpoint(new org.apache.axis.types.URI(
			 this. receiptRequestUrl));
			 Result result = new Result();
			 result. RequestIdentifier = this. sendSms.sendSms(addresses, sendnum,
			 this. chargingInformation, message, receiptRequest);
			 result. Correlator=Correlator;
			 return result;
		 } catch
		(cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ServiceException e) {
		 // 鉴权失败
		 Result result = new Result();
		 result. MessageId = e.getMessageId();
		 result. Text = e.getText();
		 result. Variables = e.getVariables();
		 return result;
		 } catch (cn.com.chinatelecom.www.schema.ctcc.common.v2_1.PolicyException
		e) {
		 // 规则健权失败
		 Result result = new Result();
		 result. MessageId = e.getMessageId();
		 result. Text = e.getText();
		 result. Variables = e.getVariables();
		 return result;
		 } catch (Exception e) {
		 // 其他错误
		 e.printStackTrace();
		 Result result = new Result();
		 result. MessageId = "-1";
		 result. Text = "Unkonw error";
		 result. Variables = new String[1];
		 result. Variables[0] = "Unkonw error";
		 return result;
		 }
		}
		private static String FormatMsisdn(String msisdn) {
			 msisdn = msisdn.toLowerCase();
			 if ((msisdn.indexOf("+86") < 0) && (msisdn.indexOf("tel:") != 0)
			 && (msisdn.length() == 11)) {
			 // 不带+86，不带tel: 的手机号码
			 return "tel:+86" + msisdn;
			 }
			 if ((msisdn.indexOf("86") == 0) && (msisdn.indexOf("tel:") != 0)
			 && (msisdn.length() == 13)) {
				 // 带86，不带+号，不带tel: 的手机号码
				 return "tel:+" + msisdn;
			 }
			 return msisdn;
		}
			private static String getCorrelator() {
			 SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
			 return sdf.format(new Date());
			 }
			
			private static String dateString() {
			 SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
			 return sdf.format(new Date());
			 }
			
			public static void main(String[] args) {
				SMS sms=null;
				try {
					sms = new SMS("spid", "linlu", "ISAG接口地址", "短信回执接口地址");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Result result = sms.SendSms("主叫号码", "用户号码", "短信内容", "产品编号", "服务编号");
				if (result. RequestIdentifier!=null){
					 System. out.println("短信发送成功！ ");
					 System. out.println("RequestIdentifier:"+result. RequestIdentifier);
					 System. out.println("Correlator:"+result. Correlator);
					 } else {
					 System. out.println("短信发送失败！ ");
					 System. out.println("MessageId:"+result. MessageId);
					 System. out.println("Text:"+result. Text);
					 }
			}
}
