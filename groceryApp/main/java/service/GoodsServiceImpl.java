package service;

import repository.CustomerDAO;
import repository.GoodsDAO;

public class GoodsServiceImpl implements GoodsService {

	GoodsDAO goodsDAO;
	
	/**
	 * @param goodsDAO
	 */
	public GoodsServiceImpl(GoodsDAO goodsDAO) {
		super();
		this.goodsDAO = goodsDAO;
	}

	@Override
	public int addGoods(String goodsId, String goodsName, int goodsQuantity,
			double goodsPrice, String supplierId) {
		int addData = goodsDAO.addGoods(goodsId, goodsName, goodsQuantity,
				goodsPrice, supplierId);
		return addData;
	}

	@Override
	public String removeGoods(String goodsId) {
		String remmoveData = goodsDAO.removeGoods(goodsId);
		return remmoveData;
	}

	@Override
	public String updateGoods(String goodsId) {
		String updateData = goodsDAO.updateGoods(goodsId);
		return updateData;
	}

}
