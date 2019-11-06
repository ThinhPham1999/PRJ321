
package controller;

import bean.Product;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddProductController extends HttpServlet {


    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String productUnit = request.getParameter("productUnit");
        int productPrice = Integer.parseInt(request.getParameter("productPrice"));
        String message = "";
        ProductDAO productDAO = new ProductDAO();
        if (productDAO.getProduct(productID) != null){
            message = "Product ID is duplicate!!";
            request.setAttribute("message", message);
            rd = request.getRequestDispatcher("addFailed.jsp");
            rd.forward(request, response);
        }
        productDAO.newProduct(new Product(productID, productName, productUnit, productPrice));
        rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

}
