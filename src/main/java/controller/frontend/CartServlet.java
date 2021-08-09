package controller.frontend;

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
import model.Item;
import model.Products;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_DisplayCart(request, response);
		} else {
			if (action.equalsIgnoreCase("addtocart")) {
				doGet_AddToCart(request, response);
			} else if (action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			} else if (action.equalsIgnoreCase("gotocart")) {
				doGet_DisplayCart(request, response);
			}
		}
	}

	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("frontend/cart.jsp").forward(request, response);
	}

	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = isExistedProductInCart(request.getParameter("id"), cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("cart");
	}

	protected void doGet_AddToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductsDAO productDAO = new ProductsDAO();
		HttpSession session = request.getSession();

		Products product = new Products();
		product = productDAO.get(request.getParameter("id"));

		if (session.getAttribute("cart") == null) {
			if (product.getProduct_quantity() > 0) {
				List<Item> cart = new ArrayList<Item>();
				cart.add(new Item(product, 1));
				session.setAttribute("cart", cart);
				response.sendRedirect("index.jsp");
			} else {
				request.setAttribute("overStock", "The product reached the limit or was out of stock!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int indexOfExistedProduct = isExistedProductInCart(request.getParameter("id"), cart);

			if (indexOfExistedProduct == -1) {
				if (product.getProduct_quantity() > 0) {
					cart.add(new Item(product, 1));
					session.setAttribute("cart", cart);
					response.sendRedirect("index.jsp");
				} else {
					request.setAttribute("overStock", "The product reached the limit or was out of stock!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} else {
				int quantity = cart.get(indexOfExistedProduct).getQuantity();
				if (cart.get(indexOfExistedProduct).getQuantity() < product.getProduct_quantity()) {
					quantity++;
					cart.get(indexOfExistedProduct).setQuantity(quantity);

					session.setAttribute("cart", cart);
					response.sendRedirect("index.jsp");
				} else {
					request.setAttribute("overStock", "The product reached the limit or was out of stock!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}

			}

		}
	}

	private int isExistedProductInCart(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getProduct_id() == Integer.parseInt(id)) {
				return i;
			}
		}
		return -1;
	}


}
