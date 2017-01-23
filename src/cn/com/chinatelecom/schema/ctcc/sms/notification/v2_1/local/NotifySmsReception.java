package cn.com.chinatelecom.schema.ctcc.sms.notification.v2_1.local;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import cn.com.chinatelecom.schema.ctcc.sms.v2_1.SmsMessage;

/**
 * <p>
 * Java class for notifySmsReception complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="notifySmsReception">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="registrationIdentifier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="message" type="{http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1}SmsMessage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notifySmsReception", propOrder = { "registrationIdentifier",
		"message" })
public class NotifySmsReception {

	@XmlElement(required = true)
	protected String registrationIdentifier;
	@XmlElement(required = true)
	protected SmsMessage message;

	/**
	 * Gets the value of the registrationIdentifier property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRegistrationIdentifier() {
		return registrationIdentifier;
	}

	/**
	 * Sets the value of the registrationIdentifier property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRegistrationIdentifier(String value) {
		this.registrationIdentifier = value;
	}

	/**
	 * Gets the value of the message property.
	 * 
	 * @return possible object is {@link SmsMessage }
	 * 
	 */
	public SmsMessage getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link SmsMessage }
	 * 
	 */
	public void setMessage(SmsMessage value) {
		this.message = value;
	}

}
