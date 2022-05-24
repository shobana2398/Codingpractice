package banking.model;

import java.util.Date;

public class Account {
	private int accountNumber;
	private String accountHoldername;
	private int userid;
	private int accountBalance;
	private Date accountCreationdate;
	private Date accountlastActivedate;
	private int dailyTransactionlimit;

	public Account() {

	}

	public Account(int accountNumber, String accountHoldername, int userid, int accountBalance,
			Date accountCreationdate,Date accountlastActivedate,int dailyLimit) {
		super();
		this.accountNumber = accountNumber;
		this.accountHoldername = accountHoldername;
		this.userid = userid;
		this.accountBalance = accountBalance;
		this.accountCreationdate = accountCreationdate;
		this.accountlastActivedate=accountlastActivedate;
		this.dailyTransactionlimit=dailyLimit;
	}

	public Date getAccountlastActivedate() {
		return accountlastActivedate;
	}

	public void setAccountlastActivedate(Date accountlastActivedate) {
		this.accountlastActivedate = accountlastActivedate;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHoldername() {
		return accountHoldername;
	}

	public void setAccountHoldername(String accountHoldername) {
		this.accountHoldername = accountHoldername;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getAccountCreationdate() {
		return accountCreationdate;
	}

	public void setAccountCreationdate(Date accountCreationdate) {
		this.accountCreationdate = accountCreationdate;
	}

	public int getDailyLimit() {
		return dailyTransactionlimit;
	}

	public void setDailyLimit(int dailyLimit) {
		this.dailyTransactionlimit = dailyLimit;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHoldername=" + accountHoldername + ", userid="
				+ userid + ", accountBalance=" + accountBalance + ", accountCreationdate=" + accountCreationdate
				+ ", accountlastActivedate=" + accountlastActivedate + ", dailyTransactionlimit="
				+ dailyTransactionlimit + "]";
	}

}
