package controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDAO;


@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductsServlet() {
        super();
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductsDAO productsDAO = new ProductsDAO();
		request.setAttribute("productsList", productsDAO.listAll());
		request.getRequestDispatcher("frontend/index.jsp").forward(request, response);
	}

}
