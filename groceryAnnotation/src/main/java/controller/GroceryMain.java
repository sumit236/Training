package controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mysql.cj.log.Log;

import model.Goods;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.GoodsService;
import service.GoodsServiceImpl;
import service.RetailerService;
import service.RetailerServiceImpl;
import service.SupplierService;
import service.SupplierServiceImpl;

/**
 * @author Sumit
 *
 */
public class GroceryMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(GroceryAnnotation.class);
        CustomerService customerService = (CustomerService) context.getBean("customerService",CustomerServiceImpl.class);
        RetailerService retailerService = (RetailerService) context.getBean("retailerService",RetailerServiceImpl.class);
        GoodsService goodsService = (GoodsService) context.getBean("goodsService",GoodsServiceImpl.class);
        SupplierService supplierService = (SupplierService) context.getBean("supplierService",SupplierServiceImpl.class);

		String idOfRetailer = retailerService.addRetailerAndGetId("2_R", "Retailer2", "A 101 Gd road");

		//Add new customer
	/*	String addCustomer = customerService.addCustomer("3_C", "Iron Man", "NY", "CASH", idOfRetailer);
		System.out.println(addCustomer + " added successfully");*/
		
		//Delete customer
	/*	String deleteCustomer = customerService.removeCusotmer("3_C");
		System.out.println(deleteCustomer);*/
		
		//update Customer
	/*	String updateCustomer = customerService.updateCustomer("2_C");
		System.out.println(updateCustomer);*/
        
		List<Goods> goodsList =  retailerService.viewGoods(idOfRetailer);
		Iterator iterator = goodsList.iterator();
		while(iterator.hasNext())
		{
			Goods goods = (Goods)iterator.next();
			System.out.println(goods.getGoodsId()+" "+goods.getGoodsName());
		}
	}
}
