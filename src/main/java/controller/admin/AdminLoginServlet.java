package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Users;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersDAO usersDAO = new UsersDAO();
		HttpSession session = request.getSession();

		String user_mail = request.getParameter("user_mail");
		String password = request.getParameter("password");

		if (usersDAO.get(user_mail) == null || usersDAO.get(user_mail).getAccount_role() == 2) {
			request.setAttribute("errorLogin", "Username or password is invalid");
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		} else {
			Users user = usersDAO.get(user_mail);
			if (user.getUser_mail().equals(user_mail) && user.getPassword().equals(password)) {
				session.setAttribute("adminSession", user);
				response.sendRedirect("/Assignment3/admin/orders");
			} else {
				request.setAttribute("errorLogin", "Username or password is invalid");
				request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			}
		}
	}

}
