package Electricity;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class CalculateBill extends JFrame implements ActionListener{
    
    JLabel meter_no, name, address, unit_consumed, month;
    JButton submit, cancel;
    Choice meter_c1,month_c2;
    JTextField txt1;   
    
    CalculateBill(){
        
        JPanel panel1= new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(173, 216, 230));
        
        JLabel title= new JLabel("Calculate Electricity Bill");
        title.setBounds(30, 10, 400, 30);
        title.setFont(new Font("Senserif",Font.PLAIN,24));
        //Move the label to center
        title.setHorizontalAlignment(JLabel.CENTER);       
        panel1.add(title);
        
        meter_no= new JLabel("Meter_no");
        meter_no.setBounds(60,70,100,30);
        panel1.add(meter_no);
        
        name= new JLabel("Name");
        name.setBounds(60,120,100,30);
        panel1.add(name);
        
        address= new JLabel("Address");
        address.setBounds(60,170,100,30);
        panel1.add(address);
        
        unit_consumed= new JLabel("Unit Consumed");
        unit_consumed.setBounds(60,220,100,30);
        panel1.add(unit_consumed);
        
        month= new JLabel("Month");
        month.setBounds(60,270,100,30);
        panel1.add(month);
        
        
        meter_c1= new Choice();
        meter_c1.setBounds(200, 70, 180, 20);
        try{
           
            Conn c= new Conn();
            ResultSet rs= c.stmnt.executeQuery("select * from customer");
            while(rs.next()){
                
                meter_c1.add(rs.getString("meter"));
            }
        }
        catch(Exception e){}

        JLabel name_field= new JLabel();
        name_field.setBounds(200, 120, 180, 20);
        panel1.add(name_field);
        
        JLabel address_field= new JLabel();
        address_field.setBounds(200, 170, 180, 20);
        panel1.add(address_field);
        
        try{
            
            Conn c= new Conn();
            ResultSet rs= c.stmnt.executeQuery("select * from customer where meter='"+meter_c1.getSelectedItem()+"'");
            while(rs.next()){
                name_field.setText(rs.getString("name"));
                address_field.setText(rs.getString("address"));
            }
            
        }catch(Exception e){}
            
         meter_c1.addItemListener(new ItemListener(){
             
             public void itemStateChanged(ItemEvent ae){
                 try{
                     
                     Conn c= new Conn();
                     ResultSet rs= c.stmnt.executeQuery("select * from customer where meter='"+meter_c1.getSelectedItem()+"'");
                     while(rs.next()){
                         name_field.setText(rs.getString("name"));
                         address_field.setText(rs.getString("address"));
                     }
                     
                 }catch(Exception e){}
             }
         });
         
        txt1 = new JTextField();
        txt1.setBounds(200, 220, 180, 20);
        panel1.add(txt1);
        
        
        month_c2 = new Choice();
        month_c2.setBounds(200, 270, 180, 20);
        month_c2.add("January");
        month_c2.add("February");
        month_c2.add("March");
        month_c2.add("April");
        month_c2.add("May");
        month_c2.add("June");
        month_c2.add("July");
        month_c2.add("August");
        month_c2.add("September");
        month_c2.add("October");
        month_c2.add("November");
        month_c2.add("December");
        
        panel1.add(meter_c1);
        panel1.add(month_c2);
        
        
        submit = new JButton("Submit");
        submit.setBounds(100, 350, 100, 25);
        cancel = new JButton("Cancel");
        cancel.setBounds(230, 350, 100, 25);
        
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);

        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        
        panel1.add(submit);
        panel1.add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/calculate_bill.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img_area = new JLabel(i3);
        panel1.add(img_area);
        
       
        setLayout(new BorderLayout(30,30));
        
        add(panel1,"Center");
        add(img_area,"West");
        
        
        submit.addActionListener(this);
        cancel.addActionListener(this);
        
        setSize(760,500);
        setLocation(400,120);
        getContentPane().setBackground(Color.WHITE);  
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == submit){
            String meter_no = meter_c1.getSelectedItem();
            String units = txt1.getText();
            String month = month_c2.getSelectedItem();

            int units_consumed = Integer.parseInt(units);

            int total_bill = 0;
            try{
                Conn c = new Conn();
                ResultSet rs = c.stmnt.executeQuery("select * from tax");
                while(rs.next()){
                    total_bill = units_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    total_bill += Integer.parseInt(rs.getString("meter_rent"));
                    total_bill += Integer.parseInt(rs.getString("service_charge"));
                    total_bill += Integer.parseInt(rs.getString("service_tax"));
                    total_bill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    total_bill += Integer.parseInt(rs.getString("fixed_tax"));
                }
            }catch(Exception e){}

            String q = "insert into bill values('"+meter_no+"','"+month+"','"+units+"','"+total_bill+"', 'Not Paid')";

            try{
                Conn c1 = new Conn();
                c1.stmnt.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
                this.setVisible(false);
            }catch(Exception aee){
                aee.printStackTrace();
            }

        }else if(ae.getSource()== cancel){
            this.setVisible(false);
        }      
    }
    public static void main(String[] args){
        new CalculateBill().setVisible(true);
    }
    
}
