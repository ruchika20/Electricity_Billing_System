package Electricity;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
    JPanel panel1;
    JLabel usrnm,user_name,psswd,acc_as,meter_no,image;
    JTextField txt1,txt2,txt3,txt4;
    JButton create_bttn,back_bttn;
    Choice c1;
    
    Signup(){
        setBounds(420,180,700,440);
        
        panel1= new JPanel();
        panel1.setBounds(30, 30, 650, 300);
        panel1.setLayout(null);
        panel1.setBackground(Color.WHITE);
        panel1.setForeground(new Color(34, 139, 34));
        panel1.setBorder(new TitledBorder(new LineBorder(new Color(6, 194, 169),2),"Create-Account", TitledBorder.LEADING, TitledBorder.TOP,null,new Color(6, 194, 169)));     
        add(panel1);
        
        usrnm= new JLabel("Username");
        usrnm.setForeground(Color.BLACK);
        usrnm.setFont(new Font("Tahoma",Font.BOLD,14));
        usrnm.setBounds(100,50,100,20);
        panel1.add(usrnm);
        
        txt1= new JTextField();
        txt1.setBounds(260,50,150,20);
        panel1.add(txt1);
        
        user_name= new JLabel("Name");
        user_name.setForeground(Color.BLACK);
        user_name.setFont(new Font("Tahoma",Font.BOLD,14));
        user_name.setBounds(100,90,100,20);
        panel1.add(user_name);
        
        txt2= new JTextField();
        txt2.setBounds(260,90,150,20);
        panel1.add(txt2);
        
        psswd= new JLabel("Password");
        psswd.setForeground(Color.BLACK);
        psswd.setFont(new Font("Tahoma",Font.BOLD,14));
        psswd.setBounds(100,130,100,20);
        panel1.add(psswd);
        
        txt3= new JTextField();
        txt3.setBounds(260,130,150,20);        
        panel1.add(txt3);
        
        acc_as= new JLabel("Create Account as");
        acc_as.setForeground(Color.BLACK);
        acc_as.setFont(new Font("Tahoma",Font.BOLD,14));
        acc_as.setBounds(100,170,140,20);
        panel1.add(acc_as);
        
        c1= new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(260,170,150,20);
        panel1.add(c1);
        
        c1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                String user= c1.getSelectedItem();
                if(user.equals("Customer")){
                    meter_no.setVisible(true);
                    txt4.setVisible(true);
                }
                else{
                    meter_no.setVisible(false);
                    txt4.setVisible(false);
                }
            }
        
        });
        
        meter_no= new JLabel("Meter_no");
        meter_no.setForeground(Color.BLACK);
        meter_no.setFont(new Font("Tahoma",Font.BOLD,14));
        meter_no.setBounds(100,210,100,20);
        meter_no.setVisible(false);
        panel1.add(meter_no);
        
        txt4= new JTextField();
        txt4.setBounds(260,210,150,20);
        txt4.setVisible(false);
        panel1.add(txt4);
        
        create_bttn= new JButton("Create");
        create_bttn.setBackground(Color.DARK_GRAY);
        create_bttn.setForeground(Color.WHITE);
        create_bttn.setBounds(130,290,120,30);
        create_bttn.addActionListener(this);
        panel1.add(create_bttn);
        
        back_bttn= new JButton("Back");
        back_bttn.setBackground(Color.DARK_GRAY);
        back_bttn.setForeground(Color.WHITE);
        back_bttn.setBounds(300,290,120,30);
        back_bttn.addActionListener(this);
        panel1.add(back_bttn);
        
        ImageIcon signupImge= new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image signupImge1= signupImge.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon signupImge2= new ImageIcon(signupImge1);
        image= new JLabel(signupImge2);
        image.setBounds(450,30,250,250);
        panel1.add(image);        
        
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==create_bttn){
                String username=txt1.getText();
                String name= txt2.getText();
                String password= txt3.getText();
                String user= c1.getSelectedItem();
                String meter= txt4.getText();
                
                try{
                    
                    Conn c= new Conn();
                    String str=null;
                    if(user.equals("Admin")){
                        str="insert into login values('"+meter+"','"+username+"','"+name+"','"+password+"','"+user+"')";                        
                    }
                    else{
                        str = "update login set username='"+username+"', name='"+name+"', password='"+password+"', user='"+user+"' where meter_no='"+txt4.getText()+"'";
                    }
                    
                    c.stmnt.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Account Created Successfully");
                    this.setVisible(false);
                    new Login().setVisible(true);
                    
                }
                catch(Exception e){}
                
            }
            else if(ae.getSource()==back_bttn){
                this.setVisible(false);                
                new Login().setVisible(true);
            }
        
    }
    
    public static void main(String[] args){
        new Signup().setVisible(true);
        
    }
    
}
