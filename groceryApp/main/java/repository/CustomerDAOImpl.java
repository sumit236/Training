package repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDAOImpl implements CustomerDAO {

	JdbcTemplate jdbcTemplate;

	/**
	 * @param temperoryJdbcTemplate
	 */
	public CustomerDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String addCustomer(String customerId, String customerName,
			String customerAddress, String paymentMode, String retailerId) {
		int addData = 0;
		try {
			addData = jdbcTemplate.update("INSERT INTO Customer values('"
					+ customerId + "','" + customerName + "','"
					+ customerAddress + "','" + paymentMode + "','"
					+ retailerId + "')");
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Customer added";
	}

	@Override
	public String removeCustomer(String customerId) {
		try {
			String sql = "DELETE FROM Customer where customerId = ?";
			jdbcTemplate.update(sql, customerId);

		} catch (Exception e) {
			System.out.println(e);
		}
		return "Customer deleted";
	}

	@Override
	public String updateCustomer(String customerId) {
		try {
			String sql = "UPDATE Customer set paymentMode='CASH' where customerId = ?";
			jdbcTemplate.update(sql, customerId);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Customer updated";
	}
}