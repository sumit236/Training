package com.training.groceryAnnotation;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import java.util.List;
import model.Customer;
import model.Goods;
import model.Retailer;
import model.Supplier;
import service.CustomerService;
import service.GoodsService;
import service.RetailerService;
import service.SupplierService;

import org.junit.Test;

public class GroceryJUnit {

	@Test
	public void testRetailer() {

		// Check details of a retailer.
		final String retailerId = null;
		final String retailerName = null;
		final String retailerAddress = null;

		// test null checks.
		Retailer retailer = new Retailer("1_R", "Spectre Litt", "NY");
		assertEquals("Enter valid id", retailerId, retailer.getRetailerId());
		assertEquals("Enter valid name", retailerName, retailer.getRetailerName());
		assertEquals("Enter valid address", retailerAddress, retailer.getRetailerAddress());

		// positive test case.
		RetailerService retailerService = null;
		final String idOfRetailer = retailerService.addRetailerAndGetId("1_R", "Spectre Litt", "NY");
		assertEquals("retailer Data is not added properly", retailer.getRetailerId(), idOfRetailer);

		List<Customer> customerList = retailerService.viewCustomer(idOfRetailer);
		assertThat(customerList,
				hasItems(new Customer("1_C", "Mike", "2g 101", "CASH", "1_R"),
						new Customer("2_C", "Har", "2g 201", "CARD", "1_R"),
						new Customer("3_C", "Iron Man", "NY", "CASH", "2_R")));

		List<Supplier> retailerList = retailerService.viewSupplier(idOfRetailer);
		assertThat(retailerList, hasItems(new Supplier("1_S", "Suits", "NYK", 2, 1, 1200, "1_R"),
				(new Supplier("2_S", "Suits Season1", "Calf", 2, 2, 200, "1_R"))));

		List<Goods> goodsList = retailerService.viewGoods(idOfRetailer);
		assertThat(goodsList,
				hasItems(new Goods("1_G", "Soap", 2, 123.1, "1_S"), new Goods("2_G", "Shirt", 2, 120, "1_S"),
						new Goods("3_G", "T-shirt", 1, 120, "2_S"), new Goods("4_G", "Tissue", 1, 120, "2_S")));

	}

	@Test
	// Check details of a customer.
	public void testCustomer() {

		final String customerId = null;
		final String customerName = null;
		final String customerAddress = null;
		final String paymentMode = null;
		final String retailerId = "1_R";

		// test null checks.
		Customer customer = new Customer("1_C", "Harvy", "NY", "CASH", retailerId);
		assertEquals("Enter valid id", customerId, customer.getCustomerId());
		assertEquals("Enter valid name", customerName, customer.getCustomerName());
		assertEquals("Enter valid address", customerAddress, customer.getCustomerAddress());
		assertEquals("Enter valid paymentMode", paymentMode, customer.getPaymentMode());

		// positive test case.
		CustomerService customerService = null;
		final String dummyData = "Customer added";
		String addData = customerService.addCustomer(customer.getCustomerId(), customer.getCustomerName(),
				customer.getCustomerAddress(), customer.getPaymentMode(), retailerId);
		assertEquals("Data added is incorrect", dummyData, addData);

		/*
		 * final String customerId1 = "1_C"; String updateData =
		 * customerService.updateCustomer(customerId1);
		 * assertEquals("Data added is incorrect", updateData, addData);
		 */

	}

	@Test
	// Check details of a supplier.
	public void testSupplier() {

		final String supplierId = null;
		final String supplierName = null;
		final String supplierAddress = null;
		final int quantityOrder = 0;
		final int orderId = 0;
		final double amount = 0;
		final String retailerId = "1_R";

		// test null checks.
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		assertEquals("Enter valid id", supplierName, supplier.getSupplierId());
		assertEquals("Enter valid name", supplierAddress, supplier.getSupplierName());
		assertEquals("Enter valid quantity", quantityOrder, supplier.getQuantityOrder());
		assertEquals("Enter valid Id", orderId, supplier.getOrderId());
		// assertEquals("Enter valid amount", amount, supplier.getAmount());

		// positive test case.
		SupplierService supplierService = null;
		final String dummyData = "Supplier added";
		String addData = supplierService.addSupplier(supplier.getSupplierId(), supplier.getSupplierName(),
				supplier.getSupplierAddress(), supplier.getQuantityOrder(), supplier.getOrderId(), supplier.getAmount(),
				retailerId);
		assertEquals("Data added is incorrect", dummyData, addData);
	}

	@Test
	// Check details of a good.
	public void testGoods() {

		final String goodsId = null;
		final String goodsName = null;
		final int goodsQuantity = 0;
		final double goodsPrice = 0;
		final String supplierId = "1_S";

		// test null checks.
		Goods goods = new Goods("1_G", "Car", 2, 1000, supplierId);
		assertEquals("Enter valid id", goodsId, goods.getGoodsId());
		assertEquals("Enter valid name", goodsName, goods.getGoodsName());
		assertEquals("Enter valid quantity", goodsQuantity, goods.getGoodsQuantity());
		// assertEquals("Enter valid price", goodsPrice, goods.getGoodsPrice());

		// positive test case.
		GoodsService goodsService = null;
		final String dummyData = "Goods added";
		String addData = goodsService.addGoods(goods.getGoodsId(), goods.getGoodsName(), goods.getGoodsQuantity(),
				goods.getGoodsPrice(), supplierId);
		assertEquals("Data added is incorrect", dummyData, addData);
	}

}
