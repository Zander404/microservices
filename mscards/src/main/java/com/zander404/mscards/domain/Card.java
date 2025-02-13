package com.zander404.mscards.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor

public class Card {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private BandCard band;

    private BigDecimal savings;
    private BigDecimal basicLimit;

    public Card(String name, BandCard band, BigDecimal savings, BigDecimal basicLimit) {
        this.name = name;
        this.band = band;
        this.savings = savings;
        this.basicLimit = basicLimit;
    }


}
