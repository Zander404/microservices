package com.zander404.msclients.application;


import com.zander404.msclients.application.representation.ClientSaveRequest;

import com.zander404.msclients.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientResource {

    private final ClientService service;

    @GetMapping
    public String status(){
        return "OK";
    }


    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest request){
        var client = request.toModel();
        service.save(client);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }


    @GetMapping(params = "cpf")
    public ResponseEntity<Optional<Client>> infoClient(@RequestParam("cpf") String cpf){
        var client = service.getByCPF(cpf);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }


}
