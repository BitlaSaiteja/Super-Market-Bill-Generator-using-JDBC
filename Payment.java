package com;

import java.sql.*;

public class Payment extends Thread{
    protected static void payments() {
        Customer cu = new Customer();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(cu.url, cu.user, cu.pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from cart");
            while (rs.next()) {
                stmt.executeUpdate("insert into payments values(" + (rs.getFloat(2)*rs.getFloat(3))+ ")");
            }
            rs.close();
            con.close();
            
        } catch (Exception e) {

        }
    }

    private static float sum = 0.0f;
       public void run(){
          try{
            for(int i=0;i<20;i++){
                Thread.sleep(175);
                System.out.print(".");
              }
          }catch(Exception w){

          }
       }
    protected  void getBill() {
        payments();
        Customer cu = new Customer();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(cu.url, cu.user, cu.pass);
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select price from payments");
            while(rs.next()){
                float f=rs.getFloat(1);
                sum+=f;
            }
            stmt.executeUpdate("delete from cart");
               stmt.executeUpdate("delete from payments");
            rs.close();
               con.close();
               Payment p=new Payment();
               Thread t=new Thread(p);
               System.out.println("Generating Bill");
               t.run();
               System.out.println("\nThe total bill is "+sum);
               
        } catch (Exception e) {

        }
    }
}