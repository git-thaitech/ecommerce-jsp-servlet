package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Products;

public class ProductsDAO implements GenericDAO<Products> {

	@Override
	public int create(Products product) {
		String SQLQuery_INSERT = "INSERT INTO products"
				+ "  (product_name,product_des,product_price,product_img_source,product_type,product_brand) VALUES "
				+ " (?, ?, ?, ?, ?,?,?);";

		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery_INSERT)) {

			preparedStatement.setString(1, product.getProduct_name());
			preparedStatement.setString(2, product.getProduct_des());
			preparedStatement.setFloat(3, product.getProduct_price());
			preparedStatement.setString(4, product.getProduct_img_source());
			preparedStatement.setString(5, product.getProduct_type());
			preparedStatement.setString(6, product.getProduct_brand());
			preparedStatement.setInt(7, product.getProduct_quantity());

			System.out.println(preparedStatement);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Products get(Object id) {
		String SQLQuery_SELECT = "SELECT * FROM PRODUCTS WHERE product_id = " + id + ";";

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
				Products product = new Products(rs.getString("product_name"), rs.getString("product_des"),
						rs.getFloat("product_price"), rs.getString("product_img_source"), rs.getString("product_type"),
						rs.getString("product_brand"),rs.getInt("product_quantity"));

				product.setProduct_id(rs.getInt("product_id"));

				return product;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	
	public void updateQuantity(int product_id, int product_quantity) {
		
		String SQLQuery = "update products set product_quantity = "+ product_quantity +" where product_id=" + product_id+";";

		System.out.println(SQLQuery);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {

			stmt.executeUpdate(SQLQuery);
			System.out.println("Record updated successfully");
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	@Override
	public void delete(Object id) {
		String SQLQuery = "DELETE FROM PRODUCTS WHERE product_id = " + id + ";";

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
		String SQLQuery = "select count(*) from products;";

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
	public ArrayList<Products> listAll() {

		String SQLQuery_SELECT = "SELECT * FROM PRODUCTS;";

		System.out.println(SQLQuery_SELECT);

		ArrayList<Products> listProducts = new ArrayList<Products>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connnection = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = connnection.prepareStatement(SQLQuery_SELECT);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				Products product = new Products(rs.getInt("product_id"),rs.getString("product_name"), rs.getString("product_des"),
						rs.getFloat("product_price"), rs.getString("product_img_source"), rs.getString("product_type"),
						rs.getString("product_brand"),rs.getInt("product_quantity"));
				
				listProducts.add(product);
			}
			
			return listProducts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Products update(Products t) {
		// TODO Auto-generated method stub
		return null;
	}

}
