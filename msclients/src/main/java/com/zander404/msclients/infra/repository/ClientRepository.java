package com.zander404.msclients.infra.repository;

import com.zander404.msclients.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> { }
