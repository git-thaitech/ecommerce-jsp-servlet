package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductsDAO;
import model.Products;
import model.Users;

@WebServlet("/admin/products")
public class AdminProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminProductsServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Users user = new Users();
		user = (Users) session.getAttribute("adminSession");
		
		if (user != null) {
			doGet_getAllProduct(request, response);
		} else {
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}
	}


	protected void doGet_getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductsDAO productsDAO = new ProductsDAO();

		List<Products> proList = new ArrayList<Products>();

		proList = productsDAO.listAll();

		request.setAttribute("proList", proList);
		request.getRequestDispatcher("/admin/products.jsp").forward(request, response);
	}
	
	

}
