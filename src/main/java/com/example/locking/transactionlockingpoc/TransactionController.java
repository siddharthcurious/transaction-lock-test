package com.example.locking.transactionlockingpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction/credit")
    public String credit(TransactionRequest request) throws InterruptedException {
        transactionService.creditMoney(request.getName(), request.getAmt());
        return "CREDITED";
    }

    @PostMapping("/transaction/debit")
    public String debit(TransactionRequest request) throws InterruptedException {
        transactionService.debitMoney(request.getName(), request.getAmt());
        return "DEBITED";
    }
}
