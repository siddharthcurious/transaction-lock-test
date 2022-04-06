package com.example.locking.transactionlockingpoc;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "locking_wallets")
@Data
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    private int balance;

    public Wallet(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
}
