/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Thinh
 */
public class Product {
    private String productID;
    private String productName;
    private String productUnit;
    private int productPrice;
    
    public Product() {
    }

    public Product(String productID, String productName, String productUnit, int productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productUnit = productUnit;
        this.productPrice = productPrice;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productUnit=" + productUnit + ", productPrice=" + productPrice + '}';
    }
    
    
}
