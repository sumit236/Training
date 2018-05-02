package repository;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Sumit
 */
public class GoodsDAOImpl implements GoodsDAO {

	JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 */
	public GoodsDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String addGoods(String goodsId, String goodsName, int goodsQuantity,
			double goodsPrice, String supplierId) {
		try {
			jdbcTemplate.update("INSERT INTO Goods values('" + goodsId + "','"
					+ goodsName + "','" + goodsQuantity + "','" + goodsPrice
					+ "','" + supplierId + "')");
		} catch (Exception e) {
			System.out.println(e);
		}
		return " Goods added";
	}

	public String removeGoods(String goodsId) {
		try {
			String sql = "DELETE FROM Goods where goodsId=?";
			jdbcTemplate.update(sql, goodsId);
		} catch (Exception e) {
			System.out.println(e);
		}
		return " Goods deleted";
	}

	public String updateGoods(String goodsId) {
		try {
			String sql = "UPDATE Goods set goodsQuantity=1 where goodsId=?";
			jdbcTemplate.update(sql, goodsId);
		} catch (Exception e) {
			System.out.println(e);
		}
		return " Goods updated";
	}
}
