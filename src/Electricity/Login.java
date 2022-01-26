package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{    
    JLabel l1,l2,l3,l4;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1,b2,b3;    
    Choice c1;
    
    Login(){
       
        super("Login Page");        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        l1= new JLabel("Username");
        l1.setBounds(300,20,100,20);
        add(l1);
        
        l2= new JLabel("Password");
        l2.setBounds(300,60,100,20);
        add(l2);
        
        tf1= new JTextField(20);
        tf1.setBounds(400, 20, 150, 20);
        add(tf1);
        
        pf1= new JPasswordField(20);
        pf1.setBounds(400, 60, 150, 20);
        add(pf1);
        
        l3= new JLabel("Logging in as");
        l3.setBounds(300, 100, 100, 20);
        add(l3);
        
        c1= new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(400, 100, 150, 20);
        add(c1);
        
        ImageIcon ic1= new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1= ic1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        b1= new JButton("Login", new ImageIcon(i1));
        b1.setBounds(330, 160, 100, 20);
        add(b1);
        
        ImageIcon ic2= new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2= ic2.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        b2= new JButton("Cancel", new ImageIcon(i2));
        b2.setBounds(450, 160, 100, 20);
        add(b2);
        
        ImageIcon ic3= new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i3 =ic3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        b3= new JButton("Signing as", new ImageIcon(i3));
        b3.setBounds(380, 200, 130, 20);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        ImageIcon ic4= new ImageIcon(ClassLoader.getSystemResource("icon/user1.jpg"));
        Image i4= ic4.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon icc4= new ImageIcon(i4);
        l4= new JLabel(icc4);
        l4.setBounds(0, 0, 250, 250);
        add(l4);
        
        setLayout(new BorderLayout());
        
        setSize(680,350);
        setLocation(480,200);
        setVisible(true); 
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() ==b1){
            try{
                Conn c= new Conn();
                String username= tf1.getText();
                String password= pf1.getText();
                String user= c1.getSelectedItem();
                String query= "select * from login where username='"+username+"' and password='"+password+"' and user='"+user+"'";
                ResultSet rs= c.stmnt.executeQuery(query);
                
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    new Project(meter,user).setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf1.setText("");
                }
            }
             
           catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
           }
        }
        
        
        else if(ae.getSource() == b2){
            this.setVisible(false);
        }
        else if(ae.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);  
        }
    }
    
    public static void main(String[] args){
        new Login().setVisible(true);
    }
    
    
}
