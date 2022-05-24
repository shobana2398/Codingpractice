package banking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import banking.dao.TransactionHistoryDao;
import banking.databaseconnection.PostgreConnection;
import banking.model.Account;
import banking.model.TransactionHistory;

public class TransactionHistoryDaoImpl implements TransactionHistoryDao {
	final Connection con = PostgreConnection.postgeConnection();
	@Override
	public boolean createTransactionHistory(TransactionHistory transactionHistory) {
		 {
			
	String insertAccountTransactionQuery = "insert into \"Account_Transaction_History\" (user_id,account_number,debit_amount,credit_amount,transaction_date)"
					+ "values (?, ?, ?, ?, ?)";
			try (con;PreparedStatement addTransactionHistory = con.prepareStatement(insertAccountTransactionQuery);) 
			{
				addTransactionHistory.setInt(1, transactionHistory.getUserId());
				addTransactionHistory.setInt(2, transactionHistory.getAccountNumber());
				addTransactionHistory.setInt(3, transactionHistory.getDebitAmount());
				addTransactionHistory.setInt(4, transactionHistory.getCreditAmount());
				addTransactionHistory.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
	            addTransactionHistory.executeUpdate();
			
		}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
			return false;

	}
	}
	@Override
	public List<TransactionHistory> viewTransactionHistory(int accountNumber) {
		
		List<TransactionHistory> transactionHistory1 = new ArrayList<>();
		String viewTransactionHistoryQuery = "select * from \"Account_Transaction_History\" where account_number=?";
		try (con;
				PreparedStatement transactionsHistory2 = con.prepareStatement(viewTransactionHistoryQuery);) {
			transactionsHistory2.setInt(1, accountNumber);
			ResultSet resultTransactionHistory = transactionsHistory2.executeQuery();

			while (resultTransactionHistory.next()) {
				int userId = resultTransactionHistory.getInt(1);
				int accountsNumber= resultTransactionHistory.getInt(2);
				int debitAmount = resultTransactionHistory.getInt(3);
				int creditAmount = resultTransactionHistory.getInt(4);
				Timestamp transactionDate=resultTransactionHistory.getTimestamp(5);
				

				transactionHistory1.add(new TransactionHistory(userId, accountsNumber, debitAmount, creditAmount,transactionDate));
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return transactionHistory1;
	}

}
