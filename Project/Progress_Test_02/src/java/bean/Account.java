/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;

/**
 *
 * @author Thinh
 */
public class Account {
    private int accountID;
    private String accountName;
    private int blance;

    public Account() {
    }

    public Account(int accountID, String accountName, int blance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.blance = blance;
    }
    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getBlance() {
        return blance;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }
    
    public static ArrayList<Account> getAll(){
        ArrayList<Account> list = new ArrayList<>();
        list.add(new Account(0, "Minh", 1));
        list.add(new Account(2, "Nam", 2));
        list.add(new Account(3, "Van", 2));
        return list;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", accountName=" + accountName + ", blance=" + blance + '}';
    }
    
    
}
