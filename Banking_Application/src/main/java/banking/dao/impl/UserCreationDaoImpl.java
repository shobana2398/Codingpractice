package banking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import banking.dao.UserCreationDao;
import banking.databaseconnection.PostgreConnection;


public class UserCreationDaoImpl implements UserCreationDao {

	final Connection con=PostgreConnection.postgeConnection();
	@Override
	public boolean createUser(int userid, String password) {
		
		int insertedRow = 0;
		String insertQuery = "insert into \"Login_Credentials\" (user_id,password) values (?, ?)";
		try ( con;PreparedStatement userInsert = con.prepareStatement(insertQuery);) {
			userInsert.setInt(1, userid);
			userInsert.setString(2, password);
			insertedRow=userInsert.executeUpdate();
			System.out.println("Successfully Inserted");
		}
		catch(SQLException e)
		{
			System.out.println("Error: "+ e.getMessage());
			System.out.println();
			return false;
		}
        if(insertedRow>0)
        {
        	return true;
        }
		return false;
	}
	
	@Override
	public boolean updatePassword(int userid, String oldPassword, String newPassword) {
		
		String fetchCurrentpassword = "select password from \"Login_Credentials\" where user_id=? ";
		try ( con;PreparedStatement fetchPassword = con.prepareStatement(fetchCurrentpassword);) {
			
			fetchPassword.setInt(1, userid);
			//userInsert.setString(2, password);
			ResultSet rs=fetchPassword.executeQuery();
			String currentpassword="";
			while(rs.next())
			{
				currentpassword=rs.getString(1);
			}
			if(currentpassword.equals(oldPassword))
			 {
				String updatePasswordquery = "update  \"Login_Credentials\" set password=? where user_id=? ";
				PreparedStatement updatePassword = con.prepareStatement(updatePasswordquery);
				
					updatePassword.setString(1, newPassword);
					updatePassword.setInt(2, userid);
					updatePassword.executeUpdate();
					System.out.println("Password updated");
				}
			}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
			
		

		

        
		return false;
	}
	}


