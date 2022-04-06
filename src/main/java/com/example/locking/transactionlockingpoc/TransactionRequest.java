package com.example.locking.transactionlockingpoc;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionRequest {
    private String name;
    private int amt;

    public TransactionRequest(String name, int amt) {
        this.name = name;
        this.amt = amt;
    }
}
