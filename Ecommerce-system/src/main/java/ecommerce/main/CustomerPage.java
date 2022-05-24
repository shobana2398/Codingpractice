package ecommerce.main;

import java.util.Scanner;

import ecommerce.dao.CustomerDao;
import ecommerce.dao.impl.CustomerDaoImpl;

public class CustomerPage {
	static Scanner sc=new Scanner(System.in);
	
	public static void customeroption()
	{
		System.out.println("1 for Create Customer\n 2 for delete customer");
		int opt=sc.nextInt();
		CustomerDao customerDao=new CustomerDaoImpl();
		switch(opt)
		{
		case 1:
			System.out.println("Enter customer id");
			int id=sc.nextInt();
			System.out.println("Enter Customer name");
			String name=sc.next();
			customerDao.createCustomer(id, name);
		}
		
	}

}
