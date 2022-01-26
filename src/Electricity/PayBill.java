package Electricity;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class PayBill extends JFrame implements ActionListener{
    
    JLabel meter_no, name, month, units, total_bill, status;
    JButton pay_bttn,back_bttn;
    JLabel meter_field, name_field, units_field, total_bill_field, status_field;    
    Choice c1; 
    String meter;
            
    PayBill(String meter){
        
        this.meter= meter;
        
        setBounds(380, 100, 750, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel title= new JLabel("Pay Electricity Bill");
        title.setBounds(200,0,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,24));
        add(title);
        
        //--------------meter_no--------------------------
        meter_no= new JLabel("Meter_No");
        meter_no.setBounds(60,100,100,20);
        add(meter_no);
        
        meter_field= new JLabel();
        meter_field.setBounds(230,100,150,20);
        add(meter_field);
        
        //----------------name----------------------------
        name= new JLabel("Name");
        name.setBounds(60,150,100,20);
        add(name);
        
        name_field= new JLabel();
        name_field.setBounds(230,150,150,20);
        add(name_field);
        
        //----------------month-------------------------
        month= new JLabel("Month");
        month.setBounds(60,200,100,20);
        add(month);
        
        c1= new Choice();
        c1.setBounds(230,200,150,20);
        c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");
        add(c1);
        
        //----------------units----------------------------
        units= new JLabel("Units");
        units.setBounds(60,250,100,20);
        add(units);
        
        units_field= new JLabel();
        units_field.setBounds(230,250,150,20);
        add(units_field);
        
        //----------------total_bill----------------------
        total_bill= new JLabel("Total Bill");
        total_bill.setBounds(60,300,100,20);
        add(total_bill);
        
        total_bill_field= new JLabel();
        total_bill_field.setBounds(230,300,150,20);
        add(total_bill_field);
        
        //----------------status-------------------------
        status= new JLabel("Status");
        status.setBounds(60,350,100,20);
        add(status);
        
        status_field= new JLabel();
        status_field.setBounds(230,350,150,20);
        add(status_field);
        
        try{
            
            Conn c= new Conn();
            ResultSet rs= c.stmnt.executeQuery("select * from customer where meter="+meter);
            while(rs.next()){
                
                meter_field.setText(rs.getString("meter"));
                name_field.setText(rs.getString("name"));
            }
            
            rs= c.stmnt.executeQuery("select * from bill where meter='"+meter+"' and month='"+month+"'");
            while(rs.next()){
                
                units_field.setText(rs.getString("units"));
                total_bill_field.setText(rs.getString("total_bill"));
                status_field.setText(rs.getString("status"));
            }
            
        }catch(Exception e){}
        
        c1.addItemListener(new ItemListener(){            
            
            @Override
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.stmnt.executeQuery("select * from bill where meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
                    while(rs.next()){
                        units_field.setText(rs.getString("units"));
                        total_bill_field.setText(rs.getString("total_bill"));
                        status_field.setText(rs.getString("status"));
                    }
                }catch(Exception e){}
            }
        });
        
        //------------buttons-----------------------
        
        pay_bttn = new JButton("Pay");
        pay_bttn.setBounds(130, 420, 100, 25);
        add(pay_bttn);
        
        back_bttn = new JButton("Back");
        back_bttn.setBounds(250, 420, 100, 25);
        add(back_bttn);
        
        pay_bttn.setBackground(Color.BLACK);
        pay_bttn.setForeground(Color.WHITE);

        back_bttn.setBackground(Color.BLACK);
        back_bttn.setForeground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(410, 330,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l21 = new JLabel(i3);
        l21.setBounds(400, 120, 410, 330);
        add(l21);
        
        pay_bttn.addActionListener(this);
        back_bttn.addActionListener(this);   
      
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==pay_bttn){
            try{
                
                Conn c= new Conn();
                c.stmnt.executeQuery("update bill set status = 'Paid' where meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");                
            }
            catch(Exception e){}
            
            this.setVisible(false);
            new Paytm(meter).setVisible(true);

        }
        else if(ae.getSource()== back_bttn){
            this.setVisible(false);
        }        
    }
    
    public static void main(String[] args){
        new PayBill("").setVisible(true);
    }
    
}
