package banking.dao;

import java.util.List;

import banking.model.TransactionHistory;

public interface TransactionHistoryDao {
	public  boolean createTransactionHistory(TransactionHistory transactionHistory);
	
	public List<TransactionHistory> viewTransactionHistory(int accountNumber);
}
