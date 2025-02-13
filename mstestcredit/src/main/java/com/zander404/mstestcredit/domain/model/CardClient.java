package com.zander404.mstestcredit.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardClient {
    private String name;
    private String band;
    private BigDecimal limitFree;
}
