package service;

import java.util.List;

public interface RetailerService {

	String addRetailerAndGetId(String retailerId, String retailerName, String retailerAddress);

	public List viewCustomer(String retailerId);

	public List viewSupplier(String retailerId);
}
