package com.zander404.msclients.application;

import com.zander404.msclients.domain.Client;
import com.zander404.msclients.infra.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    @Transactional
    public Client save(Client client) {
        return repository.save(client);
    }

    public Optional<Client> getByCPF(String cpf) {
        return repository.findByCpf(cpf);

    }

}
