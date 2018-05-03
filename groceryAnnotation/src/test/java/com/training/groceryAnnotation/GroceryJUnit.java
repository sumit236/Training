package com.training.groceryAnnotation;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import controller.GroceryAnnotation;
import model.Customer;
import model.Goods;
import model.Retailer;
import model.Supplier;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.GoodsService;
import service.GoodsServiceImpl;
import service.RetailerService;
import service.RetailerServiceImpl;
import service.SupplierService;
import service.SupplierServiceImpl;

public class GroceryJUnit {

	ApplicationContext context = new AnnotationConfigApplicationContext(GroceryAnnotation.class);
    CustomerService customerService = (CustomerService) context.getBean("customerService",CustomerServiceImpl.class);
    RetailerService retailerService = (RetailerService) context.getBean("retailerService",RetailerServiceImpl.class);
    GoodsService goodsService = (GoodsService) context.getBean("goodsService",GoodsServiceImpl.class);
    SupplierService supplierService = (SupplierService) context.getBean("supplierService",SupplierServiceImpl.class);

	@Test
	public void checkforRetailerId() {
		final String retailerId = null;
		Retailer retailer = new Retailer("1_R", "Spectre Litt", "NY");
		assertNotEquals("Invalid id", retailerId, retailer.getRetailerId());
	}

	@Test
	public void checkForRetailerName() {
		final String retailerName = null;
		Retailer retailer = new Retailer("1_R", "Spectre Litt", "NY");
		assertNotEquals("Invalid name", retailerName, retailer.getRetailerName());
	}

	@Test
	public void checkForRetailerAddress() {
		final String retailerAddress = null;
		Retailer retailer = new Retailer("1_R", "Spectre Litt", "NY");
		assertNotEquals("Invalid address", retailerAddress, retailer.getRetailerAddress());
	}

	@Test
	public void checkForAddRetailer() {
		Retailer retailer = new Retailer("1_R", "Spectre Litt", "NY");
		final String idOfRetailer = retailerService.addRetailerAndGetId("1_R", "Spectre Litt", "NY");
		assertEquals("retailer Data is not added properly", retailer.getRetailerId(), idOfRetailer);
	}

	@Test
	public void checkViewCustomer() {
		final String idOfRetailer = "";
		List<Customer> customerList = retailerService.viewCustomer(idOfRetailer);
		assertThat(customerList,
				hasItems(new Customer("1_C", "Mike", "2g 101", "CASH", "1_R"),
						new Customer("2_C", "Har", "2g 201", "CARD", "1_R"),
						new Customer("3_C", "Iron Man", "NY", "CASH", "2_R")));
	}

	@Test
	public void checkViewSupplier() {
		final String idOfRetailer = "";
		List<Supplier> retailerList = retailerService.viewSupplier(idOfRetailer);
		assertThat(retailerList, hasItems(new Supplier("1_S", "Suits", "NYK", 2, 1, 1200, "1_R"),
				(new Supplier("2_S", "Suits Season1", "Calf", 2, 2, 200, "1_R"))));
	}

	@Test
	public void checkViewGoods() {
		final String idOfRetailer = "";
		List<Goods> goodsList = retailerService.viewGoods(idOfRetailer);
		assertThat(goodsList,
				hasItems(new Goods("1_G", "Soap", 2, 123.1, "1_S"), new Goods("2_G", "Shirt", 2, 120, "1_S"),
						new Goods("3_G", "T-shirt", 1, 120, "2_S"), new Goods("4_G", "Tissue", 1, 120, "2_S")));

	}

	// Check details of a customer.
	final String retailerId = "1_R";

	@Test
	public void addCustomer() {
		Customer customer = new Customer("1_C", "Harvy", "NY", "CASH", retailerId);
		final String dummyData = "Customer added";
		String addData = customerService.addCustomer(customer.getCustomerId(), customer.getCustomerName(),
				customer.getCustomerAddress(), customer.getPaymentMode(), retailerId);
		assertEquals("Data inserted", dummyData, addData);
	}

	@Test
	public void deleteCustomer() {
		Customer customer = new Customer("1_C", "Harvy", "NY", "CASH", retailerId);
		final String dummyData = "Customer deleted";
		String removeData = customerService.removeCusotmer(customer.getCustomerId());
		assertEquals(dummyData, removeData);
	}

	@Test
	public void updateCustomer() {
		Customer customer = new Customer("1_C", "Harvy", "NY", "CASH", retailerId);
		final String dummyData = "Customer updated";
		final String updateData = customerService.updateCustomer(customer.getCustomerId());
		assertEquals(dummyData, updateData);
	}

	@Test
	public void checkforCustomerId() {
		final String customerId = null;
		Customer customer = new Customer("1_C", "Harvy", "NY", "CASH", retailerId);
		assertNotEquals("Invalid id", customerId, customer.getCustomerId());
	}

	@Test
	public void checkForCustomerName() {
		final String customerName = null;
		Customer customer = new Customer("1_C", "Harvy", "NY", "CASH", retailerId);
		assertNotEquals("Invalid name", customerName, customer.getCustomerName());
	}

	@Test
	public void checkForCustomerAddress() {
		String customerAddress = null;
		Customer customer = new Customer("1_C", "Harvy", "NY", "CASH", retailerId);
		assertNotEquals("Invalid address", customerAddress, customer.getCustomerAddress());
	}

	@Test
	public void checkForPaymentMode() {
		String paymentMode = null;
		Customer customer = new Customer("1_C", "Harvy", "NY", "CASH", retailerId);
		assertNotEquals("Invalid mode of payment", paymentMode, customer.getPaymentMode());
	}

	// Check details of a supplier.
	@Test
	public void checkAddSupplier() {
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		final String dummyData = "Supplier added";
		String addData = supplierService.addSupplier(supplier.getSupplierId(), supplier.getSupplierName(),
				supplier.getSupplierAddress(), supplier.getQuantityOrder(), supplier.getOrderId(), supplier.getAmount(),
				retailerId);
		assertEquals("Data inserted", dummyData, addData);
	}

	@Test
	public void checkRemoveSupplier() {
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		final String dummyData = "Supplier deleted";
		String removeData = customerService.removeCusotmer(supplier.getSupplierId());
		assertEquals(dummyData, removeData);
	}

	@Test
	public void checkUpdateSupplier() {
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		final String dummyData = "Supplier updated";
		final String updateData = customerService.updateCustomer(supplier.getSupplierId());
		assertEquals(dummyData, updateData);
	}

	public void checkforSupplierId() {
		final String supplierId = null;
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		assertNotEquals("Invalid id", supplierId, supplier.getSupplierId());
	}

	@Test
	public void checkForSupplierName() {
		final String supplierName = null;
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		assertNotEquals("Invalid name", supplierName, supplier.getSupplierAddress());
	}

	@Test
	public void checkForSupplierAddress() {
		final String supplierAddress = null;
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		assertNotEquals("Invalid address", supplierAddress, supplier.getSupplierAddress());
	}

	@Test
	public void checkForSupplierQuantityOrder() {
		final int quantityOrder = 0;
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		assertNotEquals("Invalid address", quantityOrder, supplier.getQuantityOrder());
	}

	@Test
	public void checkForSupplierOrderId() {
		final int orderId = 0;
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		assertNotEquals("Invalid address", orderId, supplier.getOrderId());
	}

	@Test
	public void checkForSupplierAmount() {
		final double amount = 0;
		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1, 199078, retailerId);
		assertNotEquals("Invalid address", amount, supplier.getAmount());
	}

	// Check details of a customer.
	final String supplierId = "1_S";

	@Test
	public void checkAddGoods() {
		Goods goods = new Goods("1_G", "Car", 2, 1000, supplierId);
		final String dummyData = "Goods added";
		String addData = goodsService.addGoods(goods.getGoodsId(), goods.getGoodsName(), goods.getGoodsQuantity(),
				goods.getGoodsPrice(), supplierId);
		assertEquals("Data inserted", dummyData, addData);
	}

	@Test
	public void checkRemoveGoods() {
		Goods goods = new Goods("1_G", "Car", 2, 1000, supplierId);
		final String dummyData = "Goods deleted";
		String removeData = customerService.removeCusotmer(goods.getGoodsId());
		assertEquals("Not deleted",dummyData, removeData);
	}

	@Test
	public void checkUpdateGoods() {
		Goods goods = new Goods("1_G", "Car", 2, 1000, supplierId);
		final String dummyData = "Goods updated";
		final String updateData = customerService.updateCustomer(goods.getGoodsId());
		assertEquals(dummyData, updateData);
	}

	@Test
	public void checkforGoodsId() {
		final String goodsId = null;
		Goods goods = new Goods("1_G", "Car", 2, 1000, supplierId);
		assertNotEquals("Invalid id", goodsId, goods.getGoodsId());
	}

	@Test
	public void checkForGoodsName() {
		final String goodsName = null;
		Goods goods = new Goods("1_G", "Car", 2, 1000, supplierId);
		assertNotEquals("Invalid name", goodsName, goods.getGoodsName());
	}

	@Test
	public void checkForGoodsPrice() {
		final double quantity = 0;
		Goods goods = new Goods("1_G", "Car", 2, 1000, supplierId);
		assertNotEquals("Invalid address", quantity, goods.getGoodsPrice());
	}

	@Test
	public void checkForGoodsQuantity() {
		final int quantity = 0;
		Goods goods = new Goods("1_G", "Car", 2, 1000, supplierId);
		assertNotEquals("Invalid address", quantity, goods.getGoodsQuantity());
	}

}
