package org.tpokora.storms.services;

import org.tpokora.common.services.soap.SOAPService;
import org.tpokora.common.services.soap.ISoapRequestMessageProcessor;
import org.tpokora.common.services.soap.ISoapResponseMessageProcessor;
import org.tpokora.config.properties.StormProperties;

public abstract class StormService {

    protected StormProperties stormProperties;

    protected ISoapRequestMessageProcessor soapRequestMessageProcessor;
    protected ISoapResponseMessageProcessor soapResponseMessageProcessor;

    protected SOAPService soapService;

    public StormService(StormProperties stormProperties, SOAPService soapService) {
        this.stormProperties = stormProperties;
        this.soapService = soapService;
    }
}
