package com;

import java.util.*;
import java.sql.*;

public class Customer {
    static protected String Id, password, url = "jdbc:mysql://localhost:3306/supermarket", user = "root", pass = "0852";

    static protected boolean temp = false;

    // ----Login method ----
    protected boolean login(String Id, String password) {
        try {
            String query = "select * from customerlogin where " + "password = " + "'" + password + "'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString(1).equals(Id) && rs.getString(2).equals(password)) {
                    return true;
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Incorrect Login Details! ");
            System.out.println("Try Again!");
        }

        System.out.println("Login failed! ");
        return false;
    }

    // ---- Registration method---
    protected boolean registerNewId() {
        System.out.println("Enter your New Id: ");
        Scanner s = new Scanner(System.in);
        Id = s.nextLine().trim();
        System.out.println("Enter your Password! ");
        password = s.nextLine().trim();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement smt = con.createStatement();
            String query = "insert into customerlogin values(" + "'" + Id + "'" + "," + "'" + password + "')";
            int n = smt.executeUpdate(query);
            if (n != 0) {
                System.out.println("Successfully Registred your Id! ");
                return true;
            }

      
    } catch (Exception e) {
            System.out.println("Registration failed!!");
            System.out.println("Try diffrent Id...");
            return false; 
        }

        return false;
    }
}
