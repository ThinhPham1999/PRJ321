package bo;

import java.util.ArrayList;

import bean.Product;
import dao.ProductDAO;

public class ProductBO {
	
	public ArrayList<Product> getList(){
		return ProductDAO.listAll();
	}
	
	
}
