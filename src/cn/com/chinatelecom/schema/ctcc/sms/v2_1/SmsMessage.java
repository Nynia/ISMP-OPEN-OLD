package cn.com.chinatelecom.schema.ctcc.sms.v2_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SmsMessage complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SmsMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="senderAddress" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="smsServiceActivationNumber" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SmsMessage", propOrder = { "message", "senderAddress",
		"smsServiceActivationNumber" })
public class SmsMessage {

	@XmlElement(required = true)
	protected String message;
	@XmlElement(required = true)
	@XmlSchemaType(name = "anyURI")
	protected String senderAddress;
	@XmlElement(required = true)
	@XmlSchemaType(name = "anyURI")
	protected String smsServiceActivationNumber;

	/**
	 * Gets the value of the message property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessage(String value) {
		this.message = value;
	}

	/**
	 * Gets the value of the senderAddress property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSenderAddress() {
		return senderAddress;
	}

	/**
	 * Sets the value of the senderAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSenderAddress(String value) {
		this.senderAddress = value;
	}

	/**
	 * Gets the value of the smsServiceActivationNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSmsServiceActivationNumber() {
		return smsServiceActivationNumber;
	}

	/**
	 * Sets the value of the smsServiceActivationNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSmsServiceActivationNumber(String value) {
		this.smsServiceActivationNumber = value;
	}

}
