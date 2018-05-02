package repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class RetailerDAOImpl implements RetailerDAO {

	JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 */
	public RetailerDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String addRetailerAndGetId(String retailerId, String retailerName, String retailerAddress) {

		try {
			jdbcTemplate.update("INSERT INTO retailer values('" + retailerId + "','" + retailerName + "','"
					+ retailerAddress + "')");
		} catch (Exception e) {
			System.out.println(e);
		}
		return retailerId;
	}

	public List viewCustomer(String retailerId) {
		try {
			// String sql = "SELCET * FROM customer where retailerId = ?";
			String sql = "SELCET * FROM customer ";
			List customerList = getJdbcTemplate().query(sql, new ResultSetExtractor<List>() {

				public List extractData(ResultSet rs) throws SQLException, DataAccessException {
					List customerList = new ArrayList<Customer>();
					while (rs.next()) {
						Customer customer = new Customer(rs.getString("customerId"), rs.getString("customerName"),
								rs.getString("customerAddress"), rs.getString("paymentMode"),
								rs.getString("retailerId"));
						customerList.add(customer);
					}
				}
			});
		} catch (Exception e) {
			System.out.println(e);
		}
		return customerList;
	}
	
	public List viewSupplier(String retailerId) {
		try {
			// String sql = "SELCET * FROM customer where retailerId = ?";
			String sql = "SELCET * FROM supplier ";
			List supplierList = getJdbcTemplate().query(sql, new ResultSetExtractor<List>() {

				public List extractData(ResultSet rs) throws SQLException, DataAccessException {
					List supplierList = new ArrayList<Customer>();
					while (rs.next()) {
						Supplier supplier = new Supplier(rs.getString("supplierId"), rs.getString("supplierName"),
								rs.getString("supplierAddress"), rs.getInt("quantityOrder"),
								rs.getInt("orderId"), rs.getDouble("amount"), rs.getString("retailerId"));
						supplierList.add(supplier);
					}
				}
			});
		} catch (Exception e) {
			System.out.println(e);
		}
		return supplierList;
	}
	

}
