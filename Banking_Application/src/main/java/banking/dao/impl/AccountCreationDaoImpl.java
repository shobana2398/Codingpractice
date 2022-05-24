package banking.dao.impl;

//import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import banking.dao.AccountCreationDao;
import banking.databaseconnection.PostgreConnection;
import banking.model.Account;


public class AccountCreationDaoImpl implements AccountCreationDao {
	final Connection con=PostgreConnection.postgeConnection();
	
	@Override
	 
	public boolean createAccount(Account account) throws Exception{
		
			String insertaccountQuery = "insert into \"Account\" (account_number,accounthoder_name,user_id,account_balance,account_creation_date,account_lastactive_date,daily_transaction_limit)"
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			try (con;PreparedStatement accountCreate = con.prepareStatement(insertaccountQuery);) {
				accountCreate.setInt(1,account.getAccountNumber());

				try {
					int acnumber=account.getAccountNumber();
					int aclength = String.valueOf(acnumber).length();
			if(aclength<6);
			{
				throw new Exception();
			}
			}catch(Exception e)
				{
				System.out.println("Account number length should be zero");
			}
				
				accountCreate.setString(2, account.getAccountHoldername());
				accountCreate.setInt(3,account.getUserid());
				accountCreate.setInt(4, account.getAccountBalance());
				accountCreate.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
				//(5, new Timestamp(date.getTime()));
				accountCreate.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
				//insertedRow=userInsert.executeUpdate();
				accountCreate.setInt(7,account.getDailyLimit());
				accountCreate.executeUpdate();
				System.out.println("Successfully Inserted");
		
	}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			return false;
	}
	@Override
	public List<Account> viewAccount() {
			List<Account> accountDetail = new ArrayList<>();
			String viewaccountQuery = "select * from \"Account\"";
			try (con;
					PreparedStatement pView = con.prepareStatement(viewaccountQuery);) {

				ResultSet resultAccount = pView.executeQuery();

				while (resultAccount.next()) {
					int account_number = resultAccount.getInt(1);
					String accountholder_name = resultAccount.getString(2);
					int user_id = resultAccount.getInt(3);
					int account_balance = resultAccount.getInt(4);
					Timestamp account_creation_date=resultAccount.getTimestamp(5);
					Timestamp account_lastactive_date=resultAccount.getTimestamp(6);
					int daily_transaction_limit=resultAccount.getInt(7);

					accountDetail.add(new Account(account_number, accountholder_name, user_id, account_balance,account_creation_date,account_lastactive_date,daily_transaction_limit));
				}
			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}
			return accountDetail;

		
	}
}
