package cn.com.chinatelecom.schema.ctcc.sms.v2_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DeliveryStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="DeliveryStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DeliveredToNetwork"/>
 *     &lt;enumeration value="DeliveryUncertain"/>
 *     &lt;enumeration value="DeliveryImpossible"/>
 *     &lt;enumeration value="MessageWaiting"/>
 *     &lt;enumeration value="DeliveredToTerminal"/>
 *     &lt;enumeration value="DeliveryNotificationNotSupported"/>
 *     &lt;enumeration value="AuthPriceFailed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeliveryStatus")
@XmlEnum
public enum DeliveryStatus {

	@XmlEnumValue("DeliveredToNetwork")
	DELIVERED_TO_NETWORK("DeliveredToNetwork"), @XmlEnumValue("DeliveryUncertain")
	DELIVERY_UNCERTAIN("DeliveryUncertain"), @XmlEnumValue("DeliveryImpossible")
	DELIVERY_IMPOSSIBLE("DeliveryImpossible"), @XmlEnumValue("MessageWaiting")
	MESSAGE_WAITING("MessageWaiting"), @XmlEnumValue("DeliveredToTerminal")
	DELIVERED_TO_TERMINAL("DeliveredToTerminal"), @XmlEnumValue("DeliveryNotificationNotSupported")
	DELIVERY_NOTIFICATION_NOT_SUPPORTED("DeliveryNotificationNotSupported"), @XmlEnumValue("AuthPriceFailed")
	AUTH_PRICE_FAILED("AuthPriceFailed");
	private final String value;

	DeliveryStatus(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static DeliveryStatus fromValue(String v) {
		for (DeliveryStatus c : DeliveryStatus.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
