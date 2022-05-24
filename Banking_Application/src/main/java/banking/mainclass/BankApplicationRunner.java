package banking.mainclass;

import java.util.Scanner;

import banking.dao.AccountCreationDao;
import banking.dao.TransactionDao;
import banking.dao.TransactionHistoryDao;
import banking.dao.UserCreationDao;
import banking.dao.impl.AccountCreationDaoImpl;
import banking.dao.impl.TransactionDaoImpl;
import banking.dao.impl.TransactionHistoryDaoImpl;
import banking.dao.impl.UserCreationDaoImpl;
import banking.model.Account;

public class BankApplicationRunner {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		//public boolean inputvalidation() {
		// TODO Auto-generated method stub
		
		UserCreationDao userdaoimpl=new UserCreationDaoImpl();
		//System.out.println("Enter userid and password");
		/*int userid=sc.nextInt();
		String password=sc.next();
		
		userdaoimpl.createUser(userid, password);
		System.out.println("Enter id,oldpass,newpass");
		int uid=sc.nextInt();
		String oldpassword=sc.next();
		String newpassword=sc.next();
		userdaoimpl.updatePassword(uid, oldpassword, newpassword);*/
		AccountCreationDao accountcreationdao=new AccountCreationDaoImpl();
	/*	Account account = new Account();
		account.setAccountBalance(50000);
		account.setAccountHoldername("Sornakumari");
		
		account.setAccountNumber(135223);
		int aclength=0;
		int acnumber=account.getAccountNumber();
		
		
		account.setUserid(103);
		account.setDailyLimit(25000);
		accountcreationdao.createAccount(account);*/
		TransactionDao transactionDaoImpl=new TransactionDaoImpl();
		int debitAccountNumber=135221;
		int creditAccountNumber=135222;
		int transferAmount=10000;
		try {
			int len=String.valueOf(debitAccountNumber).length();
			if(len<6)
			{
				throw new AccountLengthException("Account length minimum should be 6");
			}
		}
		catch(AccountLengthException e)
		{
			System.out.println(e.getMessage());
			//return false;
		}
		int debitAmount=50000;
	//transactionDaoImpl.debitAmount(accountNumber,debitAmount);
	transactionDaoImpl.moneyTransfer(debitAccountNumber, creditAccountNumber, transferAmount);
	//	transactionDaoImpl.creditAmount(135222, 2000);
//transactionDaoImpl.creditAmount(135222, 5000);
	//	return true;
	//TransactionHistoryDao transactionHistoryDaoImpl=new TransactionHistoryDaoImpl();
	//System.out.println(transactionHistoryDaoImpl.viewTransactionHistory(accountnumber).toString());

	
	}
}

class AccountLengthException extends Exception
{
  public AccountLengthException(String message)
  {
    super(message);
  }
}