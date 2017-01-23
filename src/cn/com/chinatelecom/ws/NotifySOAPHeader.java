package cn.com.chinatelecom.ws;

import java.util.Iterator;
import javax.xml.soap.SOAPElement;
import org.apache.axis.AxisFault;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.message.SOAPHeaderElement;

public class NotifySOAPHeader {
	
	private String spRevId = "";
	private String spRevpassword = "";
	private String spId = "";
	private String SAN = "";
	private String linkId = "";
	public String getSpRevId() {
	 return spRevId;
	 }
	public NotifySOAPHeader(SOAPEnvelope envelope) {
	 try {
	 SOAPHeaderElement soapHeaderElement = envelope.getHeaderByName(
	 "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1",
	 "NotifySOAPHeader");
	 Iterator iterator = soapHeaderElement.getChildElements();
	 while (iterator.hasNext()) {
	 SOAPElement element = (SOAPElement) iterator.next();
	 String elementName = element.getElementName().getLocalName();
	 if (elementName.equals("spRevId")) {
	 this. spRevId = element.getValue();
	 } else if (elementName.equals("spRevpassword")) {
	 this. spRevpassword = element.getValue();
	 } else if (elementName.equals("spId")) {
		 this. spId = element.getValue();
		 } else if (elementName.equals("SAN")) {
		 this. SAN = element.getValue();
		 } else if (elementName.equals("linkId")) {
		 this. linkId = element.getValue();
		 }
		 }
		 } catch (AxisFault e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 }
		public void setSpRevId(String spRevId) {
		 this. spRevId = spRevId;
		 }
		public String getSpRevpassword() {
		 return spRevpassword;
		 }
		public void setSpRevpassword(String spRevpassword) {
		 this. spRevpassword = spRevpassword;
		 }
		public String getSpId() {
		 return spId;
		 }
		public void setSpId(String spId) {
		 this. spId = spId;
		 }
		public String getSAN() {
		 return SAN;
		 }
		public void setSAN(String sAN) {
		 SAN = sAN;
		 }
		public String getLinkId() {
			return linkId;
		 }
		public void setLinkId(String linkId) {
		 this. linkId = linkId;
		 }
}
