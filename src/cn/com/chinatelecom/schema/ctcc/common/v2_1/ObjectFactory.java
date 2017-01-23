package cn.com.chinatelecom.schema.ctcc.common.v2_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the
 * cn.com.chinatelecom.schema.ctcc.common.v2_1 package.
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

	private final static QName _RequestSOAPHeader_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1",
			"RequestSOAPHeader");
	private final static QName _NotifySOAPHeader_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1",
			"NotifySOAPHeader");
	private final static QName _ServiceException_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1",
			"ServiceException");
	private final static QName _PolicyException_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1",
			"PolicyException");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package:
	 * cn.com.chinatelecom.schema.ctcc.common.v2_1
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link RequestSOAPHeader }
	 * 
	 */
	public RequestSOAPHeader createRequestSOAPHeader() {
		return new RequestSOAPHeader();
	}

	/**
	 * Create an instance of {@link SimpleReference }
	 * 
	 */
	public SimpleReference createSimpleReference() {
		return new SimpleReference();
	}

	/**
	 * Create an instance of {@link TimeMetric }
	 * 
	 */
	public TimeMetric createTimeMetric() {
		return new TimeMetric();
	}

	/**
	 * Create an instance of {@link ChargingInformation }
	 * 
	 */
	public ChargingInformation createChargingInformation() {
		return new ChargingInformation();
	}

	/**
	 * Create an instance of {@link ServiceException }
	 * 
	 */
	public ServiceException createServiceException() {
		return new ServiceException();
	}

	/**
	 * Create an instance of {@link NotifySOAPHeader }
	 * 
	 */
	public NotifySOAPHeader createNotifySOAPHeader() {
		return new NotifySOAPHeader();
	}

	/**
	 * Create an instance of {@link PolicyException }
	 * 
	 */
	public PolicyException createPolicyException() {
		return new PolicyException();
	}

	/**
	 * Create an instance of {@link ServiceError }
	 * 
	 */
	public ServiceError createServiceError() {
		return new ServiceError();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link RequestSOAPHeader }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", name = "RequestSOAPHeader")
	public JAXBElement<RequestSOAPHeader> createRequestSOAPHeader(
			RequestSOAPHeader value) {
		return new JAXBElement<RequestSOAPHeader>(_RequestSOAPHeader_QNAME,
				RequestSOAPHeader.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link NotifySOAPHeader }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", name = "NotifySOAPHeader")
	public JAXBElement<NotifySOAPHeader> createNotifySOAPHeader(
			NotifySOAPHeader value) {
		return new JAXBElement<NotifySOAPHeader>(_NotifySOAPHeader_QNAME,
				NotifySOAPHeader.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ServiceException }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", name = "ServiceException")
	public JAXBElement<ServiceException> createServiceException(
			ServiceException value) {
		return new JAXBElement<ServiceException>(_ServiceException_QNAME,
				ServiceException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PolicyException }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", name = "PolicyException")
	public JAXBElement<PolicyException> createPolicyException(
			PolicyException value) {
		return new JAXBElement<PolicyException>(_PolicyException_QNAME,
				PolicyException.class, null, value);
	}

}
