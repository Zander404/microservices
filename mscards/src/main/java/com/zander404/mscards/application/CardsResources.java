package com.zander404.mscards.application;


import com.zander404.mscards.application.representation.CardClientResponse;
import com.zander404.mscards.application.representation.CardSaveRequest;
import com.zander404.mscards.domain.Card;
import com.zander404.mscards.domain.CardClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardsResources {

    public final CardService cardService;
    public final CardClientService cardClientService;

    @GetMapping
    public String status() {
        return "OK";
    }

    @PostMapping
    public ResponseEntity registerCard(@RequestBody CardSaveRequest request) {
        Card card = request.toModel();
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping(params = "savings")
    public ResponseEntity<List<Card>> getCardsWithSavingAteh(@RequestParam("savings") Long savings) {
        List<Card> list = cardService.getCardSavingLessThanEqual(savings);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf ")
    public ResponseEntity<List<CardClientResponse>> getCardsByClient(@RequestParam("cpf") String cpf) {
        List<CardClient> list = cardClientService.listCardByCpf(cpf);
        List<CardClientResponse> responses = list.stream().map(CardClientResponse::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
