package ecommerce.dao;

public interface OrderDao {
	
	public void createOrder(int customerid,int productid,int amount);

}
