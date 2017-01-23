package cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface;

public class SendSmsProxy implements cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms {
  private String _endpoint = null;
  private cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms sendSms = null;
  
  public SendSmsProxy() {
    _initSendSmsProxy();
  }
  
  public SendSmsProxy(String endpoint) {
    _endpoint = endpoint;
    _initSendSmsProxy();
  }
  
  private void _initSendSmsProxy() {
    try {
      sendSms = (new cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1.service.SendSmsServiceLocator()).getSendSms();
      if (sendSms != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sendSms)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sendSms)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sendSms != null)
      ((javax.xml.rpc.Stub)sendSms)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.com.chinatelecom.www.wsdl.ctcc.sms.send.v2_1._interface.SendSms getSendSms() {
    if (sendSms == null)
      _initSendSmsProxy();
    return sendSms;
  }
  
  public java.lang.String sendSms(org.apache.axis.types.URI[] addresses, java.lang.String senderName, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ChargingInformation charging, java.lang.String message, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.SimpleReference receiptRequest) throws java.rmi.RemoteException, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.PolicyException, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ServiceException{
    if (sendSms == null)
      _initSendSmsProxy();
    return sendSms.sendSms(addresses, senderName, charging, message, receiptRequest);
  }
  
  public java.lang.String sendSmsLogo(org.apache.axis.types.URI[] addresses, java.lang.String senderName, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ChargingInformation charging, byte[] image, cn.com.chinatelecom.www.schema.ctcc.sms.v2_1.SmsFormat smsFormat, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.SimpleReference receiptRequest) throws java.rmi.RemoteException, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.PolicyException, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ServiceException{
    if (sendSms == null)
      _initSendSmsProxy();
    return sendSms.sendSmsLogo(addresses, senderName, charging, image, smsFormat, receiptRequest);
  }
  
  public java.lang.String sendSmsRingtone(org.apache.axis.types.URI[] addresses, java.lang.String senderName, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ChargingInformation charging, java.lang.String ringtone, cn.com.chinatelecom.www.schema.ctcc.sms.v2_1.SmsFormat smsFormat, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.SimpleReference receiptRequest) throws java.rmi.RemoteException, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.PolicyException, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ServiceException{
    if (sendSms == null)
      _initSendSmsProxy();
    return sendSms.sendSmsRingtone(addresses, senderName, charging, ringtone, smsFormat, receiptRequest);
  }
  
  public cn.com.chinatelecom.www.schema.ctcc.sms.v2_1.DeliveryInformation[] getSmsDeliveryStatus(java.lang.String requestIdentifier) throws java.rmi.RemoteException, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.PolicyException, cn.com.chinatelecom.www.schema.ctcc.common.v2_1.ServiceException{
    if (sendSms == null)
      _initSendSmsProxy();
    return sendSms.getSmsDeliveryStatus(requestIdentifier);
  }
  
  
}