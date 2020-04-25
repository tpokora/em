package org.tpokora.common.services.soap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.soap.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class SOAPServiceTests {

    @Mock
    private SOAPConnection soapConnection;

    public static final String TEST_NAMESPACE = "test";
    public static final String TEST_NAMESPACE_URI = "testNamespace";
    private SOAPService soapService;

    @Test
    public void testSoapServiceCreateSoapMessage() throws SOAPException {
        Assertions.assertNotNull(createSoapMessage());
    }

    @Test
    public void testSoapServiceCreateSoapEnvelope() throws SOAPException {
        SOAPMessage soapMessage = createSoapMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        Assertions.assertNull(soapEnvelope.getNamespaceURI(TEST_NAMESPACE));
        SOAPService.createSOAPEnvelope(soapMessage, createNamespaces());
        Assertions.assertEquals(TEST_NAMESPACE_URI, soapEnvelope.getNamespaceURI(TEST_NAMESPACE));
    }

    @Test
    public void testSoapServiceCreateSoapAction() throws SOAPException {
        String soapActionHeader = "SOAPAction";
        String testAction = "testAction";
        SOAPMessage soapMessage = createSoapMessage();
        MimeHeaders mimeHeaders = soapMessage.getMimeHeaders();
        String[] header = mimeHeaders.getHeader(soapActionHeader);
        Assertions.assertNull(header);

        SOAPService.createSOAPAction(soapMessage, testAction);
        header = mimeHeaders.getHeader(soapActionHeader);
        Assertions.assertEquals(testAction, header[0]);
    }

    private SOAPMessage createSoapMessage() throws SOAPException {
        return SOAPService.createSOAPMessage();
    }

    private Map<String, String> createNamespaces() {
        return Stream.of(new String[][] {
                {TEST_NAMESPACE, TEST_NAMESPACE_URI}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1] ));
    }
}