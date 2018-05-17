package com.training.springbootjpa.service;

import java.util.List;

import com.training.springbootjpa.model.Retailer;

public interface RetailerService {

	Retailer addRetailer(Retailer retailer);

	public List<Retailer> deleteRetailerById(Long deleteById);

	public Retailer updateRetailerById(Long updateById);
}
