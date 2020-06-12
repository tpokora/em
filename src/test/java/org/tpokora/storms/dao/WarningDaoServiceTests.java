package org.tpokora.storms.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tpokora.common.services.BaseServiceTest;
import org.tpokora.storms.model.WarningEntity;
import org.tpokora.storms.model.WarningStrings;

import java.time.LocalDateTime;

public class WarningDaoServiceTests extends BaseServiceTest {

    @Autowired
    private WarningRepository warningRepository;

    private WarningDaoService warningDaoService;

    private WarningEntity WARNING_ENTITY;

    @BeforeEach
    public void setup() {
        warningDaoService = new WarningDaoService(warningRepository);
        WARNING_ENTITY = new WarningEntity();
        WARNING_ENTITY.setName(WarningStrings.FROST);
        WARNING_ENTITY.setLevel(1);
        WARNING_ENTITY.setStart(LocalDateTime.now());
        WARNING_ENTITY.setEnd(LocalDateTime.now().plusDays(2));
    }

    @Test
    public void testSaveWarningEntity() {
        WarningEntity savedWarningEntity = warningDaoService.save(WARNING_ENTITY);
        Assertions.assertEquals(WARNING_ENTITY.toString(), savedWarningEntity.toString());
    }
}