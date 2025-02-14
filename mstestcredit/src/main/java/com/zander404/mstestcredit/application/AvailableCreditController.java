package com.zander404.mstestcredit.application;

import com.zander404.mstestcredit.domain.model.ClientSituation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("available-credit")
@RequiredArgsConstructor
public class AvailableCreditController {

     private final AvailableCreditServices availableCreditServices;
    @GetMapping
    public String status(){
        return "OK";
    }

    @GetMapping(value = "client-situation", params = "cpf")
    public ResponseEntity<ClientSituation> consultClientSituation(@RequestParam("cpf") String cpf){

        ClientSituation clientSituation = availableCreditServices.getClientSituation(cpf);
        return ResponseEntity.ok(clientSituation);
    }


}
