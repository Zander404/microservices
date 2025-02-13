package com.zander404.mscards.infra.repository;

import com.zander404.mscards.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findBySavingsLessThanEqual(BigDecimal savings);
}
