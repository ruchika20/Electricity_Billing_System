package Electricity;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame{
 
    JTable table1;
    String x[] = {"Meter Number","Month","Units","Total Bill","Status"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    BillDetails(String meter){
        
        super("Bill Details");
        setSize(700,650);
        setLocation(380,70);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        table1 = new JTable(y,x);
        
        try{
            Conn c  = new Conn();
            String s1 = "select * from bill where meter = " + meter;
            ResultSet rs  = c.stmnt.executeQuery(s1);
            
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane sp = new JScrollPane(table1);
        sp.setBounds(0, 0, 700, 650);
        add(sp);
        
    }
    
    public static void main(String[] args){
        new BillDetails("").setVisible(true);
    }
    
}