package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Orders_detail;

public class Orders_detailDAO implements GenericDAO<List<Orders_detail>> {

	@Override
	public int create(List<Orders_detail> ordersDetailList) {
		int result = 0;

		String SQLQuery = "INSERT INTO orders_detail" + "  (order_id, product_id, amount) VALUES " + " (?, ?, ?);";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery)) {
			for (Orders_detail orders_detail : ordersDetailList) {
				preparedStatement.setInt(1, orders_detail.getOrder_id());
				preparedStatement.setInt(2, orders_detail.getProduct_id());
				preparedStatement.setInt(3, orders_detail.getAmount());

				System.out.println(preparedStatement);

				result = preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Orders_detail> get(Object id) {
		String SQLQuery = "select * from orders_detail where order_id = " + id;
		List<Orders_detail> orders_detailsList = new ArrayList<Orders_detail>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement st = con.prepareStatement(SQLQuery);
				ResultSet rs = st.executeQuery();) {
			while (rs.next()) {
				orders_detailsList.add(new Orders_detail(rs.getInt("order_id"),rs.getInt("product_id"),rs.getInt("amount")));
			}
			return orders_detailsList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Orders_detail> update(List<Orders_detail> t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object order_id) {
		String SQLQuery = "DELETE FROM orders_detail WHERE order_id = \'" + order_id + "\';";

		System.out.println(SQLQuery);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {

			stmt.executeUpdate(SQLQuery);
			System.out.println("Order_detail deleted successfully");
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<List<Orders_detail>> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
