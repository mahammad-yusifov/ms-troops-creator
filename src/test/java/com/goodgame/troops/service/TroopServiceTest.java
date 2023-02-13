package com.goodgame.troops.service;

import com.goodgame.troops.model.response.TroopResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TroopServiceTest {

    @InjectMocks
    private TroopService troopService;

    @Test
    public void testGenerateTroop() {
        Long troopNumber = 1000L;
        TroopResponse response = troopService.generateTroop(troopNumber);
        Assertions.assertTrue(response.getSpearmen() <= troopNumber);
        Assertions.assertTrue(response.getSwordsmen() <= troopNumber - response.getSpearmen());
        Assertions.assertTrue(response.getArchers() <= troopNumber - response.getSpearmen()
                - response.getSwordsmen());
    }
}
