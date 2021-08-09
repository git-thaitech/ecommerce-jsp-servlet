package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductsDAO;
import dao.UsersDAO;
import model.Item;
import model.Orders;
import model.Orders_detail;
import model.Products;
import model.Users;
import dao.OrdersDAO;
import dao.Orders_detailDAO;

@WebServlet("/admin/orders_detail")
public class AdminOrdersDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminOrdersDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		Users user = new Users();
		user = (Users) session.getAttribute("adminSession");

		if (user != null) {
			ProductsDAO productsDAO = new ProductsDAO();
			Orders_detailDAO orders_detailDAO = new Orders_detailDAO();
			OrdersDAO ordersDAO = new OrdersDAO();
			
			Integer orderId = Integer.parseInt(request.getParameter("id"));
			List<Orders_detail> orders_detailList = new ArrayList<Orders_detail>();
			List<Item> itemListInOrder = new ArrayList<Item>();
			Orders order = new Orders();
			
			order = ordersDAO.get(orderId);
			orders_detailList = orders_detailDAO.get(orderId);
			
			for (Orders_detail orders_detail: orders_detailList) {
				Products product = new Products();
				product = productsDAO.get(orders_detail.getProduct_id());
				itemListInOrder.add(new Item(product, orders_detail.getAmount()));
			}
			
			
			request.setAttribute("order", order);
			request.setAttribute("itemList", itemListInOrder);
			request.getRequestDispatcher("/admin/order_detail.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}
		
	}

}
