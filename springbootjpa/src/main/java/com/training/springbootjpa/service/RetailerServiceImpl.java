
package com.training.springbootjpa.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.springbootjpa.model.Retailer;
import com.training.springbootjpa.repository.RetailerDAO;

/**
 * @author Sumit
 *
 */

@Service("retailerService")
public class RetailerServiceImpl implements RetailerService {

	@Autowired
	private RetailerDAO retailerDAO;

	@Override
	public Retailer addRetailer(Retailer retailer) {
		Retailer retailerData = retailerDAO.save(retailer);
		return retailerData;
	}

	@Override
	public List<Retailer> deleteRetailerById(Long deleteById) {
		List<Retailer> retailerList = retailerDAO.findAll();
		Iterator iterator = retailerList.iterator();
		while (iterator.hasNext()) {
			Retailer retailer = (Retailer) iterator.next();
			if (retailer.getRetailerId() == deleteById) {
				retailerDAO.deleteById(deleteById);
			}
		}
		return retailerList;
	}

	@Override
	public Retailer updateRetailerById(Long updateById) {
		Optional<Retailer> retailer = retailerDAO.findById(updateById);
		Retailer retailerDummy = retailer.get();
		retailerDummy.setRetailerAddress("Las Vegas");
		return retailerDummy;
	}
}
