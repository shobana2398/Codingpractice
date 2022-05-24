package ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ecommerce.dao.OrderDao;
import ecommerce.dao.ProductDao;

public class OrderDaoImpl implements OrderDao {
	ProductDao productDaoImpl = new ProductDaoImpl();

	private final static String PASSWORD = "pass123";
	private final static String URL = "jdbc:postgresql://localhost:5432/Ecommerce-System";
	private final static String USER = "postgres";

	@Override
	public void createOrder(int customerid, int productid, int amount) {
		// TODO Auto-generated method stub

		String sql = "insert into \"Order\" (order_id,customer_id,product_id,bill_amount) values (nextval('order_sequence'), ?, ?, ?)";
		String str = "select product_quatity from \"Product\" where product_id=? ";

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement pInsert = con.prepareStatement(sql);
				PreparedStatement pUpdate = con.prepareStatement(str);) {
			con.setAutoCommit(false);

			pInsert.setInt(1, customerid);
			pInsert.setInt(2, productid);
			pInsert.setInt(3, amount);

			pInsert.executeUpdate();
			// pstmt.close();
			System.out.println();
			System.out.println("order created successfully");

			pUpdate.setInt(1, productid);

			ResultSet rs = pUpdate.executeQuery();

			int quan = 0;
			while (rs.next()) {
				quan = rs.getInt(1);
				System.out.println(quan);
			}
			int proid = productid;
			productDaoImpl.updateQuantity(proid, quan - 1);

			con.commit();

		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
		}

	}

}
