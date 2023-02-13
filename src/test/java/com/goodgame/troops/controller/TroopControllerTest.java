package com.goodgame.troops.controller;

import com.goodgame.troops.controllers.TroopController;
import com.goodgame.troops.model.response.TroopResponse;
import com.goodgame.troops.service.TroopService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TroopController.class)
public class TroopControllerTest {

    @InjectMocks
    private TroopController troopController;
    @Mock
    private TroopService troopService;
    private TroopResponse expectedResponse;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        expectedResponse = new TroopResponse(63L, 57L, 47L);
    }

    @Test
    public void testGenerateTroop() {
        when(troopService.generateTroop(167L)).thenReturn(expectedResponse);
        ResponseEntity<TroopResponse> response = troopController.generateTroop(167L);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(expectedResponse, response.getBody());
        verify(troopService).generateTroop(167L);
    }
}


