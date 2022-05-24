package ecommerce.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.dao.ProductDao;
import ecommerce.databse.PostgreConnection;
import ecommerce.model.Product;

public class ProductDaoImpl implements ProductDao {

	

	final Connection con=PostgreConnection.postgeConnection();
	public boolean addProduct(int productId, String productName, int productPrice, int productQuantity) {

		
		int isInsert = 0;
		String insertQuery = "insert into \"Product\" (product_id,product_name,product_price,product_quatity) values (?, ?, ?, ?)";
		try ( con;PreparedStatement pInsert = con.prepareStatement(insertQuery);) {

			pInsert.setInt(1, productId);
			pInsert.setString(2, productName);
			pInsert.setInt(3, productPrice);
			pInsert.setInt(4, productQuantity);
			isInsert = pInsert.executeUpdate();

			System.out.println();
			System.out.println("Success!! Inserted added successfully!!");
		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
			return false;
		}
		if (isInsert > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {

		String deleteQuery = "delete from \"Product\" where product_id=?";

		int deletedRow = 0;
		try (con;
				PreparedStatement pDelete = con.prepareStatement(deleteQuery);) {

			pDelete.setInt(1, productId);
			deletedRow = pDelete.executeUpdate();

			System.out.println();
			System.out.println("Row deleted successfully!!");
		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
		}
		if (deletedRow > 0) {
			return true;
		}

		return false;

	}

	@Override
	public boolean update(int id, int price, int quatity) {
		String updateQuery = "update \"Product\" set product_price=? , product_quatity=? where product_id=?";
		int updateRow = 0;
		try (con;
				PreparedStatement pUpdate = con.prepareStatement(updateQuery);) {

			pUpdate.setInt(1, price);
			pUpdate.setInt(2, quatity);
			pUpdate.setInt(3, id);

			updateRow = pUpdate.executeUpdate();

			System.out.println();
			System.out.println("Product updated successfully!!");
		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
		}
		if (updateRow > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePrice(int id, int price) {

		String updateQuery = "update \"Product\" set product_price=? , product_quatity=? where product_id=?";
		int updatedRow = 0;
		try (con;
				PreparedStatement pUpdate = con.prepareStatement(updateQuery);) {

			pUpdate.setInt(1, price);
			pUpdate.setInt(2, id);
			// pstmt.setInt(3,id);

			pUpdate.executeUpdate();

			System.out.println();
			System.out.println("Product updated successfully!!");
		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
		}
		if (updatedRow > 0) {
			return true;
		}
		return false;

	}

	@Override
	public boolean updateQuantity(int id, int quan) {

		String updateQuery = "update \"Product\" set product_quatity=? where product_id=?";
		int updatedRow = 0;
		try (con;
				PreparedStatement pUpdate = con.prepareStatement(updateQuery);) {

			pUpdate.setInt(1, quan);
			pUpdate.setInt(2, id);

			updatedRow = pUpdate.executeUpdate();

			System.out.println();
			System.out.println("Product quantity updated successfully!!");
		} catch (SQLException ex) {
			System.out.println();
			System.out.println("Error: " + ex.getMessage());
		}
		if (updatedRow > 0) {
			return true;
		}
		return false;

	}

	@Override
	public List<Product> viewProducts() {
		// Product products=null;
		List<Product> products = new ArrayList<>();
		String viewQuery = "select * from \"Product\"";
		try (con;
				PreparedStatement pView = con.prepareStatement(viewQuery);) {

			ResultSet result = pView.executeQuery();

			while (result.next()) {
				int product_id = result.getInt(1);
				String product_name = result.getString(2);
				int product_price = result.getInt(3);
				int product_quantity = result.getInt(4);

				products.add(new Product(product_id, product_name, product_price, product_quantity));
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return products;

	}

}
