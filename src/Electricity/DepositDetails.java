package Electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener{
    
    JTable table1;
    JLabel sort_by_no,sort_by_month;
    JButton search_bttn,print_bttn;
    Choice c1,c2;
    
    String x[]= {"Meter Number","Month","Units","Total Bill","Status"};
    String y[][] = new String[40][8];
    int i=0,j=0;
    
    DepositDetails(){
        
        super("Deposit Details");
        setSize(700,600);
        setLocation(350,80);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        sort_by_no= new JLabel("Sort by Meter_no");
        sort_by_no.setBounds(20,20,150,20);
        add(sort_by_no);
        
        c1= new Choice();
        
        sort_by_month= new JLabel("Sort by Month");
        sort_by_month.setBounds(400,20,150,20);
        add(sort_by_month);
        
        c2= new Choice();
        
        table1= new JTable(y,x);
        
        try{
            
            Conn c= new Conn();
            String s1= "select * from bill";
            ResultSet rs= c.stmnt.executeQuery(s1);
            
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            String s2="select * from customer";
            rs= c.stmnt.executeQuery(s2);
            while(rs.next()){
                c1.add(rs.getString("meter"));
                
            }           
            
        }catch(Exception e){}
        
        c1.setBounds(180,20, 150, 20);
        add(c1);
        
        c2.setBounds(550, 20, 120, 20);
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        add(c2);
        
        search_bttn = new JButton("Search");
        search_bttn.setBounds(20, 70, 80, 20);
        search_bttn.addActionListener(this);
        add(search_bttn);
        
        print_bttn = new JButton("Print");
        print_bttn.setBounds(120, 70, 80, 20);
        print_bttn.addActionListener(this);
        add(print_bttn);
        
        JScrollPane scroll= new JScrollPane(table1);
        scroll.setBounds(0, 100, 700, 650);
        add(scroll);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==search_bttn){
            
            String str= "select * from bill where meter='"+c1.getSelectedItem()+"' and month='"+c2.getSelectedItem()+"'";
            try{
                
                Conn c= new Conn();
                ResultSet rs= c.stmnt.executeQuery(str);
                table1.setModel(DbUtils.resultSetToTableModel(rs));               
            }
            catch(Exception e){}               
            }
        
        else if(ae.getSource()==print_bttn){
            try{
                table1.print();                
            }
            catch(Exception e){}               
        }
    }
    
    public static void main(String[] args){
        new DepositDetails().setVisible(true);
        
    }
    
}
