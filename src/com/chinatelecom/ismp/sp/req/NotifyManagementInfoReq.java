package com.chinatelecom.ismp.sp.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for NotifyManagementInfoReq complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyManagementInfoReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IDType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="streamingNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifyManagementInfoReq", propOrder = { "id", "idType",
		"status", "streamingNo" })
public class NotifyManagementInfoReq {

	@XmlElement(name = "ID", required = true, nillable = true)
	protected String id;
	@XmlElement(name = "IDType")
	protected int idType;
	protected int status;
	@XmlElement(required = true, nillable = true)
	protected String streamingNo;

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
	 * Gets the value of the status property.
	 * 
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the value of the status property.
	 * 
	 */
	public void setStatus(int value) {
		this.status = value;
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

}
