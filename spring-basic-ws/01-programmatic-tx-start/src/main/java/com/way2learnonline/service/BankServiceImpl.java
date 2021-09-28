package com.way2learnonline.service;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


public class BankServiceImpl implements BankService {

	@Autowired private AccountService accountService;
	
	 
	@Autowired
	private PlatformTransactionManager txManager;

	
	public Long transfer(Long fromAccountNumber, Long toAccountNumber, int amount) throws SQLException {
		
		//start the transaction
		
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		TransactionStatus status =  txManager.getTransaction(definition);
		
		System.out.println("transfer() --- " + status.isNewTransaction()); //true
		
		try {
	
			//op1
			Long transactionId= accountService.debit(amount,fromAccountNumber);
			
			//op2
			accountService.credit(amount, toAccountNumber);

			txManager.commit(status);
			
			return transactionId;			
		
		}catch(Exception ex) {
			txManager.rollback(status);
			return null;
		}
				
				
	}
	
	
	

}
