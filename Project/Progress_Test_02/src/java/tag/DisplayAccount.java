/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import bean.Account;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Thinh
 */
public class DisplayAccount extends SimpleTagSupport {

    
    private int id;

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Called by the container to invoke this tag.The implementation of this
 method is provided by the tag library developer, and handles all tag
 processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     * @throws java.io.IOException
     */
    
    @Override
    public void doTag() throws JspException, IOException {
        
        JspWriter out = getJspContext().getOut();
        ArrayList<Account> list = Account.getAll();
        for (Account account:list){
            if (account.getAccountID() == id){
                out.print("Account ID:  " + id + "<br>");
                out.print("Account name:  " + account.getAccountName() + "<br>");
                out.print("Account balance:  " + account.getBlance() + "<br>");
            }
        }
        
    }
    
}
