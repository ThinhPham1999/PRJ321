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
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Thinh
 */
public class Display extends SimpleTagSupport {

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
        
        out.print("<table border='1'>");
        out.print("<tr>");
        out.print("<th> Account ID </th>");
        out.print("<th> Account name </th>");
        out.print("<th> Balance </th>");
        out.print("<th> </th>");
        out.print("</tr>");
        ArrayList<Account> list = Account.getAll();
        for (Account account:list){
            out.print("<tr>");
            out.print("<td> "+ account.getAccountID() +"</td>");
            out.print("<td> "+ account.getAccountName()+"</td>");
            out.print("<td> "+ account.getBlance()+"</td>");
            out.print("<td><a href=" + "DisplayController?id=" + account.getAccountID() + ">Display</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
    
}
