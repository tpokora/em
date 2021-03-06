package org.tpokora.application.weather.services.storms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tpokora.application.weather.properties.StormProperties;
import org.tpokora.domain.weather.Location;
import org.tpokora.application.weather.storms.FindCityService;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

@ExtendWith(MockitoExtension.class)
public class FindLocationServiceTests extends StormServicesTests {

    public static final String TEST_CITY = "testCity";
    public static final Location EXPECTED_LOCATION = new Location(11.11, 22.22);

    @InjectMocks
    private FindCityService findCityService;

    @BeforeEach
    public void setup() {
        EXPECTED_LOCATION.setName(TEST_CITY);
    }

    @Test
    public void testFindCity() throws SOAPException {
        SOAPMessage response = generateCityResponse(EXPECTED_LOCATION);
        Mockito.when(stormProperties.getValue(StormProperties.KEY)).thenReturn(STORM_TEST_KEY);
        Mockito.when(soapService.sendSOAPMessage(ArgumentMatchers.any(), ArgumentMatchers.anyString())).thenReturn(response);
        Location location = findCityService.findCity(TEST_CITY);
        Assertions.assertEquals(EXPECTED_LOCATION.getName(), location.getName());
        Assertions.assertEquals(EXPECTED_LOCATION.getCoordinates().getLongitude(), location.getCoordinates().getLongitude());
        Assertions.assertEquals(EXPECTED_LOCATION.getCoordinates().getLatitude(), location.getCoordinates().getLatitude());
        Assertions.assertEquals(EXPECTED_LOCATION.toString(), location.toString());
    }
}
