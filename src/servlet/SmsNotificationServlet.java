package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.chinatelecom.schema.ctcc.sms.v2_1.SmsMessage;
import cn.com.chinatelecom.www.wsdl.ctcc.sms.notification.v2_1.service.SmsNotificationBindingImpl;

public class SmsNotificationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		InputStream inputStream = null;
		BufferedReader br = null;
		try {
			// 通过流获得传入的参数(包含soapHeader及soapBody)
			inputStream = (InputStream) request.getInputStream();
			br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			StringBuffer buf = new StringBuffer();
			String line;
			while (null != (line = br.readLine())) {
				buf.append(line).append("\n");
			}
			String params = buf.toString();
			System.out.println("==========流程开始==========");
			System.out.println("SmsNotificationServlet接收的参数是:" + params);
			Document document = DocumentHelper.parseText(params);
			Element root = document.getRootElement();
			Element soapenvBodyNode = root.element("Body");
			Element notifySmsReceptionReqNode = soapenvBodyNode.element("notifySmsReception");
			// 消息内容
			Element messageNode = notifySmsReceptionReqNode.element("message");
			String messageValue = messageNode.element("message").getText();
			// 手机号码
			String senderAddressValue = messageNode.element("senderAddress")
					.getText();
			if (senderAddressValue.contains("tel:")) {
				senderAddressValue = senderAddressValue.replace("tel:", "");
			}
			if (senderAddressValue.contains("+86")) {
				senderAddressValue = senderAddressValue.replace("+86", "");
			}
			// 接入号
			String smsServiceActivationNumberValue = messageNode.element("smsServiceActivationNumber").getText();
			if (smsServiceActivationNumberValue.contains("tel:")) {
				smsServiceActivationNumberValue = smsServiceActivationNumberValue.replaceAll("tel:", "");
			}
			System.out.println("messageValue:" + messageValue);
			System.out.println("senderAddressValue:" + senderAddressValue);
			System.out.println("smsServiceActivationNumberValue:" + smsServiceActivationNumberValue);
			// 根据linkId节点是否存在判断是点播还是包月
			Element soapenvHeaderNode = root.element("Header");
			Element notifySOAPHeaderNode = soapenvHeaderNode.element("NotifySOAPHeader");
			Element spIdNode= notifySOAPHeaderNode.element("spId");
			String spId=spIdNode.getText();
			Element linkIdNode = notifySOAPHeaderNode.element("linkId");
			if (linkIdNode != null) {
				System.out.println("==========点播流程开始==========");
				// linkid
				String linkId = linkIdNode.getText();
				System.out.println("linkId:" + linkId);
				SmsNotificationBindingImpl smsNotificationBindingImpl = (SmsNotificationBindingImpl) applicationContext.getBean("smsNotificationBindingImpl");
				smsNotificationBindingImpl.setLinkId(linkId);
				SmsMessage smsMessage=new SmsMessage();
				smsMessage.setMessage(messageValue);
				smsMessage.setSenderAddress(senderAddressValue);
				smsMessage.setSmsServiceActivationNumber(smsServiceActivationNumberValue);
				smsNotificationBindingImpl.notifySmsReceptionWithLinkId(linkId,spId,smsMessage);
			} else {
				System.out.println("==========包月流程开始==========");
				//查询参数
				System.out.println("查询参数开始...");
				String sql=new StringBuffer(" select p.ismp_product_id,u.cp_status_update_url ")
					.append(" from cp_user u,product_info p ")
					.append(" where u.cp_access_num=? and p.access_num=? and p.order_string like ? and p.verify_status=1 and u.verify_status=1 and p.cp_id=u.cp_id;")
					.toString();
				List<Map<String, Object>> list=null;
				//判断messageValue是否有扩展字符串
				String accessNumLeft = smsServiceActivationNumberValue.substring(0, 10);
				String accessNumRight = smsServiceActivationNumberValue.substring(10,smsServiceActivationNumberValue.length());
				//特殊处理
				System.out.println("access:" + smsServiceActivationNumberValue);
				System.out.println("left:" + accessNumLeft);
				if (accessNumLeft.compareTo("1065966420") >= 0 && accessNumLeft.compareTo("1065966430") < 0) {
					accessNumLeft = smsServiceActivationNumberValue.substring(0, 11);
					accessNumRight = smsServiceActivationNumberValue.substring(11,smsServiceActivationNumberValue.length());
					System.out.println(accessNumLeft+"+"+accessNumRight);
				}
				if(messageValue.indexOf("#")!=-1){
					String[] messageValues=messageValue.split("#");
					list= jdbcTemplate.queryForList(sql,accessNumLeft, accessNumRight, messageValues[0]+"%");
				}
				else{
					list= jdbcTemplate.queryForList(sql,accessNumLeft, accessNumRight, messageValue+"%");
				}
				String ismpProductId = null;
				String cpStatusUpdateUrl = null;
				if (list != null && list.size() > 0) {
					ismpProductId = list.get(0).get("ismp_product_id") + "";
					System.out.println("ismp_product_id:" + ismpProductId);
					cpStatusUpdateUrl=list.get(0).get("cp_status_update_url")+"";
					System.out.println("cp_status_update_url:"+cpStatusUpdateUrl);
					System.out.println("查询参数成功！");
				}
				else{
					System.out.println("查询参数失败！");
					ismpProductId="";
					System.out.println("ismp_product_id:" + ismpProductId);
					cpStatusUpdateUrl="";
					System.out.println("cp_status_update_url:"+cpStatusUpdateUrl);
				}
				System.out.println("查询参数结束...");
				
				//向user_order添加记录
				System.out.println("第一次向user_order添加记录开始...");
				sql="insert into user_order(user_id,ismp_product_id,access_num,op_type,message,createtime) values(?,?,?,4,?,sysdate())";
				int row=jdbcTemplate.update(sql,senderAddressValue,ismpProductId,smsServiceActivationNumberValue,messageValue);
				if (row >= 1) {
					System.out.println("向user_order表添加记录成功！");
				} else {
					System.out.println("向user_order表添加记录失败！");
				}
				System.out.println("第一次向user_order添加记录结束...");
				//向CP上行用户请求
				if("".equals(cpStatusUpdateUrl)){
					System.out.println("查询不到cpStatusUpdateUrl，终止向CP上行用户请求！");
				}else{
					System.out.println("第一次向CP上行用户请求开始");
					HttpClient client = new HttpClient();
					PostMethod method = new PostMethod(cpStatusUpdateUrl);
					String smsMessage2 = new StringBuffer("{\"order_string\":" +"\""+ messageValue +"\""+ ",")
						.append("\"user_id\":" +"\""+ senderAddressValue +"\""+ ",")
						.append("\"access_num\":" +"\""+ smsServiceActivationNumberValue +"\""+ "}")
						.toString();
					System.out.println("向CP上行的参数order_string是:"+smsMessage2);
					method.addParameter("order_string", smsMessage2);
					HttpMethodParams param = method.getParams();
					param.setContentCharset("UTF-8");
					try {
						client.executeMethod(method);
						//打印状态信息
						System.out.println(method.getStatusLine());
					}catch(Exception e){
						System.out.println("向CP上行用户请求异常！");
						e.printStackTrace();
					}
					finally{
						System.out.println("第一次向CP上行用户请求结束...");
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
			inputStream.close();
		}
	}

}
