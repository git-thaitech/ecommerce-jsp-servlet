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

import dao.UsersDAO;
import model.Users;

/**
 * Servlet implementation class AdminUsersServlet
 */
@WebServlet("/admin/users")
public class AdminUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Users user = new Users();
		user = (Users) session.getAttribute("adminSession");

		if (user != null) {
			doGet_getAllUsers(request, response);
		} else if (request.getParameter("action") != null) {
		} else {
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}
	}

	protected void doGet_getAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsersDAO usersDAO = new UsersDAO();

		List<Users> userList = new ArrayList<Users>();
		userList = usersDAO.listAll();

		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/admin/users.jsp").forward(request, response);
	}

	

	protected void doGet_CreateANewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
