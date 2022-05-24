package banking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import banking.dao.TransactionDao;
import banking.dao.TransactionHistoryDao;
import banking.databaseconnection.PostgreConnection;
import banking.exception.DailyLimitExceed;
import banking.exception.InsufficientBalance;
import banking.model.TransactionHistory;

public class TransactionDaoImpl implements TransactionDao {

	final Connection con = PostgreConnection.postgeConnection();
	TransactionHistoryDao transactionHistoryImpl = new TransactionHistoryDaoImpl();
	TransactionHistory transactionHistory = new TransactionHistory();

	@Override
	public boolean debitAmount(int accNumber, int debitAmount) {

		String getdailyTranlimitQuery = "select daily_transaction_limit from \"Account\" where account_number=?";
		String currentAccBalanceqQuery = "Select account_balance from \"Account\" where account_number=?";
		String updateAccBalanceQuery = "update \"Account\" set account_balance=? where account_number=?";
		String updateLastActivetimeQuery = "update \"Account\" set account_lastactive_date=? where account_number=?";

		try (con;
				PreparedStatement getTransactionLimit = con.prepareStatement(getdailyTranlimitQuery);
				PreparedStatement currentBalance = con.prepareStatement(currentAccBalanceqQuery);
				PreparedStatement updateBalance = con.prepareStatement(updateAccBalanceQuery);
				PreparedStatement updateLastActivity = con.prepareStatement(updateLastActivetimeQuery);) {

			getTransactionLimit.setInt(1, accNumber);
			ResultSet rs = getTransactionLimit.executeQuery();
			int dailylimit = 0;
			while (rs.next()) {
				dailylimit = rs.getInt(1);
			}
			currentBalance.setInt(1, accNumber);
			ResultSet balanceResult = currentBalance.executeQuery();
			int currentBalanc = 0;
			while (balanceResult.next()) {
				currentBalanc = balanceResult.getInt(1);
			}
			try {
				if (currentBalanc < debitAmount) {
					throw new InsufficientBalance("Can't transfer amount insufficient balanace");

				}
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
			try {
				if (debitAmount < dailylimit) {
					updateBalance.setInt(1, currentBalanc - debitAmount);
					updateBalance.setInt(2, accNumber);
					updateBalance.executeUpdate();
				} else {
					throw new DailyLimitExceed("Daily Limit exceed please update daily limito proceed");
				}
				// throw
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
			updateLastActivity.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			updateLastActivity.setInt(2, accNumber);
			updateLastActivity.executeUpdate();

			transactionHistory.setAccountNumber(accNumber);
			transactionHistory.setUserId(102);
			transactionHistory.setDebitAmount(debitAmount);

			transactionHistoryImpl.createTransactionHistory(transactionHistory);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;

	}

	@Override
	public boolean creditAmount(int accNumber, int creditAmount) {
		String currentBalanceQuery = "select account_balance from \"Account\" where account_number=?";
		String CreditAmountQuery = "update \"Account\" set account_balance=? where account_number=?";
		String updateLastActivetimeQuery = "update \"Account\" set account_lastactive_date=? where account_number=?";

		try (con;
				PreparedStatement currentBalance = con.prepareStatement(currentBalanceQuery);
				PreparedStatement creditedAmount = con.prepareStatement(CreditAmountQuery);
				PreparedStatement updateLastActivity = con.prepareStatement(updateLastActivetimeQuery);) {
			currentBalance.setInt(1, accNumber);
			ResultSet balanceResult = currentBalance.executeQuery();
			int currentBal = 0;
			while (balanceResult.next()) {
				currentBal = balanceResult.getInt(1);
			}

			creditedAmount.setInt(1, creditAmount + currentBal);
			creditedAmount.setInt(2, accNumber);
			creditedAmount.executeUpdate();
			System.out.println("Amount credited Successfully");

			updateLastActivity.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			updateLastActivity.setInt(2, accNumber);
			updateLastActivity.executeUpdate();

			transactionHistory.setAccountNumber(accNumber);
			transactionHistory.setUserId(102);
			transactionHistory.setCreditAmount(creditAmount);

			transactionHistoryImpl.createTransactionHistory(transactionHistory);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	@Override
	public boolean moneyTransfer(int debitAccount, int creditAccount, int transferAmount) {
		//eddhuku 3 query? pls try to put in single query //tried but got some error will tell you in phone ok
		String getdailyTranlimitQuery = "select daily_transaction_limit from \"Account\" where account_number=?";
		String currentAccBalanceqQuery = "Select account_balance from \"Account\" where account_number=?";
		String currentCreditAccBalanceqQuery = "Select account_balance from \"Account\" where account_number=?";//why we need to get?
		String updateDebitAccountQuery = "update \"Account\" set account_balance=? where account_number=?";
		String updateLastActivetimeQuery = "update \"Account\" set account_lastactive_date=? where account_number=?";
		String updateCreditAccountQuery = "update \"Account\" set account_balance=? where account_number=?";

		try (con;
				PreparedStatement getTransactionLimit = con.prepareStatement(getdailyTranlimitQuery);
				PreparedStatement currentBalance = con.prepareStatement(currentAccBalanceqQuery);
				PreparedStatement updateDebitAccountBalance = con.prepareStatement(updateDebitAccountQuery);
				PreparedStatement updateLastActivity = con.prepareStatement(updateLastActivetimeQuery);
				PreparedStatement currentCreditAccountBalance = con.prepareStatement(currentCreditAccBalanceqQuery);
				PreparedStatement updateCreditAccountBalance = con.prepareStatement(updateCreditAccountQuery);)
		{
			
			/* Transaction Limit find for Debit ACcount */// exception package yaru create pannuva nanthan
			getTransactionLimit.setInt(1, debitAccount);
			ResultSet rs = getTransactionLimit.executeQuery();
			int dailyLimit = 0;
			while (rs.next()) {
				dailyLimit = rs.getInt(1);
			}
			//System.out.println(dailyLimit);

			/* Current Balance Check for Debit ACccount */
			currentBalance.setInt(1, debitAccount);
			ResultSet balanceResult = currentBalance.executeQuery();
			int currentDebitAccountBalance = 0;
			while (balanceResult.next()) {
				currentDebitAccountBalance = balanceResult.getInt(1);
			}
			
			/*Sufficient Balance Check for Debit Account*/
			try {
				if (currentDebitAccountBalance < transferAmount) {
					throw new InsufficientBalance("Can't transfer amount insufficient balanace");

				}
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
			
			/*Debit Account daily limit comparison */
			try {
				if (transferAmount < dailyLimit) {
					updateDebitAccountBalance.setInt(1, currentDebitAccountBalance - transferAmount);
					updateDebitAccountBalance.setInt(2, debitAccount);
					updateDebitAccountBalance.executeUpdate();
				} else {
					throw new DailyLimitExceed("Daily Limit exceed please update daily limito proceed");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
			
			/*Get Account balance for credit ACCount*/
			currentCreditAccountBalance.setInt(1, creditAccount);
			ResultSet creditBalanceResult = currentCreditAccountBalance.executeQuery();
			int currentCreditAccountBalances = 0;
			while (creditBalanceResult.next()) {
				currentCreditAccountBalances = creditBalanceResult.getInt(1);
			}
			
			updateLastActivity.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			updateLastActivity.setInt(2, debitAccount);
			updateLastActivity.executeUpdate();

			/* Update Account balance for Credit Account*/
			updateCreditAccountBalance.setInt(1, currentCreditAccountBalances + transferAmount);
			updateCreditAccountBalance.setInt(2, creditAccount);
			updateCreditAccountBalance.executeUpdate();

			/*Create Entry in Account_Transaction table*/
			transactionHistory.setAccountNumber(debitAccount);
			transactionHistory.setUserId(102);
			transactionHistory.setDebitAmount(transferAmount);
			transactionHistoryImpl.createTransactionHistory(transactionHistory);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

}



