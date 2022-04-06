package com.example.locking.transactionlockingpoc;

public class ThreadedMain {
    public static void main(String[] args) {
        Thread t1 = new Thread(new CreditThread());
        t1.start();
    }
}
