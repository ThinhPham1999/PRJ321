package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.CustomerDB;
import bean.Customer;
import bean.ShopCart;

/**
 * Servlet implementation class ShoppingCardController
 */
@WebServlet("/ShoppingCardController")
public class ShoppingCardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCardController() {
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
		request.getSession().setAttribute("listCard", ProductController.shop.getCartItems());
		ArrayList<Customer> listCustomer = CustomerDB.listAll();
		int total = ProductController.shop.total();
		request.getSession().setAttribute("listCustomer", listCustomer);
		request.getSession().setAttribute("total", total);
		RequestDispatcher rd = request.getRequestDispatcher("shopcart.jsp");
		rd.forward(request, response);
	}

}
