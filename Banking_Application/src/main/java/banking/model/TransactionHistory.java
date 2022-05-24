package banking.model;

import java.sql.Timestamp;

public class TransactionHistory {
	private int userId;
	private int accountNumber;
	private int debitAmount;
	private int creditAmount;
	private Timestamp transactionDate;
	public TransactionHistory()
	{
		
	}
	
	public TransactionHistory(int userId, int accountNumber, int debitAmount, int creditAmount, Timestamp transactionDate2) {
		super();
		this.userId = userId;
		this.accountNumber = accountNumber;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.transactionDate = transactionDate2;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(int debitAmount) {
		this.debitAmount = debitAmount;
	}
	public int getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "TransactionHistory [userId=" + userId + ", accountNumber=" + accountNumber + ", debitAmount="
				+ debitAmount + ", creditAmount=" + creditAmount + ", transactionDate=" + transactionDate + "]";
	}

}
