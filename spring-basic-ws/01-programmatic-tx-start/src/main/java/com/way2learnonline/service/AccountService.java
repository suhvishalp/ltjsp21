package com.way2learnonline.service;

import java.sql.SQLException;
import java.util.List;

import com.way2learnonline.model.Account;

public interface AccountService {

	public Long debit(int amount,Long accountNumber) throws SQLException;
	public Long credit(int amount,Long accountNumber) throws SQLException, Exception;
	public void createNewAccount(Account account) throws SQLException;
	public void deActivateAccount(Long accountNumber)throws SQLException;
	public void activateAccount(Long accountNumber)throws SQLException;	
	public List<Account> getAllAccounts() throws SQLException;
}
