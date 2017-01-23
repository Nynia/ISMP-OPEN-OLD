/**
 * SendSmsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service;

public class SendSmsServiceLocator extends org.apache.axis.client.Service implements cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsService {

    public SendSmsServiceLocator() {
    }

    //说 明 ： 构 造 函 数 可 以 通 过 设 置 EngineConfiguration 的 方 式 ， 构 造 一 个SendSmsServiceLocator
    public SendSmsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    //说明：构造函数，可以通过设置 wsdl 地址和 QName 来构造 Client
    public SendSmsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SendSms
    private java.lang.String SendSms_address = "http://localhost:9080/SendSmsService/services/SendSms";

    //说明：返回 SendSms 的接口地址
    public java.lang.String getSendSmsAddress() {
        return SendSms_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SendSmsWSDDServiceName = "SendSms";

    //说明：返回服务名称，这里固定返回 SendSms
    public java.lang.String getSendSmsWSDDServiceName() {
        return SendSmsWSDDServiceName;
    }
    
    //说明：设置服务名称
    public void setSendSmsWSDDServiceName(java.lang.String name) {
        SendSmsWSDDServiceName = name;
    }

    //说明：返回发送短信接口方法。可以通过该方法得到一个实际可以发送短信的类SendSms
    public cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms getSendSms() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SendSms_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSendSms(endpoint);
    }

    //说明：返回发送短信接口方法。可以通过该方法得到一个实际可以发送短信的类SendSms
    public cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms getSendSms(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsBindingStub _stub = new cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsBindingStub(portAddress, this);
            _stub.setPortName(getSendSmsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    //说明：设置服务器端 WebService 地址
    public void setSendSmsEndpointAddress(java.lang.String address) {
        SendSms_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    //说明：返回 Webservice 端口
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsBindingStub _stub = new cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsBindingStub(new java.net.URL(SendSms_address), this);
                _stub.setPortName(getSendSmsWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    //说明：返回 Webservice 端口
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SendSms".equals(inputPortName)) {
            return getSendSms();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    //说明：返回 QName 方式表示的服务名称
    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "SendSmsService");
    }

    private java.util.HashSet ports = null;

    //说明：返回端口
    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.chinatelecom.com.cn/wsdl/ctcc/sms/send/v2_1/service", "SendSms"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    //说明：设置请求地址
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
    	if ("SendSms".equals(portName)) {
            setSendSmsEndpointAddress(address);
        }
        else 
        { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    //说明：通过 QName 方式设置请求地址
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
