
package service;

import java.util.List;

import repository.RetailerDAO;

/**
 * @author Sumit
 *
 */
public class RetailerServiceImpl implements RetailerService {

	RetailerDAO retailerDAO;

	/**
	 * @param retailerDAO
	 */
	public RetailerServiceImpl(RetailerDAO retailerDAO) {
		super();
		this.retailerDAO = retailerDAO;
	}

	public String addRetailerAndGetId(String retailerId, String retailerName, String retailerAddress) {
		String idOfRetailer = retailerDAO.addRetailerAndGetId(retailerId, retailerName, retailerAddress);
		return idOfRetailer;
	}

	public List viewCustomer(String retailerId) {
		List customerList = new ArrayList<Customer>();
		customerList = retailerDAO.viewCustomer(retailerId);
		return customerList;
	}

	public List viewSupplier(String retailerId) {
		List supplierList = new ArrayList<Supplier>();
		supplierList = retailerDAO.viewSupplier(retailerId);
		return supplierList;
	}
}
