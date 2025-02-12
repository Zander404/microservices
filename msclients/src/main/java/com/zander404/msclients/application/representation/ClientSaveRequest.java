package com.zander404.msclients.application.representation;

import com.zander404.msclients.domain.Client;

public class ClientSaveRequest {

    private String cpf;
    private String name;
    private Integer age;

    public Client toModel(){
        return new Client(cpf, name, age);
    }
}
