package com;

import java.util.Scanner;

public class Home {
public static void main(String[] args) {
Scanner s=new Scanner(System.in);
int n;
System.out.println("1.Customer account\n2.Owner account\n");
n=s.nextInt();
while(true){
         if(n==1){
            CustomerHome.main(args);
            return;
         }else if(n==2){
            OwnerHome.main(args);
            return;
         }else{
            System.out.println("Wrong Input try again!! \n");
            System.out.println("Wrong inpupt");
            n=s.nextInt();
         }
}       

}
}