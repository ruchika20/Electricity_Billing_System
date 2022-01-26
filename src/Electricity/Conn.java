package Electricity;

import java.sql.*;

public class Conn {
    
  Connection c;
  Statement stmnt;
    
    public Conn(){
        try{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://localhost:3310/ElectricityBillingSystem", "ruchi", "Rjan20@22");
        stmnt=c.createStatement();
        
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }
}
