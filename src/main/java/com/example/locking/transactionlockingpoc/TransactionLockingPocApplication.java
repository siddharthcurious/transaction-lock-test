package com.example.locking.transactionlockingpoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TransactionLockingPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionLockingPocApplication.class, args);
	}


	@Autowired
	private WalletRepository walletRepository;


	@Component
	public class ServerInitializer implements ApplicationRunner {

		@Override
		public void run(ApplicationArguments applicationArguments) throws Exception {

			walletRepository.save(new Wallet("sid", 1000));
			walletRepository.save(new Wallet("megan", 1000));
			walletRepository.save(new Wallet("bharath", 1000));
			walletRepository.save(new Wallet("raja", 1000));
			walletRepository.save(new Wallet("aswin", 1000));

		}
	}

}
