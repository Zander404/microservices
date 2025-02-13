package com.zander404.mscards.application.representation;

import com.zander404.mscards.domain.CardClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardClientResponse {
    private String name;
    private String band;
    private BigDecimal limitFree;

    public static CardClientResponse fromModel(CardClient model){
        return new CardClientResponse(
                model.getCard().getName(),
                model.getCard().getBand().toString(),
                model.getLimit()
        );
    }

}
