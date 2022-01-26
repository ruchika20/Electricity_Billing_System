package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{
    
    String meter;
    JButton back_bttn;
    Paytm(String meter){
        
        this.meter = meter;
        
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   
        
        back_bttn = new JButton("Back");
        back_bttn.setBackground(Color.BLACK);
        back_bttn.setForeground(Color.WHITE);
        back_bttn.setBounds(500, 20, 120, 25);
        back_bttn.addActionListener(this);
        j.add(back_bttn);

        try {
            j.setPage("https://paytm.com/electricity-bill-payment");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(j);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        setSize(800,800);
        setLocation(250,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new PayBill(meter).setVisible(true);
    }
    public static void main(String[] args){
        new Paytm("").setVisible(true);
    }
}