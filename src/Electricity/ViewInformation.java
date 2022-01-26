package Electricity;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class ViewInformation extends JFrame implements ActionListener{
    
    JButton back_bttn;
    ViewInformation(String meter){
        
        setSize(660,550);
        setLocation(400,120);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel title= new JLabel("View Customer Information");
        title.setBounds(200,0,500,40);
        title.setFont(new Font("Tahoma",Font.BOLD,16));
        title.setForeground(Color.RED); 
        add(title);
        
        //----------------NAME-------------------------
        JLabel name= new JLabel("Name");
        name.setBounds(50,70,100,20);
        add(name);
        
        JLabel name_field= new JLabel();
        name_field.setBounds(150,70,100,20);
        add(name_field);
        
        //-----------------Meter_no-------------------
        JLabel meter_no= new JLabel("Meter_No");
        meter_no.setBounds(50,120,100,20);
        add(meter_no);
        
        JLabel meter_no_field= new JLabel();
        meter_no_field.setBounds(150,120,100,20);
        add(meter_no_field);
        
        //--------------Address-----------------------
        
        JLabel address= new JLabel("Address");
        address.setBounds(50,170,100,20);
        add(address);
        
        JLabel address_field= new JLabel();
        address_field.setBounds(150,170,100,20);
        add(address_field);
        
        //-------------------CITY---------------------
        JLabel city= new JLabel("City");
        city.setBounds(50,220,100,20);
        add(city);
        
        JLabel city_field= new JLabel();
        city_field.setBounds(150,220,100,20);
        add(city_field);
        
        //-------------------STATE------------------------
        JLabel state= new JLabel("State");
        state.setBounds(350,70,100,20);
        add(state);
        
        JLabel state_field= new JLabel();
        state_field.setBounds(400,70,100,20);
        add(state_field);
        
        
        //-------------------EMAIL---------------------------
        JLabel email= new JLabel("Email");
        email.setBounds(350,120,100,20);
        add(email);
        
        JLabel email_field= new JLabel();
        email_field.setBounds(400,120,200,20);
        add(email_field);
        
        
        //-------------------PHONE-----------------------------
        JLabel phone= new JLabel("Phone");
        phone.setBounds(350,170,100,20);
        add(phone);
        
        JLabel phone_field= new JLabel();
        phone_field.setBounds(400,170,100,20);
        add(phone_field);
        
        //------------------Fetch Data from DB------------------
        try{
            Conn c= new Conn();
            ResultSet rs= c.stmnt.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                
                name_field.setText(rs.getString("name"));
                meter_no_field.setText(rs.getString("meter"));
                address_field.setText(rs.getString("address"));
                city_field.setText(rs.getString("city"));
                state_field.setText(rs.getString("state"));
                email_field.setText(rs.getString("email"));
                phone_field.setText(rs.getString("phone"));                
            }
            
            
        }catch(Exception e){}
        
        back_bttn= new JButton("BACK");
        back_bttn.setBounds(290,240,100,25);
        back_bttn.setBackground(Color.BLACK);
        back_bttn.setForeground(Color.WHITE);
        back_bttn.addActionListener(this);
        add(back_bttn);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8  = new JLabel(i3);
        l8.setBounds(20, 240, 600, 280);
        add(l8);               
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        
        new ViewInformation("").setVisible(true);
    }
}
