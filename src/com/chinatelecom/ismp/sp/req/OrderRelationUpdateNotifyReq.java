package com.chinatelecom.ismp.sp.req;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for OrderRelationUpdateNotifyReq complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="OrderRelationUpdateNotifyReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OPType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="packageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldPackageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldProductID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streamingNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userIDType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="VerUserID" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderRelationUpdateNotifyReq", propOrder = { "opType",
		"packageID", "oldPackageID", "productID", "oldProductID",
		"streamingNo", "userID", "userIDType", "verUserID" })
public class OrderRelationUpdateNotifyReq {

	@XmlElement(name = "OPType")
	protected int opType;
	@XmlElementRef(name = "packageID", namespace = "http://req.sp.ismp.chinatelecom.com", type = JAXBElement.class)
	protected JAXBElement<String> packageID;
	@XmlElementRef(name = "oldPackageID", namespace = "http://req.sp.ismp.chinatelecom.com", type = JAXBElement.class)
	protected JAXBElement<String> oldPackageID;
	@XmlElementRef(name = "productID", namespace = "http://req.sp.ismp.chinatelecom.com", type = JAXBElement.class)
	protected JAXBElement<String> productID;
	@XmlElementRef(name = "oldProductID", namespace = "http://req.sp.ismp.chinatelecom.com", type = JAXBElement.class)
	protected JAXBElement<String> oldProductID;
	@XmlElement(required = true, nillable = true)
	protected String streamingNo;
	@XmlElement(required = true, nillable = true)
	protected String userID;
	protected int userIDType;
	@XmlElement(name = "VerUserID", nillable = true)
	protected List<String> verUserID;

	/**
	 * Gets the value of the opType property.
	 * 
	 */
	public int getOPType() {
		return opType;
	}

	/**
	 * Sets the value of the opType property.
	 * 
	 */
	public void setOPType(int value) {
		this.opType = value;
	}

	/**
	 * Gets the value of the packageID property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getPackageID() {
		return packageID;
	}

	/**
	 * Sets the value of the packageID property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setPackageID(JAXBElement<String> value) {
		this.packageID = ((JAXBElement<String>) value);
	}

	/**
	 * Gets the value of the oldPackageID property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getOldPackageID() {
		return oldPackageID;
	}

	/**
	 * Sets the value of the oldPackageID property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setOldPackageID(JAXBElement<String> value) {
		this.oldPackageID = ((JAXBElement<String>) value);
	}

	/**
	 * Gets the value of the productID property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getProductID() {
		return productID;
	}

	/**
	 * Sets the value of the productID property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setProductID(JAXBElement<String> value) {
		this.productID = ((JAXBElement<String>) value);
	}

	/**
	 * Gets the value of the oldProductID property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link String }
	 *         {@code >}
	 * 
	 */
	public JAXBElement<String> getOldProductID() {
		return oldProductID;
	}

	/**
	 * Sets the value of the oldProductID property.
	 * 
	 * @param value
	 *            allowed object is {@link JAXBElement }{@code <}{@link String }
	 *            {@code >}
	 * 
	 */
	public void setOldProductID(JAXBElement<String> value) {
		this.oldProductID = ((JAXBElement<String>) value);
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

	/**
	 * Gets the value of the verUserID property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the verUserID property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getVerUserID().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getVerUserID() {
		if (verUserID == null) {
			verUserID = new ArrayList<String>();
		}
		return this.verUserID;
	}

}
