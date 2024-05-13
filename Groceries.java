package com;

import com.Customer;

import java.sql.*;

public class Groceries {
    protected void gorceriesList() {
        Customer cus = new Customer();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(cus.url, cus.user, cus.pass);
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("select * from groceries");
 
            while (rs.next()) {
                System.out.println(" * " +rs.getString(1) + "   |   $ " + rs.getFloat(2) +"    |");
                if (rs.wasNull()) {
                    System.out.println("Out of stock :( please visit after some time ...");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Groceries List not found");
        }
    }
}