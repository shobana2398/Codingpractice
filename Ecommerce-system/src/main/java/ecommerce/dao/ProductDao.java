package ecommerce.dao;

import java.util.List;

import ecommerce.model.Product;

public interface ProductDao{
	public boolean addProduct(int productId,String productName,int productPrice,int productQuantity);
	
	public boolean deleteProduct(int productId);
	
	public boolean update(int id,int price,int quatity);
	
	public boolean updatePrice(int id,int price);
	
	public boolean updateQuantity(int id,int quan);
	
	public List<Product> viewProducts();
	

}
