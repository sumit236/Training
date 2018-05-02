package service;

import repository.CustomerDAO;
import repository.SupplierDAO;

public class SupplierServiceImpl implements SupplierService {
	
	SupplierDAO supplierDAO;

	/**
	 * @param supplierDAO
	 */
	public SupplierServiceImpl(SupplierDAO supplierDAO) {
		super();
		this.supplierDAO = supplierDAO;
	}

	@Override
	public String addSupplier(int supplierId, String supplierName,
			String supplierAddress, int quantityOrder, int orderId,
			double amount,  String retailerId) {
		String addData = supplierDAO.addSupplier(supplierId, supplierName,
				supplierAddress, quantityOrder, orderId, amount);
		return addData;

	}

	@Override
	public String removeSupplier(String supplierId) {
		String removeData = supplierDAO.removeSupplier(supplierId);
		return removeData;
	}

	@Override

	public String updateSupplier(String supplierId) {
		String removeData = supplierDAO.updateSupplier(supplierId);
		return removeData;
	}

}
