package Electricity;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class CustomerDetails extends JFrame implements ActionListener{
    
    JTable table1;
    JButton print_bttn;
    String x[]= {"Customer Name","Meter Number","Address","City","State","Email","Phone"};
    String y[][]= new String[40][8];
    
    int i=0,j=0;
    
    CustomerDetails(){
        
        super("Customer Details");
        setSize(1000,600);
        setLocation(200,80);
        
        try{
            
            Conn c= new Conn();
            String s1= "select * from customer";
            ResultSet rs= c.stmnt.executeQuery(s1);
            
            while(rs.next()){
                y[i][j++]= rs.getString("name");
                y[i][j++]=rs.getString("meter");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("city");
                y[i][j++]=rs.getString("state");
                y[i][j++]=rs.getString("email");
                y[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            
        table1 = new JTable(y,x);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }        
        
        print_bttn = new JButton("Print");
        add(print_bttn,"South");
        JScrollPane sp = new JScrollPane(table1);
        add(sp);
        print_bttn.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        
        try{
            table1.print();
        }
        catch(Exception ae){}
        
    }
    
    public static void main(String[] args){
        
        new CustomerDetails().setVisible(true);
    }
    
}
