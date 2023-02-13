package com.goodgame.troops.service;

import com.goodgame.troops.model.response.TroopResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TroopService {

    protected long spearmen, remaining, swordsmen;

    public TroopResponse generateTroop(Long troopNumber) {
        Random random = new Random();
        spearmen = random.nextLong(troopNumber);
        remaining = troopNumber - spearmen;
        swordsmen = random.nextLong(remaining);
        remaining -= swordsmen;
        return TroopResponse.builder()
                .archers(remaining)
                .spearmen(spearmen)
                .swordsmen(swordsmen)
                .build();
    }
}
