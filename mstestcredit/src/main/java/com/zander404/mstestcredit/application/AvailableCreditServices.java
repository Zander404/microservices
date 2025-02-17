package com.zander404.mstestcredit.application;

import com.zander404.mstestcredit.client.CardResourceClient;
import com.zander404.mstestcredit.client.ClientResourceClient;
import com.zander404.mstestcredit.domain.model.ClientSituation;
import com.zander404.mstestcredit.domain.model.DataClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvailableCreditServices {

    private final ClientResourceClient clientClient;
    private final CardResourceClient cardClient;

    public ClientSituation getClientSituation(String cpf) {
        try {


            ResponseEntity<DataClient> clientDataResponse = clientClient.clientData(cpf);
            return ClientSituation
                    .builder()
                    .client(clientDataResponse.getBody())
                    .build();
        }
        catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                return null;
            }

        }
    }
}
