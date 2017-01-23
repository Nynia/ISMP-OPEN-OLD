package cn.com.chinatelecom.schema.ctcc.common.v2_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for RequestSOAPHeader complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="RequestSOAPHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="spId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="spPassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transEnd" type="{http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1}EndReason" minOccurs="0"/>
 *         &lt;element name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OA" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="FA" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="multicastMessaging" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestSOAPHeader", propOrder = { "spId", "spPassword",
		"timeStamp", "productId", "san", "transactionId", "transEnd", "linkId",
		"oa", "fa", "multicastMessaging" })
public class RequestSOAPHeader {

	@XmlElement(required = true)
	protected String spId;
	@XmlElement(required = true)
	protected String spPassword;
	@XmlElement(required = true)
	protected String timeStamp;
	@XmlElement(required = true)
	protected String productId;
	@XmlElement(name = "SAN")
	protected String san;
	protected String transactionId;
	protected String transEnd;
	protected String linkId;
	@XmlElement(name = "OA")
	@XmlSchemaType(name = "anyURI")
	protected String oa;
	@XmlElement(name = "FA")
	@XmlSchemaType(name = "anyURI")
	protected String fa;
	protected Boolean multicastMessaging;

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
	 * Gets the value of the spPassword property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSpPassword() {
		return spPassword;
	}

	/**
	 * Sets the value of the spPassword property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSpPassword(String value) {
		this.spPassword = value;
	}

	/**
	 * Gets the value of the timeStamp property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Sets the value of the timeStamp property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTimeStamp(String value) {
		this.timeStamp = value;
	}

	/**
	 * Gets the value of the productId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Sets the value of the productId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductId(String value) {
		this.productId = value;
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
	 * Gets the value of the transEnd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTransEnd() {
		return transEnd;
	}

	/**
	 * Sets the value of the transEnd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTransEnd(String value) {
		this.transEnd = value;
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

	/**
	 * Gets the value of the oa property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOA() {
		return oa;
	}

	/**
	 * Sets the value of the oa property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOA(String value) {
		this.oa = value;
	}

	/**
	 * Gets the value of the fa property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFA() {
		return fa;
	}

	/**
	 * Sets the value of the fa property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFA(String value) {
		this.fa = value;
	}

	/**
	 * Gets the value of the multicastMessaging property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isMulticastMessaging() {
		return multicastMessaging;
	}

	/**
	 * Sets the value of the multicastMessaging property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setMulticastMessaging(Boolean value) {
		this.multicastMessaging = value;
	}

}
