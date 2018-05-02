package repository;

import java.util.List;

public interface RetailerDAO {

	String addRetailerAndGetId(String retailerId, String retailerName, String retailerAddress);

	public List viewCustomer(String retailerId);

	public List viewSupplier(String retailerId);
}
