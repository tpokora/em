package org.tpokora.weather.dao;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tpokora.weather.model.Coordinates;
import org.tpokora.weather.model.WarningEntity;
import org.tpokora.weather.common.WarningStrings;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class WarningDaoServiceMockitoTests {

    @Mock
    private IWarningRepository warningRepository;

    @InjectMocks
    private WarningDaoService warningDaoService;

    private Coordinates coordinates;
    private WarningEntity WARNING_ENTITY = new WarningEntity();

    @BeforeEach
    public void setup() {
        coordinates = new Coordinates(11.11, 22.22);
        WARNING_ENTITY = new WarningEntity();
        WARNING_ENTITY.setId(1);
        WARNING_ENTITY.setLongitude(coordinates.getX());
        WARNING_ENTITY.setLatitude(coordinates.getY());
        WARNING_ENTITY.setName(WarningStrings.FROST);
        WARNING_ENTITY.setLevel(1);
        WARNING_ENTITY.setStart(LocalDateTime.now());
        WARNING_ENTITY.setEnd(LocalDateTime.now().plusDays(2));
    }

    @Test
    public void testSaveWarningEntity() {
        Mockito.when(warningRepository.save(any())).thenReturn(WARNING_ENTITY);
        Optional<WarningEntity> savedWarningEntity = warningDaoService.save(WARNING_ENTITY);
        Assertions.assertEquals(WARNING_ENTITY.toString(), savedWarningEntity.get().toString());
    }
}