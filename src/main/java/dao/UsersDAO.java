package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Users;

public class UsersDAO implements GenericDAO<Users> {

	@Override
	public int create(Users user) {
		String SQLQuery_INSERT = "INSERT INTO users"
				+ "  (user_mail, password, account_role, full_name, user_address, user_phone) VALUES "
				+ " (?, ?, ?, ?, ?,?);";

		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery_INSERT)) {

			preparedStatement.setString(1, user.getUser_mail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getAccount_role());
			preparedStatement.setString(4, user.getFull_name());
			preparedStatement.setString(5, user.getUser_address());
			preparedStatement.setString(6, user.getUser_phone());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Users get(Object user_mail) {
		String SQLQuery_SELECT = "SELECT * FROM USERS WHERE user_mail = \'" + user_mail + "\';";

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
				Users user = new Users(rs.getString("user_mail"), rs.getString("password"), rs.getInt("account_role"),
						rs.getString("full_name"), rs.getString("user_address"), rs.getString("user_phone"));
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Users update(Users t) {
		return null;
	}

	@Override
	public void delete(Object user_mail) {
		String SQLQuery = "DELETE FROM USERS WHERE user_mail = \'" + user_mail + "\';";

		System.out.println(SQLQuery);

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
		String SQLQuery = "select count(*) from users;";

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
				return rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public ArrayList<Users> listAll() {

		String SQLQuery_SELECT = "SELECT * FROM USERS;";

		System.out.println(SQLQuery_SELECT);

		ArrayList<Users> listUsers = new ArrayList<Users>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connnection = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = connnection.prepareStatement(SQLQuery_SELECT);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Users user = new Users(rs.getString("user_mail"), rs.getString("password"), rs.getInt("account_role"),
						rs.getString("full_name"), rs.getString("user_address"), rs.getString("user_phone"));

				listUsers.add(user);
			}

			return listUsers;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
