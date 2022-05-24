package ecommerce.main;

import java.util.Scanner;

import ecommerce.dao.OrderDao;
import ecommerce.dao.impl.OrderDaoImpl;

public class EcommerceRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Customer Page\n2.Owner Page\n3.Order Page");
		int option=sc.nextInt();
		OrderDao orderDao=new OrderDaoImpl();
		switch(option)
		{
		case 1:
			CustomerPage.customeroption();
			break;
		case 2:
			OwnerPage.owneroption();
			break;
		case 3:
			System.out.println("Enter Customerid ");
			int custid=sc.nextInt();
			System.out.println("Enter product id to order");
			int proid=sc.nextInt();
			System.out.println("Enterbill ammount");
			int bill=sc.nextInt();
			orderDao.createOrder(custid, proid, bill);
			
			break;
			
		}
        
	}

}
