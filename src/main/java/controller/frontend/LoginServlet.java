package controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Users;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    
    public LoginServlet() {
        super();   
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		UsersDAO userDAO = new UsersDAO();
		HttpSession session = request.getSession();
		
		String user_mail = request.getParameter("user_mail");
		String password = request.getParameter("password");
		
		if (userDAO.get(user_mail) != null) {
			Users user = userDAO.get(user_mail);
			if (user.getUser_mail().equals(user_mail) && user.getPassword().equals(password)) {
				session.setAttribute("userSession", user);
				response.sendRedirect("products");
			} else {
				request.setAttribute("errorLogin", "Username or password is invalid");
				request.getRequestDispatcher("frontend/login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorLogin", "Username or password is invalid");
			request.getRequestDispatcher("frontend/login.jsp").forward(request, response);
		}
		
	}

}
