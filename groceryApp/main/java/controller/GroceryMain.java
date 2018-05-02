package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.GoodsService;
import service.GoodsServiceImpl;
import service.RetailerService;
import service.RetailerServiceImpl;
import service.SupplierService;
import service.SupplierServiceImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import service.GoodsService;

/**
 * @author Sumit
 *
 */
public class GroceryMain {

<<<<<<< HEAD
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService=context.getBean("customerService",CustomerServiceImpl.class);
        RetailerService retailerService=context.getBean("retailerService",RetailerServiceImpl.class);
        GoodsService goodsService=context.getBean("goodsService",GoodsServiceImpl.class);
        SupplierService supplierService=context.getBean("supplierService",SupplierServiceImpl.class);

	/*	String idOfRetailer = retailerService.addRetailerAndGetId("2_R", "Retailer2", "A 101 Gd road");

		int addCustomer = customerService.addCustomer("3_C", "Iron Man", "NY", "CASH", idOfRetailer);
		System.out.println(addCustomer + " added successfully");

		String deleteCustomer = customerService.removeCusotmer("3_C");
		System.out.println(deleteCustomer);
		String updateCustomer = customerService.updateCustomer("3_C");
		System.out.println(updateCustomer);*/
        
	}
}
