package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.text.*;

import model.Orders;
import model.Orders_detail;
import model.Orders;
import model.Users;

public class OrdersDAO implements GenericDAO<Orders> {
	Orders_detailDAO orders_detailDAO = new Orders_detailDAO();
	@Override
	public int create(Orders orders) {
		String SQLQuery = "INSERT INTO orders"
				+ "  (user_mail, order_status, order_date, order_discount_code, order_address,total,order_id) VALUES "
				+ " (?,?, ?, ?, ?, ?,?);";

		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery)) {

			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);

			preparedStatement.setString(1, orders.getUser_mail());
			preparedStatement.setInt(2, 1);
			preparedStatement.setDate(3, date);
			preparedStatement.setString(4, null);
			preparedStatement.setString(5, orders.getOrder_address());
			preparedStatement.setFloat(6, orders.getTotal());
			preparedStatement.setInt(7, orders.getOrder_id());

			System.out.println(preparedStatement);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Orders get(Object id) {
		String SQLQuery_SELECT = "SELECT * FROM orders WHERE order_id = " + id + ";";

		System.out.println(SQLQuery_SELECT);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connnection = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = connnection.prepareStatement(SQLQuery_SELECT);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Orders order = new Orders(rs.getInt("order_id"), rs.getString("user_mail"), rs.getInt("order_status"),
						rs.getDate("order_date"), rs.getString("order_discount_code"),rs.getString("order_address"),rs.getFloat("total"));
				return order;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Orders update(Orders t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object order_id) {
		String SQLQuery = "DELETE FROM orders WHERE order_id = \'" + order_id + "\';";

		System.out.println(SQLQuery);
		orders_detailDAO.delete(order_id);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {

			stmt.executeUpdate(SQLQuery);
			System.out.println("Record deleted successfully");
			 
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
	public ArrayList<Orders> listAll() {
		String SQLQuery_SELECT = "SELECT * FROM Orders;";

		System.out.println(SQLQuery_SELECT);

		ArrayList<Orders> listOrders = new ArrayList<Orders>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connnection = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = connnection.prepareStatement(SQLQuery_SELECT);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Orders order = new Orders(rs.getInt("order_id"), rs.getString("user_mail"), rs.getInt("order_status"),
						rs.getDate("order_date"), rs.getString("order_discount_code"),rs.getString("order_address"),rs.getFloat("total"));
				listOrders.add(order);
			}
			
			return listOrders;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Integer getLastestIndex() {
		String SQLQuery = "select order_id from orders order by order_id desc limit 1;";

		System.out.println(SQLQuery);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connnection = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = connnection.prepareStatement(SQLQuery);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				return rs.getInt("order_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

}
