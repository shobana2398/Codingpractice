package ecommerce.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecommerce.dao.CustomerDao;
import ecommerce.databse.PostgreConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void createCustomer(int id, String name) {
		
		 String sql = "insert into \"Customer\" (customer_name,customer_id) values (?, ?)";
	        try {
	            PreparedStatement pstmt = PostgreConnection.postgeConnection().prepareStatement(sql);
	            pstmt.setString(1, name);
	            pstmt.setInt(2,id);
	           
	            
	            pstmt.executeUpdate();
	            pstmt.close();
	            System.out.println();
	            System.out.println("Customer created successfully");
	        } catch (SQLException ex) {
	            System.out.println();
	            System.out.println("Error: "+ ex.getMessage());
	        }
	}

	
}
