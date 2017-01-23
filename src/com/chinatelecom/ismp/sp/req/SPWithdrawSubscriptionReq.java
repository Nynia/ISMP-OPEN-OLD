package com.chinatelecom.ismp.sp.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SPWithdrawSubscriptionReq complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SPWithdrawSubscriptionReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userIDType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IDType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="streamingNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SPID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SPAdmin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SPAdminPwd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SPWithdrawSubscriptionReq", propOrder = { "userIDType",
		"userID", "idType", "id", "streamingNo", "spid", "spAdmin",
		"spAdminPwd" })
public class SPWithdrawSubscriptionReq {

	protected int userIDType;
	@XmlElement(required = true, nillable = true)
	protected String userID;
	@XmlElement(name = "IDType")
	protected int idType;
	@XmlElement(name = "ID", required = true, nillable = true)
	protected String id;
	@XmlElement(required = true, nillable = true)
	protected String streamingNo;
	@XmlElement(name = "SPID", required = true, nillable = true)
	protected String spid;
	@XmlElement(name = "SPAdmin", required = true, nillable = true)
	protected String spAdmin;
	@XmlElement(name = "SPAdminPwd", required = true, nillable = true)
	protected String spAdminPwd;

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
	 * Gets the value of the idType property.
	 * 
	 */
	public int getIDType() {
		return idType;
	}

	/**
	 * Sets the value of the idType property.
	 * 
	 */
	public void setIDType(int value) {
		this.idType = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getID() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setID(String value) {
		this.id = value;
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
	 * Gets the value of the spid property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPID() {
		return spid;
	}

	/**
	 * Sets the value of the spid property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPID(String value) {
		this.spid = value;
	}

	/**
	 * Gets the value of the spAdmin property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPAdmin() {
		return spAdmin;
	}

	/**
	 * Sets the value of the spAdmin property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPAdmin(String value) {
		this.spAdmin = value;
	}

	/**
	 * Gets the value of the spAdminPwd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSPAdminPwd() {
		return spAdminPwd;
	}

	/**
	 * Sets the value of the spAdminPwd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSPAdminPwd(String value) {
		this.spAdminPwd = value;
	}

}
