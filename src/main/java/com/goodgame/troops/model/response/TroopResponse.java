package com.goodgame.troops.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TroopResponse {
    private Long spearmen;
    private Long swordsmen;
    private Long archers;
}
