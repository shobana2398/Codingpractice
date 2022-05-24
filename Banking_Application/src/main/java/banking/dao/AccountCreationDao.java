package banking.dao;

import java.util.List;

import banking.model.Account;

public interface AccountCreationDao {
	public boolean createAccount(Account account) throws Exception;
	public List<Account> viewAccount();

}
