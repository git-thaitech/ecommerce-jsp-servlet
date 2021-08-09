package controller.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Users;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    
    public RegisterServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		UsersDAO userDAO = new UsersDAO();
		
		String user_mail = request.getParameter("user_mail");
		String password = request.getParameter("password");
		String full_name = request.getParameter("full_name");
		String user_address = request.getParameter("user_address");
		String user_phone = request.getParameter("user_phone");
		
		if (userDAO.get(user_mail) != null) {
			HttpSession session = request.getSession(false);
			//save message in session
			session.setAttribute("existedAccount", "Email have been used already!");
			response.sendRedirect("frontend/register.jsp");
		} else {
			Users user = new Users(user_mail,password,2,full_name,user_address,user_phone);
			userDAO.create(user);

			//successful registration message 
			request.setAttribute("registerSuccessful", "You are successfully registered!");
			request.getRequestDispatcher("frontend/login.jsp").forward(request, response);
		}
	
	}

}
