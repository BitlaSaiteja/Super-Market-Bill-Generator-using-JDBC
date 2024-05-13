package com;

import java.util.Scanner;

public class OwnerHome {
    private static String Id, password;

    private static boolean inputLogin() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your Owner Id:  ");
        Id = s.nextLine().trim();
        System.out.println("Enter your password: ");
        password = s.nextLine().trim();
        if (new Owner().ownerLogin(Id, password)) {
            return true;
        }
        return false;
    }

    private static void menu() {
        while (true) {
            Scanner s = new Scanner(System.in);
            Owner owner = new Owner();
            System.out.println("\n\n1.Import goods\n\n2.Change price\n\n3.Remove Items\n\n4.Show groceries\n\n5.Exit");
            int n = s.nextInt();
            switch (n) {
                case 1:
                    owner.importGoods();
                    break;
                case 2:
                    owner.changePrice();
                    break;
                case 3:
                    owner.removeItems();
                    break;
                case 4:
                    new Groceries().gorceriesList();
                    break;
                    case 5:
                    System.exit(0);
                    default:
                    System.out.println("Entered worng input try again! ");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        boolean a;
        int n=5;
        while (true) {
            
            if (inputLogin()) {
                n--;
                System.out.println("Login success!");
                menu();
                break;
            } else {
                System.out.println("Try again "+n+" attempts left");
                n--;
                a = inputLogin();
                if (a == true) {
                    System.out.println("Login success!");
                    menu();
                }else{
                    System.out.println("Try again "+n+" attempts left");
                    n--;
                }
                if(n<0){
                    System.out.println("No of login attempts are over");
                    System.exit(0);
                }
            }
        }
    }
}
