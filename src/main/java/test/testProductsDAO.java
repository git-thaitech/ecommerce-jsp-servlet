package test;

import java.util.ArrayList;

import dao.ProductsDAO;
import model.Products;

public class testProductsDAO {
	public static void main(String[] args) {
		testDeleteProduct(12);
		testDeleteProduct(13);
		testDeleteProduct(14);
		testDeleteProduct(15);
		testDeleteProduct(16);
		testDeleteProduct(17);
		testDeleteProduct(18);
	}
	
	public static int testCreateProduct() {
		ProductsDAO productsDAO = new ProductsDAO();
		
		Products product = new Products("ab","ab", (float)10.5,"ab","ab","ab",5);
		return productsDAO.create(product);
	}

	public static Products testGetProduct(int id) {
		ProductsDAO productsDAO = new ProductsDAO();
		return productsDAO.get(id);
	}
	
	public static void testDeleteProduct(int id) {
		ProductsDAO productsDAO = new ProductsDAO();
		productsDAO.delete(id);
	}
	
	public static long testCountProduct() {
		ProductsDAO productsDAO = new ProductsDAO();
		
		return productsDAO.count();
	}
	
	public static ArrayList<Products> testListProducts() {
		ProductsDAO productsDAO = new ProductsDAO();
		
		return productsDAO.listAll();
	}
}
