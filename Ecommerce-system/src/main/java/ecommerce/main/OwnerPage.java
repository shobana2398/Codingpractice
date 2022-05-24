package ecommerce.main;

import java.util.List;
import java.util.Scanner;

import ecommerce.dao.ProductDao;
import ecommerce.dao.impl.ProductDaoImpl;
import ecommerce.model.Product;

public class OwnerPage {
	public static void owneroption() {

		    Scanner sc = new Scanner(System.in); 
			System.out.println("Enter the option to proceed......");
			System.out.println("1.Add_Product");
			System.out.println("2.Delete_Product");
			System.out.println("3.Update_Product");
			System.out.println("4.Update_ProductQuantity");
			System.out.println("5.Update_ProductPrice");
			System.out.println("6.To View All Products");
			int opt = sc.nextInt();

			ProductDao productDao = new ProductDaoImpl();

			switch (opt) {
			case 1:
				System.out.println("Enter product id");
				int id = sc.nextInt();
				System.out.println("Enter Product name");
				String name = sc.next();
				System.out.println("Enter Product price");
				int price = sc.nextInt();
				System.out.println("Enter Product quantity");
				int quan = sc.nextInt();
				productDao.addProduct(id, name, price, quan);
				break;
			case 2:
				System.out.println("Enter The Id");
				int productid = sc.nextInt();
				productDao.deleteProduct(productid);
				break;
			case 3:
				System.out.println("Enter product id to update");
				int proid = sc.nextInt();
				System.out.println("Enter price and quatity to update");
				int proprice = sc.nextInt();
				int quant = sc.nextInt();
				productDao.update(proid, proprice, quant);
				break;
			case 4:
				System.out.println("Enter productid to update");
				int pid = sc.nextInt();
				System.out.println("Eneter quantity to update");
				int quans = sc.nextInt();
				productDao.updateQuantity(pid, quans);
				break;
			case 5:
				System.out.println("Enter productid to update");
				int p_id = sc.nextInt();
				System.out.println("Eneter price to update");
				int pro_price = sc.nextInt();
				productDao.updatePrice(p_id, pro_price);
				break;
			case 6:
				System.out.println(productDao.viewProducts().toString());
				break;
			default:
				System.out.println("Please enter the valid option");
				break;

			}
		}
		

	}


