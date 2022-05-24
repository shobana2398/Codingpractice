package ecommerce.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHistory {
	private int orderHistoryid;
	private Customer customerId;
	private Order orderId;
	private  Map<String, List<Product>> orderproduct;
	
	public int getOrderHistoryid() {
		return orderHistoryid;
	}
	public void setOrderHistoryid(int orderHistoryid) {
		this.orderHistoryid = orderHistoryid;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public Order getOrderId() {
		return orderId;
	}
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	public Map<String, List<Product>> getOrderproduct() {
		return orderproduct;
	}
	public void setOrderproduct(Map<String, List<Product>> orderproduct) {
		this.orderproduct = orderproduct;
	}
	
	
	

}
