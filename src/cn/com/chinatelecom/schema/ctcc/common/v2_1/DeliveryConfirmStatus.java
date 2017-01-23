package cn.com.chinatelecom.schema.ctcc.common.v2_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DeliveryConfirmStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="DeliveryConfirmStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Success"/>
 *     &lt;enumeration value="Fail"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeliveryConfirmStatus")
@XmlEnum
public enum DeliveryConfirmStatus {

	@XmlEnumValue("Success")
	SUCCESS("Success"), @XmlEnumValue("Fail")
	FAIL("Fail");
	private final String value;

	DeliveryConfirmStatus(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static DeliveryConfirmStatus fromValue(String v) {
		for (DeliveryConfirmStatus c : DeliveryConfirmStatus.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
