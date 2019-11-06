package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddProductFilter implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    public AddProductFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        RequestDispatcher rd = null;
        String message = "";
        String productID = request.getParameter("productID");
        if (productID.equals("") || productID.charAt(0) != 'P' || productID.length() != 4) {
            message = "Product ID must enter like P001";
            request.setAttribute("message", message);
            rd = request.getRequestDispatcher("addFailed.jsp");
            rd.forward(request, response);
        }

        String productName = request.getParameter("productName");
        if (productName.length() < 2) {
            message = "Product name must large than 2";
            request.setAttribute("message", message);
            rd = request.getRequestDispatcher("addFailed.jsp");
            rd.forward(request, response);
        }

        String productUnit = request.getParameter("productUnit");
        if (productUnit.equals("")) {
            message = "Product unit must not null";
            request.setAttribute("message", message);
            rd = request.getRequestDispatcher("addFailed.jsp");
            rd.forward(request, response);
        }

        String productPrice = request.getParameter("productPrice");
        try {
            int price = Integer.parseInt(productPrice);
            if (price < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            message = "Product price must large than 0";
            request.setAttribute("message", message);
            rd = request.getRequestDispatcher("addFailed.jsp");
            rd.forward(request, response);
        }

        chain.doFilter(request, response);
    }

    /**
     * Return the filter configuration object for this filter.
     * @return 
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AddProductFilter:Initializing filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
