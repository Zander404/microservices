package com.zander404.mscards.application;

import com.zander404.mscards.domain.CardClient;
import com.zander404.mscards.infra.repository.CardClientRepository;
import com.zander404.mscards.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardClientService {
    private final CardClientRepository repository;

    public List<CardClient> listCardByCpf(String cpf){
        return repository.findByCpf(cpf);

    }

}
