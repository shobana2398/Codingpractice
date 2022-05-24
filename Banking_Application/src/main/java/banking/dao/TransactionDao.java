package banking.dao;

public interface TransactionDao {
	public boolean debitAmount(int accnumber, int debitAmount);

	public boolean creditAmount(int accnumber, int creditAmount);

	public boolean moneyTransfer(int debitAccount, int creditAccount, int transferAmount);

}
