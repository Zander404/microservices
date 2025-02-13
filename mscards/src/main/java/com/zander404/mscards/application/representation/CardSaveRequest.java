package com.zander404.mscards.application.representation;

import com.zander404.mscards.domain.BandCard;
import com.zander404.mscards.domain.Card;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;
    private BandCard band;
    private BigDecimal savings;
    private BigDecimal limit;


    public Card toModel(){
        return new Card(name, band, savings, limit);

    }
}
