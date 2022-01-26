package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class NewCustomer extends JFrame implements ActionListener{
    
    JLabel name,meter_no,address,city,state,email,phone_no,l8, random_meter_no;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton next,cancel;
    
    NewCustomer(){
        
        setLocation(400,120);
        setSize(700,500);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.setBackground(new Color(173,216,230));
        
        JLabel title = new JLabel("New Customer");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);
        
        name = new JLabel("Customer Name");
        name.setBounds(100, 80, 100, 20);
        
        t1 = new JTextField();
        t1.setBounds(240, 80, 200, 20);
        p.add(name);
        p.add(t1);
        
        
        meter_no = new JLabel("Meter No");
        meter_no.setBounds(100, 120, 100, 20);
        
        random_meter_no = new JLabel();
        random_meter_no.setBounds(240, 120, 200, 20);
        p.add(meter_no);
        p.add(random_meter_no);
        
        
        address = new JLabel("Address");
        address.setBounds(100, 160, 100, 20);
        
        t3 = new JTextField();
        t3.setBounds(240, 160, 200, 20);
        p.add(address);
        p.add(t3);
        
        
        city = new JLabel("City");
        city.setBounds(100, 200, 100, 20);
        
        t5 = new JTextField();
        t5.setBounds(240, 200, 200, 20);
        p.add(city);        
        p.add(t5);
                
        
        state = new JLabel("State");
        state.setBounds(100, 240, 100, 20);
        
        t4 = new JTextField();
        t4.setBounds(240, 240, 200, 20);
        p.add(state);
        p.add(t4);
        
        
        email = new JLabel("Email");
        email.setBounds(100, 280, 100, 20);
        
        t6 = new JTextField();
        t6.setBounds(240, 280, 200, 20);
        p.add(email);
        p.add(t6);
        
        
        phone_no = new JLabel("Phone Number");
        phone_no.setBounds(100, 320, 100, 20);
        
        t7 = new JTextField();
        t7.setBounds(240, 320, 200, 20);
        p.add(phone_no);
        p.add(t7);
        
       
        
        next = new JButton("Next");
        next.setBounds(120, 390, 100, 25);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100, 25);
        
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        
        p.add(next);
        p.add(cancel);
        
        setLayout(new BorderLayout());        
        add(p,"Center");
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/new_customer.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);
        
        
        add(l8,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);
        
        next.addActionListener(this);
        cancel.addActionListener(this);
        
        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        random_meter_no.setText(""+Math.abs(first));
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            String name = t1.getText();
            String meter = random_meter_no.getText();
            String address = t3.getText();
            String state = t4.getText();
            String city = t5.getText();
            String email = t6.getText();
            String phone = t7.getText();

            String q1 = "insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
            String q2 = "insert into login values('"+meter+"', '', '', '', '')";
            try{
                Conn c = new Conn();
                c.stmnt.executeUpdate(q1);
                c.stmnt.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                this.setVisible(false);
                //new MeterInfo(meter).setVisible(true);

            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }else if(ae.getSource() ==cancel){
                this.setVisible(false);
                }
    }
    
    
    public static void main(String[] args){
        new NewCustomer().setVisible(true);
    }
}