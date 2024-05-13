package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerHome {
    static String Id, password,string;
    static public boolean a;

    private static boolean inputLogin() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your Customer Id:  ");
        Id = s.nextLine().trim();
        System.out.println("Enter your password: ");
        password = s.nextLine().trim();
        if (new Customer().login(Id, password) == true) {
            return true;
        }
        return false;
    }

    // menu
    protected static void menu() {
        Cart cart = new Cart();
        Groceries groceries = new Groceries();
        Payment payment = new Payment();
        System.out.println("Enter only 1 to 6");
        while (true) {
            System.out.println(
                    "1.Show groceries\n\n2.Add to cart\n\n3.Show my cart\n\n4.Remove items from cart\n\n5.Go to payments\n\n6.Exit");
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            switch (n) {
                case 1:
                    groceries.gorceriesList();
                    break;
                case 2:
                    cart.addToCart();
                    break;
                case 3:
                    cart.showCart();
                    break;
                case 4:
                    cart.removeItems();
                    break;
                case 5:
                
                    System.out.println("Do you want to confirm your order and exit: (yes/no)");

                   string=s.next();

                    if (string.equalsIgnoreCase("yes")) {
                        payment.getBill();
                        System.out.println("Thanks for visiting! ");
                      return;
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Entered worng Optoin! Try again...");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Customer customer = new Customer();

        Scanner s = new Scanner(System.in);
        System.out.println("Do you want to register or login ");
        String login = s.nextLine().trim();

        // login
        if (login.equalsIgnoreCase("login")) {

            boolean a;
            int n = 5;
            while (true) {

                if (inputLogin()) {
                    n--;
                    System.out.println("Login success!");
                    menu();
                    break;
                } else {
                    System.out.println("Try again " + n + " attempts left");
                    n--;
                    a = inputLogin();
                    if (a == true) {
                        System.out.println("Login success!");
                        menu();
                    } else {
                        System.out.println("Try again " + n + " attempts left");
                        n--;
                    }
                    if (n < 0) {
                        System.out.println("No of login attempts are over");
                        System.exit(0);
                    }
                }

            }
        }
        // register

        else if (login.equalsIgnoreCase("register")) {
            boolean b = customer.registerNewId();
            while (b != true) {
                b = customer.registerNewId();
            }
            boolean a;
            int n = 5;
            while (true) {

                if (inputLogin()) {
                    n--;
                    System.out.println("Login success!");
                    menu();
                    break;
                } else {
                    System.out.println("Try again " + n + " attempts left");
                    n--;
                    a = inputLogin();
                    if (a == true) {
                        System.out.println("Login success!");
                        menu();
                    } else {
                        System.out.println("Try again " + n + " attempts left");
                        n--;
                    }
                    if (n < 0) {
                        System.out.println("No of login attempts are over");
                        System.exit(0);
                    }
                }

            }
        }
        else{
            System.out.println("Wrong input!! ");
        }
    }
}