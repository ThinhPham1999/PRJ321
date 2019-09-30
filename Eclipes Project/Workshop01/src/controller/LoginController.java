package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.ProductDB;
import bean.Customer;
import bean.Product;
import bean.ProductLine;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("customerID");
        String pass = request.getParameter("pass");
        
        Customer cus = null;
		cus = Customer.login(id, pass);
		if(cus != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("sessionname", id);
			ArrayList<Product> listProduct = new ArrayList<Product>();	
			listProduct = ProductDB.listAll();
			
			ArrayList<ProductLine> listProLine = new ArrayList<ProductLine>();
			for (Product pro:listProduct) {
				listProLine.add(new ProductLine(pro, 0));
			}
			session.setAttribute("listProduct", listProduct);
			session.setAttribute("listProductLine", listProLine);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else {
			String msg1 = "Login Failed";
			request.setAttribute("messageFailed", msg1);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
