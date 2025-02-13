package com.zander404.mscards.application;

import com.zander404.mscards.domain.Card;
import com.zander404.mscards.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    @Transactional
    public Card save(Card card) {
        return repository.save(card);
    }


    public List<Card> getCardSavingLessThanEqual(Long saving) {
        var savings = BigDecimal.valueOf(saving);
        return repository.findBySavingsLessThanEqual(savings);
    }
}
