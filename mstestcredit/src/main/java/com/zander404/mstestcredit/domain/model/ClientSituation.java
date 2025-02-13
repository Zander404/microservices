package com.zander404.mstestcredit.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class ClientSituation {
    private DataClient client;
    private List<CardClient> cards;
}
