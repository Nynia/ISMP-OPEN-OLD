package com.chinatelecom.ismp.sp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.chinatelecom.ismp.sp.req.NotifyManagementInfoReq;
import com.chinatelecom.ismp.sp.req.OrderRelationUpdateNotifyReq;
import com.chinatelecom.ismp.sp.req.SPWithdrawSubscriptionReq;
import com.chinatelecom.ismp.sp.req.ServiceConsumeNotifyReq;
import com.chinatelecom.ismp.sp.rsp.NotifyManagementInfoRsp;
import com.chinatelecom.ismp.sp.rsp.Response;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.chinatelecom.ismp.sp package.
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

	private final static QName _ServiceConsumeNotifyReqPara_QNAME = new QName(
			"http://sp.ismp.chinatelecom.com", "serviceConsumeNotifyReqPara");
	private final static QName _ServiceConsumeNotifyReturn_QNAME = new QName(
			"http://sp.ismp.chinatelecom.com", "serviceConsumeNotifyReturn");
	private final static QName _NotifyManagementInfoReturn_QNAME = new QName(
			"http://sp.ismp.chinatelecom.com", "notifyManagementInfoReturn");
	private final static QName _NotifyManagementInfoReq_QNAME = new QName(
			"http://sp.ismp.chinatelecom.com", "notifyManagementInfoReq");
	private final static QName _SpWithdrawSubscriptionReturn_QNAME = new QName(
			"http://sp.ismp.chinatelecom.com", "spWithdrawSubscriptionReturn");
	private final static QName _SpWithdrawSubscriptionReqPara_QNAME = new QName(
			"http://sp.ismp.chinatelecom.com", "spWithdrawSubscriptionReqPara");
	private final static QName _OrderRelationUpdateNotifyReturn_QNAME = new QName(
			"http://sp.ismp.chinatelecom.com",
			"orderRelationUpdateNotifyReturn");
	private final static QName _OrderRelationUpdateNotifyReq_QNAME = new QName(
			"http://sp.ismp.chinatelecom.com", "orderRelationUpdateNotifyReq");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.chinatelecom.ismp.sp
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ServiceConsumeNotifyReq }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://sp.ismp.chinatelecom.com", name = "serviceConsumeNotifyReqPara")
	public JAXBElement<ServiceConsumeNotifyReq> createServiceConsumeNotifyReqPara(
			ServiceConsumeNotifyReq value) {
		return new JAXBElement<ServiceConsumeNotifyReq>(
				_ServiceConsumeNotifyReqPara_QNAME,
				ServiceConsumeNotifyReq.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://sp.ismp.chinatelecom.com", name = "serviceConsumeNotifyReturn")
	public JAXBElement<Response> createServiceConsumeNotifyReturn(Response value) {
		return new JAXBElement<Response>(_ServiceConsumeNotifyReturn_QNAME,
				Response.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link NotifyManagementInfoRsp }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://sp.ismp.chinatelecom.com", name = "notifyManagementInfoReturn")
	public JAXBElement<NotifyManagementInfoRsp> createNotifyManagementInfoReturn(
			NotifyManagementInfoRsp value) {
		return new JAXBElement<NotifyManagementInfoRsp>(
				_NotifyManagementInfoReturn_QNAME,
				NotifyManagementInfoRsp.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link NotifyManagementInfoReq }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://sp.ismp.chinatelecom.com", name = "notifyManagementInfoReq")
	public JAXBElement<NotifyManagementInfoReq> createNotifyManagementInfoReq(
			NotifyManagementInfoReq value) {
		return new JAXBElement<NotifyManagementInfoReq>(
				_NotifyManagementInfoReq_QNAME, NotifyManagementInfoReq.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://sp.ismp.chinatelecom.com", name = "spWithdrawSubscriptionReturn")
	public JAXBElement<Response> createSpWithdrawSubscriptionReturn(
			Response value) {
		return new JAXBElement<Response>(_SpWithdrawSubscriptionReturn_QNAME,
				Response.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link SPWithdrawSubscriptionReq }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://sp.ismp.chinatelecom.com", name = "spWithdrawSubscriptionReqPara")
	public JAXBElement<SPWithdrawSubscriptionReq> createSpWithdrawSubscriptionReqPara(
			SPWithdrawSubscriptionReq value) {
		return new JAXBElement<SPWithdrawSubscriptionReq>(
				_SpWithdrawSubscriptionReqPara_QNAME,
				SPWithdrawSubscriptionReq.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://sp.ismp.chinatelecom.com", name = "orderRelationUpdateNotifyReturn")
	public JAXBElement<Response> createOrderRelationUpdateNotifyReturn(
			Response value) {
		return new JAXBElement<Response>(
				_OrderRelationUpdateNotifyReturn_QNAME, Response.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link OrderRelationUpdateNotifyReq }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://sp.ismp.chinatelecom.com", name = "orderRelationUpdateNotifyReq")
	public JAXBElement<OrderRelationUpdateNotifyReq> createOrderRelationUpdateNotifyReq(
			OrderRelationUpdateNotifyReq value) {
		return new JAXBElement<OrderRelationUpdateNotifyReq>(
				_OrderRelationUpdateNotifyReq_QNAME,
				OrderRelationUpdateNotifyReq.class, null, value);
	}

}
