package com;

import java.util.Scanner;
import java.sql.*;

public class Owner {

    protected boolean ownerLogin(String Ousername, String Opassword) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Customer.url, Customer.user, Customer.pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from ownerlogin");
            while (rs.next()) {
                if (rs.getString(1).equals(Ousername) && rs.getString(2).equals(Opassword))
                    return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    protected void importGoods() {
        Scanner s = new Scanner(System.in);
        String item;
        float price;
        System.out.println("Enter the item name to import: ");
        item = s.nextLine();
        System.out.println("Enter the price of it:  ");
        price = s.nextFloat();
        String query = "insert into groceries values(" + "'" + item + "'" + "," + price + ")";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Customer.url, Customer.user, Customer.pass);
            Statement stmt = con.createStatement();
            int n = stmt.executeUpdate(query);
            if (n != 0) {
                System.out.println("Successfully added !!");
            } else {
                System.out.println("Error Occured try again! ");
            }
        } catch (Exception e) {

        }
    }

    protected void changePrice() {
        Scanner s = new Scanner(System.in);
        String item;
        float price;
        System.out.println("Enter the item name to change price: ");
        item = s.nextLine();
        System.out.println("Enter the updated price of it:  ");
        price = s.nextFloat();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Customer.url, Customer.user, Customer.pass);
            Statement stmt = con.createStatement();
            String query = "update groceries set price=" + price + " where items='" + item + "'";
            int n = stmt.executeUpdate(query);
            if (n != 0) {
                System.out.println("Successfully price is updated!");
            } else {
                System.out.println("Error occured! ");
            }
        } catch (Exception e) {

        }
    }

    protected void removeItems() {
        Scanner s = new Scanner(System.in);
        String item;
        System.out.println("Enter the item do you want to remove: ");
        item = s.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(Customer.url, Customer.user, Customer.pass);
            Statement stmt = con.createStatement();
            String query = "delete from groceries where items = '" + item + "'";
            int n = stmt.executeUpdate(query);
            if (n != 0) {
                System.out.println("Successfully item is removed!");
            } else {
                System.out.println("Error occured! item not found in list");
            }
        } catch (Exception e) {

        }
    }
}