package com.example.locking.transactionlockingpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void creditMoney(String name, int amt) throws InterruptedException {
        Wallet wallet = walletRepository.findByName(name);
        Transaction txn = new Transaction();
        int availAmt = wallet.getBalance();
        int newAmt = availAmt + amt;
        //Thread.sleep(1000);
        wallet.setBalance(newAmt);
        txn.setAmount(amt);
        txn.setName(name);
        txn.setTxnType("CREDIT");
        txn.setWallet(wallet);
        walletRepository.save(wallet);
        transactionRepository.save(txn);
    }

    public void debitMoney(String name, int amt) throws InterruptedException {
        Wallet wallet = walletRepository.findByName(name);
        Transaction txn = new Transaction();
        int availAmt = wallet.getBalance();
        int newAmt = availAmt  - amt;
        //Thread.sleep(1000);
        wallet.setBalance(newAmt);
        txn.setAmount(amt);
        txn.setName(name);
        txn.setTxnType("DEBIT");
        txn.setWallet(wallet);
        walletRepository.save(wallet);
        transactionRepository.save(txn);
    }
}
