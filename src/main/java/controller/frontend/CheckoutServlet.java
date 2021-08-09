package controller.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDAO;
import dao.Orders_detailDAO;
import dao.ProductsDAO;
import model.Item;
import model.Orders;
import model.Orders_detail;
import model.Products;
import model.Users;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckoutServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			doGet_PlaceOrder(request, response);
		} else if (action.equalsIgnoreCase("remove")) {
			doGet_Remove(request, response);
		} else if (action.equalsIgnoreCase("buy")) {
			doGet_Buy(request, response);
		}

	}

	private void doGet_Buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		
		if (cart == null || isEmptyCart(cart)) {
			request.setAttribute("cartIsEmpty", "Your cart is empty, please come back to add some items!");
			request.getRequestDispatcher("frontend/cart.jsp").forward(request, response);
		} else {
			response.sendRedirect("frontend/checkout.jsp");
		}
		
	}

	protected void doGet_PlaceOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("userSession") == null) {
			request.setAttribute("loginFirst", "You need to login to finish your order!");
			request.getRequestDispatcher("./frontend/login.jsp").forward(request, response);
		} else {
			
			//Access DAO
			OrdersDAO ordersDAO = new OrdersDAO();
			Users user = (Users) session.getAttribute("userSession");
			Orders_detailDAO orders_detailDAO = new Orders_detailDAO();
			ProductsDAO productsDAO = new ProductsDAO();
			int newOrderId = ordersDAO.getLastestIndex()+1;
			
			//CREATE ORDER
		
			Orders order = new Orders();
			order.setOrder_id(newOrderId);
			order.setUser_mail(user.getUser_mail());
			order.setTotal(Float.parseFloat(request.getParameter("total")));

			
			order.setOrder_address(user.getUser_address());
			

			ordersDAO.create(order);
			
			//CREATE ORDER DETAIL AND UPDATE QUANTITY
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			List<Orders_detail> orders_detailsList = new ArrayList<Orders_detail>();
			
			int productId = 0;
			for (Item item: cart) {				
				orders_detailsList.add(new Orders_detail(newOrderId,item.getProduct().getProduct_id(),item.getQuantity()));
				productId = item.getProduct().getProduct_id();
				int restQuantity = productsDAO.get(productId).getProduct_quantity() - item.getQuantity();
				productsDAO.updateQuantity(productId, restQuantity);
			}
			
			orders_detailDAO.create(orders_detailsList);
			
			//Remove CART session after finish order
			session.removeAttribute("cart");
			
			//Successful message!
			String message = "Your order is placed successfully! Order ID: " + ordersDAO.getLastestIndex();
			request.setAttribute("placeOrderSuccessFully", message);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
	}
	
	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExistedProductInCart(request.getParameter("id"), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("frontend/checkout.jsp").forward(request, response);
	}
	
	private int isExistedProductInCart(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getProduct_id() == Integer.parseInt(id)) {
				return i;
			}
		}
		return -1;
	}
	
	private boolean isEmptyCart(List<Item> list) {
		if (list.size() == 0)
			return true;
		return false;
	}

}
