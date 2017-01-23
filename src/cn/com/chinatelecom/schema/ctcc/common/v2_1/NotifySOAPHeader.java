package cn.com.chinatelecom.schema.ctcc.common.v2_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for NotifySOAPHeader complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="NotifySOAPHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="spRevId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spRevpassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifySOAPHeader", propOrder = { "spRevId", "spRevpassword",
		"spId", "san", "transactionId", "linkId" })
public class NotifySOAPHeader {

	protected String spRevId;
	protected String spRevpassword;
	@XmlElement(required = true)
	protected String spId;
	@XmlElement(name = "SAN")
	protected String san;
	protected String transactionId;
	protected String linkId;

	/**
	 * Gets the value of the spRevId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSpRevId() {
		return spRevId;
	}

	/**
	 * Sets the value of the spRevId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSpRevId(String value) {
		this.spRevId = value;
	}

	/**
	 * Gets the value of the spRevpassword property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSpRevpassword() {
		return spRevpassword;
	}

	/**
	 * Sets the value of the spRevpassword property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSpRevpassword(String value) {
		this.spRevpassword = value;
	}

	/**
	 * Gets the value of the spId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSpId() {
		return spId;
	}

	/**
	 * Sets the value of the spId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSpId(String value) {
		this.spId = value;
	}

	/**
	 * Gets the value of the san property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSAN() {
		return san;
	}

	/**
	 * Sets the value of the san property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSAN(String value) {
		this.san = value;
	}

	/**
	 * Gets the value of the transactionId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * Sets the value of the transactionId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransactionId(String value) {
		this.transactionId = value;
	}

	/**
	 * Gets the value of the linkId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLinkId() {
		return linkId;
	}

	/**
	 * Sets the value of the linkId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLinkId(String value) {
		this.linkId = value;
	}

}
