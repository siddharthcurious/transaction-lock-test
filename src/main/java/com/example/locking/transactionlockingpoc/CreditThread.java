package com.example.locking.transactionlockingpoc;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class CreditThread implements Runnable {
    @Override
    public void run() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        TransactionRequest request = new TransactionRequest("sid", 100);
        HttpEntity<TransactionRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<String> res = restTemplate.exchange(
                "http://localhost:9099/transaction/credit",
                HttpMethod.POST,
                entity,
                String.class
        );
        System.out.println(res.getBody());
    }
}
