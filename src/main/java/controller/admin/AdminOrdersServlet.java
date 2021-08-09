package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDAO;
import model.Orders;
import model.Users;

@WebServlet("/admin/orders")
public class AdminOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminOrdersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrdersDAO ordersDAO = new OrdersDAO();
		HttpSession session = request.getSession();

		Users user = new Users();
		user = (Users) session.getAttribute("adminSession");

		if (user != null) {
			String action = request.getParameter("action");
			System.out.println(action);
			if (action == null) {
				request.setAttribute("orders", ordersDAO.listAll());
				request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
			} else if (action.equalsIgnoreCase("remove")) {
				ordersDAO.delete(request.getParameter("id"));
				request.setAttribute("orders", ordersDAO.listAll());
				request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}

	}

}
