import static org.junit.Assert.*;
import org.junit.Test;

public class GroceryJUnit {

	@Test
	public void test() {

		// Check details of a retailer.
		String retailerId = null;
		String retailerName = null;
		String retailerAddress = null;

		Retailer retailer = new Retailer("1_R", "Spectre Litt", "NY");
		assertEquals("Enter valid id", retailerId, retailer.getRetailerId());
		assertEquals("Enter valid name", retailerName, getRetailerName());
		assertEquals("Enter valid address", retailerAddress, getRetailerAddress());

		// Check details of a customer.
		String customerId = null;
		String customerName = null;
		String customerAddress = null;
		String paymentMode = null;
		String retailerId = null;

		Customer customer = new Customer("1_C", "Harvy", "NY", "CASH", retailer.getRetailerId());
		assertEquals("Enter valid id", customerId, customer.getCustomerId());
		assertEquals("Enter valid name", customerName, customer.getCustomerName());
		assertEquals("Enter valid address", customerAddress, customer.getCustomerAddress());
		assertEquals("Enter valid paymentMode", paymentMode, customer.getPaymentMode());

		// Check details of a supplier.
		String supplierId = null;
		String supplierName = null;
		String supplierAddress = null;
		int quantityOrder = 0;
		int orderId = 0;
		double amount = 0;

		Supplier supplier = new Supplier("1_S", "Jessica", "10th Street", 2, 1AF, 199078, retailer.getRetailerId());
		assertEquals("Enter valid id", supplierName, supplier.getSupplierId());
		assertEquals("Enter valid name", supplierAddress, supplier.getSupplierName());
		assertEquals("Enter valid quantity", quantityOrder, supplier.getQuantityOrder());
		assertEquals("Enter valid Id", orderId, supplier.getOrderId());
		assertEquals("Enter valid amount", amount, supplier.getAmount());

		// Check details of a good.
		String goodsId = null;
		String goodsName = null;
		int goodsQuantity = 0;
		double goodsPrice = 0;

		Good good = new Good("1_G", "Car", 2, 1000, supplier.getSupplierId());
		assertEquals("Enter valid id", goodsId, good.getGoodsId());
		assertEquals("Enter valid name", goodsName, good.getGoodsName());
		assertEquals("Enter valid quantity", goodsQuantity, good.getGoodsQuantity());
		assertEquals("Enter valid price", goodsPrice, good.getGoodsPrice());
	}

}
