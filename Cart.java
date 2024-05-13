package com;

import java.sql.*;
import java.util.*;

public class Cart {
    static boolean A = false;
    static int n;

    // add to cart
    protected void addToCart() {
        Customer cu = new Customer();
        Scanner s = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(cu.url, cu.user, cu.pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from groceries");
            System.out.println("\nEnter the item to your cart: \n");
            String item = s.nextLine();
            System.out.println("Enter the quntity");
            n = s.nextInt();
            while (rs.next()) {
                if (item.equals(rs.getString(1))) {
                    stmt.executeUpdate(
                            "insert into cart values (" + "'" + item + "'" + "," + rs.getString(2) + "," + n+")");
                    System.out.println("\nAdded successfully!\n");
                    A = true;
                    break;
                }
            }
            if (!A) {
                System.out.println("\nItem not found\n");
            }

            rs.close();
            con.close();
        } catch (Exception e) {

        }
    }

    // show cart
    protected void showCart() {
        Customer cu = new Customer();
        Scanner s = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(cu.url, cu.user, cu.pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * From Cart;");

            System.out.println("*********** My Cart **********");

            while (rs.next()) {

                System.out.println("|\t" + rs.getString(1) + "   |   " + rs.getFloat(2) + "     | \t "+rs.getInt(3)+"    |");
                if (!rs.next()) {
                    return;
                }
            }
            System.out.println("----------Empty cart--------");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // remove item from cart
    protected void removeItems() {
        Customer cu = new Customer();

        Scanner s = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(cu.url, cu.user, cu.pass);
            Statement stmt = con.createStatement();
            String query, item;
            System.out.println("\nEnter the item do you want to remove: \n");
            item = s.nextLine();
            query = "delete from cart where items=" + "'" + item + "'";
            int n = stmt.executeUpdate(query);
            if (n == 0) {
                System.out.println("\n No items are there to delete in your cart!\n");
            } else {

                System.out.println("\n Deleted Successfully!!\n");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}