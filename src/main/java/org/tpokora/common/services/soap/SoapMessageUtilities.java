package org.tpokora.common.services.soap;

import com.sun.xml.messaging.saaj.soap.impl.ElementImpl;
import org.w3c.dom.Node;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SoapMessageUtilities {

    private SoapMessageUtilities() {}

    public static String elementValue(Node element, String name) {
        return ((ElementImpl) element).getElementsByTagName(name).item(0).getTextContent();
    }

    public static String soapMessageToString(SOAPMessage soapMessage) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            soapMessage.writeTo(output);
            return new String(output.toByteArray());
        } catch (SOAPException e) {
            return "SOAP Error";
        } catch (IOException e) {
            return "Message read Error";
        }
    }
}
