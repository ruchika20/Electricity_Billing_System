package Electricity;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateInformation extends JFrame implements ActionListener{
    
    JTextField txt1,txt2,txt3,txt4,txt5;
    JButton update_bttn, back_bttn;
    JLabel name_field,meter_no_field;
    String meter;
    
    UpdateInformation(String meter){
        this.meter = meter;
        
        setBounds(400,150,700,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel title= new JLabel("Update Customer Information");
        title.setBounds(110,0,400,30);
        title.setFont(new Font("Tahoma",Font.PLAIN,20));
        title.setForeground(Color.RED); 
        add(title);
        
        //----------------NAME-------------------------
        JLabel name= new JLabel("Name");
        name.setBounds(50,70,100,20);
        add(name);
        
        name_field= new JLabel("Ruchika Pandey");
        name_field.setBounds(150,70,100,20);
        add(name_field);
        
        //-----------------Meter_no-------------------
        JLabel meter_no= new JLabel("Meter_No");
        meter_no.setBounds(50,110,100,20);
        add(meter_no);
        
        meter_no_field= new JLabel("123456");
        meter_no_field.setBounds(150,110,100,20);
        add(meter_no_field);
        
        //--------------Address-----------------------
        
        JLabel address= new JLabel("Address");
        address.setBounds(50,150,100,20);
        add(address);
        
        txt1= new JTextField();
        txt1.setBounds(150,150,200,20);
        add(txt1);
        
        //-------------------CITY---------------------
        JLabel city= new JLabel("City");
        city.setBounds(50,190,100,20);
        add(city);
        
        txt2= new JTextField();
        txt2.setBounds(150,190,200,20);
        add(txt2);
        
        //-------------------STATE------------------------
        JLabel state= new JLabel("State");
        state.setBounds(50,230,100,20);
        add(state);
        
        txt3= new JTextField();
        txt3.setBounds(150,230,200,20);
        add(txt3);
        
        
        //-------------------EMAIL---------------------------
        JLabel email= new JLabel("Email");
        email.setBounds(50,270,100,20);
        add(email);
        
        txt4= new JTextField();
        txt4.setBounds(150,270,200,20);
        add(txt4);
        
        
        //-------------------PHONE-----------------------------
        JLabel phone= new JLabel("Phone");
        phone.setBounds(50,310,100,20);
        add(phone);
        
        txt5= new JTextField();
        txt5.setBounds(150,310,200,20);
        add(txt5);
        
        update_bttn = new JButton("Update");
        update_bttn.setBackground(Color.BLACK);
        update_bttn.setForeground(Color.WHITE);
        update_bttn.setBounds(70, 360, 100, 25);
        update_bttn.addActionListener(this);
        add(update_bttn);
        
        back_bttn = new JButton("Back");
        back_bttn.setBackground(Color.BLACK);
        back_bttn.setForeground(Color.WHITE);
        back_bttn.setBounds(230, 360, 100, 25);
        back_bttn.addActionListener(this);
        add(back_bttn);       
        
        
        ImageIcon update_img= new ImageIcon(ClassLoader.getSystemResource("icon/update_info.jpg"));
        Image img1= update_img.getImage().getScaledInstance(240,260,Image.SCALE_DEFAULT);
        ImageIcon img2= new ImageIcon(img1);
        JLabel img_label= new JLabel(img2);
        img_label.setBounds(420, 50, 240, 260);
        add(img_label);
        
        try{
            Conn c= new Conn();
            ResultSet rs= c.stmnt.executeQuery("select * from customer where meter='"+meter+"'");
            while(rs.next()){
                
                name_field.setText(rs.getString(1));
                meter_no_field.setText(rs.getString(2));
                txt1.setText(rs.getString(3));
                txt2.setText(rs.getString(4));
                txt3.setText(rs.getString(5));
                txt4.setText(rs.getString(6));
                txt5.setText(rs.getString(7));
            }
            
        }catch(Exception e){}
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == update_bttn){
            String s1 = name_field.getText();
            String s2 = meter_no_field.getText();
            String s3 = txt1.getText();
            String s4 = txt2.getText();
            String s5 = txt3.getText();
            String s6 = txt4.getText();
            String s7 = txt5.getText();
            
            try{
                Conn c = new Conn();
                c.stmnt.executeUpdate("update customer set address = '"+s3+"', city = '"+s4+"', state = '"+s5+"', email = '"+s6+"', phone = '"+s7+"' where meter = '"+meter+"'");
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                this.setVisible(false);
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == back_bttn){
            this.setVisible(false);
        }
    }
    
    public static void main (String[] args){
        
        new UpdateInformation("").setVisible(true);
    }
       
}
