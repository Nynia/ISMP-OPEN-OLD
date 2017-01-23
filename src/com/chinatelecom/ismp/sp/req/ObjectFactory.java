package com.chinatelecom.ismp.sp.req;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.chinatelecom.ismp.sp.req package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _OrderRelationUpdateNotifyReqPackageID_QNAME = new QName(
			"http://req.sp.ismp.chinatelecom.com", "packageID");
	private final static QName _OrderRelationUpdateNotifyReqProductID_QNAME = new QName(
			"http://req.sp.ismp.chinatelecom.com", "productID");
	private final static QName _OrderRelationUpdateNotifyReqOldPackageID_QNAME = new QName(
			"http://req.sp.ismp.chinatelecom.com", "oldPackageID");
	private final static QName _OrderRelationUpdateNotifyReqOldProductID_QNAME = new QName(
			"http://req.sp.ismp.chinatelecom.com", "oldProductID");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.chinatelecom.ismp.sp.req
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link ServiceConsumeNotifyReq }
	 * 
	 */
	public ServiceConsumeNotifyReq createServiceConsumeNotifyReq() {
		return new ServiceConsumeNotifyReq();
	}

	/**
	 * Create an instance of {@link OrderRelationUpdateNotifyReq }
	 * 
	 */
	public OrderRelationUpdateNotifyReq createOrderRelationUpdateNotifyReq() {
		return new OrderRelationUpdateNotifyReq();
	}

	/**
	 * Create an instance of {@link SPWithdrawSubscriptionReq }
	 * 
	 */
	public SPWithdrawSubscriptionReq createSPWithdrawSubscriptionReq() {
		return new SPWithdrawSubscriptionReq();
	}

	/**
	 * Create an instance of {@link NotifyManagementInfoReq }
	 * 
	 */
	public NotifyManagementInfoReq createNotifyManagementInfoReq() {
		return new NotifyManagementInfoReq();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://req.sp.ismp.chinatelecom.com", name = "packageID", scope = OrderRelationUpdateNotifyReq.class)
	public JAXBElement<String> createOrderRelationUpdateNotifyReqPackageID(
			String value) {
		return new JAXBElement<String>(
				_OrderRelationUpdateNotifyReqPackageID_QNAME, String.class,
				OrderRelationUpdateNotifyReq.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://req.sp.ismp.chinatelecom.com", name = "productID", scope = OrderRelationUpdateNotifyReq.class)
	public JAXBElement<String> createOrderRelationUpdateNotifyReqProductID(
			String value) {
		return new JAXBElement<String>(
				_OrderRelationUpdateNotifyReqProductID_QNAME, String.class,
				OrderRelationUpdateNotifyReq.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://req.sp.ismp.chinatelecom.com", name = "oldPackageID", scope = OrderRelationUpdateNotifyReq.class)
	public JAXBElement<String> createOrderRelationUpdateNotifyReqOldPackageID(
			String value) {
		return new JAXBElement<String>(
				_OrderRelationUpdateNotifyReqOldPackageID_QNAME, String.class,
				OrderRelationUpdateNotifyReq.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://req.sp.ismp.chinatelecom.com", name = "oldProductID", scope = OrderRelationUpdateNotifyReq.class)
	public JAXBElement<String> createOrderRelationUpdateNotifyReqOldProductID(
			String value) {
		return new JAXBElement<String>(
				_OrderRelationUpdateNotifyReqOldProductID_QNAME, String.class,
				OrderRelationUpdateNotifyReq.class, value);
	}

}
