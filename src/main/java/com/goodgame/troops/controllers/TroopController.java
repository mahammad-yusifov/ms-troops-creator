package com.goodgame.troops.controllers;

import com.goodgame.troops.model.response.TroopResponse;
import com.goodgame.troops.service.TroopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Log4j2
public class TroopController {

    private final TroopService troopService;

    @GetMapping(value = "/troop/{troopNumber}")
    public ResponseEntity<TroopResponse> generateTroop(@PathVariable Long troopNumber) {
        log.debug("troop generating start");
        TroopResponse troopResponse = troopService.generateTroop(troopNumber);
        log.debug("troop generating end");
        return ResponseEntity.ok(troopResponse);
    }
}
