package com.chinatelecom.ismp.sp.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ServiceConsumeNotifyReq complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceConsumeNotifyReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="featureStr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="linkID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="streamingNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userIDType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceConsumeNotifyReq", propOrder = { "featureStr",
		"linkID", "productID", "streamingNo", "userID", "userIDType" })
public class ServiceConsumeNotifyReq {

	@XmlElement(required = true, nillable = true)
	protected String featureStr;
	@XmlElement(required = true, nillable = true)
	protected String linkID;
	@XmlElement(required = true, nillable = true)
	protected String productID;
	@XmlElement(required = true, nillable = true)
	protected String streamingNo;
	@XmlElement(required = true, nillable = true)
	protected String userID;
	protected int userIDType;

	/**
	 * Gets the value of the featureStr property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFeatureStr() {
		return featureStr;
	}

	/**
	 * Sets the value of the featureStr property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFeatureStr(String value) {
		this.featureStr = value;
	}

	/**
	 * Gets the value of the linkID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLinkID() {
		return linkID;
	}

	/**
	 * Sets the value of the linkID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLinkID(String value) {
		this.linkID = value;
	}

	/**
	 * Gets the value of the productID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductID() {
		return productID;
	}

	/**
	 * Sets the value of the productID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductID(String value) {
		this.productID = value;
	}

	/**
	 * Gets the value of the streamingNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStreamingNo() {
		return streamingNo;
	}

	/**
	 * Sets the value of the streamingNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStreamingNo(String value) {
		this.streamingNo = value;
	}

	/**
	 * Gets the value of the userID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * Sets the value of the userID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserID(String value) {
		this.userID = value;
	}

	/**
	 * Gets the value of the userIDType property.
	 * 
	 */
	public int getUserIDType() {
		return userIDType;
	}

	/**
	 * Sets the value of the userIDType property.
	 * 
	 */
	public void setUserIDType(int value) {
		this.userIDType = value;
	}

}
