package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener{
    String meter;
    Project(String meter, String person){
        super("Electricity Billing System");
        this.meter = meter;
        
        setSize(1366,768);
        
        /* Adding background image */
        ImageIcon bckimg =  new ImageIcon(ClassLoader.getSystemResource("icon/bckimg.jpg"));
        Image i3 = bckimg.getImage().getScaledInstance(1366, 700,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);
       
        /* First Column */
        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("Master");        
        master.setFont(new Font("Tahoma",Font.BOLD,14));
        JMenuItem new_customer = new JMenuItem("New Customer");
        JMenuItem cust_details = new JMenuItem("Customer Details");
        JMenuItem deposit_details = new JMenuItem("Deposit Details");
        JMenuItem calculate_bill = new JMenuItem("Calculate Bill");
        master.setForeground(Color.BLUE);
        
        
        /* ---- New Customer ---- */
        new_customer.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        new_customer.setIcon(new ImageIcon(image1));
        new_customer.setMnemonic('N');
        new_customer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        new_customer.setBackground(Color.WHITE);
        
        /* ---- Customer Details ---- */
        cust_details.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        cust_details.setIcon(new ImageIcon(image2));
        cust_details.setMnemonic('M');
        cust_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        cust_details.setBackground(Color.WHITE);
        
         /* ---- Deposit Details  ----- */
        deposit_details.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        deposit_details.setIcon(new ImageIcon(image3));
        deposit_details.setMnemonic('D');
        deposit_details.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        deposit_details.setBackground(Color.WHITE);
        
        /*Calculate Bill*/
        calculate_bill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image5 = icon5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        calculate_bill.setIcon(new ImageIcon(image5));
        calculate_bill.setMnemonic('B');
        calculate_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        calculate_bill.setBackground(Color.WHITE);
        
        
        new_customer.addActionListener(this);
        cust_details.addActionListener(this);
        deposit_details.addActionListener(this);
        calculate_bill.addActionListener(this);
        
        //-----------------------------------------------------------------------------------
        
        
        /* Second Column */
        JMenu info = new JMenu("Information");
        info.setFont(new Font("Tahoma",Font.BOLD,14));
        JMenuItem update_info = new JMenuItem("Update Information");
        JMenuItem view_info = new JMenuItem("View Information");       
        info.setForeground(Color.RED);
        
        /* ---- Update Information ---- */
        update_info.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon41 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image41 = icon41.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        update_info.setIcon(new ImageIcon(image41));
        update_info.setMnemonic('U');
        update_info.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        update_info.setBackground(Color.WHITE);
        
        /* ---- View Information ----*/
        view_info.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon42 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image42 = icon42.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        view_info.setIcon(new ImageIcon(image42));
        view_info.setMnemonic('V');
        view_info.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        view_info.setBackground(Color.WHITE);
        
        update_info.addActionListener(this);
        view_info.addActionListener(this);       
        
        // --------------------------------------------------------------------------------------------
        
        
        /* Third Column */
        JMenu user = new JMenu("User");
        user.setFont(new Font("Tahoma",Font.BOLD,14));
        JMenuItem pay_bill = new JMenuItem("Pay Bill");        
        JMenuItem last_bill = new JMenuItem("Bill Details");
        user.setForeground(Color.RED);
        
        /* ---- Pay Bill ---- */
        pay_bill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image4 = icon4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        pay_bill.setIcon(new ImageIcon(image4));
        pay_bill.setMnemonic('P');
        pay_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        pay_bill.setBackground(Color.WHITE);
        
        /* ---- Last Bill ----*/
        last_bill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6 = icon6.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        last_bill.setIcon(new ImageIcon(image6));
        last_bill.setMnemonic('L');
        last_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        last_bill.setBackground(Color.WHITE);
        
        pay_bill.addActionListener(this);
        last_bill.addActionListener(this);
        
        
        // --------------------------------------------------------------------------------------------- 
        
        /* Fourth Column*/
        JMenu report = new JMenu("Report");
        report.setFont(new Font("Tahoma",Font.BOLD,14));
        JMenuItem generate_bill = new JMenuItem("Generate Bill");
        report.setForeground(Color.BLUE);
        
        /* ---- Report ---- */
        generate_bill.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7 = icon7.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        generate_bill.setIcon(new ImageIcon(image7));
        generate_bill.setMnemonic('R');
        generate_bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        generate_bill.setBackground(Color.WHITE);
        
        generate_bill.addActionListener(this);
        
        // -----------------------------------------------------------------------------------------------
        
        /* Fifth Column*/
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Tahoma",Font.BOLD,14));
        JMenuItem notepad = new JMenuItem("Notepad");
        JMenuItem calculator = new JMenuItem("Calculator");
        JMenuItem web_browser = new JMenuItem("Web Browser");
        utility.setForeground(Color.RED); 
        
        /* ---- Notepad ---- */
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image8 = icon8.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image8));
        notepad.setMnemonic('E');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        notepad.setBackground(Color.WHITE);
        
        /* ---- Calculator ---- */
        calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9 = icon9.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image9));
        calculator.setMnemonic('X');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        calculator.setBackground(Color.WHITE);
        
        /* ---- Web Browser ---- */
        web_browser.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
        Image image10 = icon10.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        web_browser.setIcon(new ImageIcon(image10));
        web_browser.setMnemonic('W');
        web_browser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        web_browser.setBackground(Color.WHITE);
        
        
        notepad.addActionListener(this);
        calculator.addActionListener(this);
        web_browser.addActionListener(this);
        
        // ---------------------------------------------------------------------------------------
        
        /*Sixth Column */
        JMenu exit = new JMenu("Logout");
        exit.setFont(new Font("Tahoma",Font.BOLD,14));
        JMenuItem logout = new JMenuItem("Logout");
        exit.setForeground(Color.BLUE);
        
        /* ---- Exit ---- */
        logout.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image11 = icon11.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        logout.setIcon(new ImageIcon(image11));
        logout.setMnemonic('Z');
        logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        logout.setBackground(Color.WHITE);
        
        logout.addActionListener(this);
        
        
        // ---------------------------------------------------------------------------------------------
               
        
        master.add(new_customer);
        master.add(cust_details);
        master.add(deposit_details);
        master.add(calculate_bill);
        
        info.add(update_info);
        info.add(view_info);
        
        user.add(pay_bill);
        user.add(last_bill);
        
        report.add(generate_bill);
        
        utility.add(notepad);
        utility.add(calculator);
        utility.add(web_browser);
        
        exit.add(logout);
         
        if(person.equals("Admin")){
            mb.add(master);
        }else{             
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(exit);
        
        setJMenuBar(mb);    
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
    public void actionPerformed(ActionEvent ae){
        
        String msg = ae.getActionCommand();
        
        if(msg.equals("Customer Details")){
            new CustomerDetails().setVisible(true);
            
        }
        else if(msg.equals("New Customer")){
            new NewCustomer().setVisible(true);
            
        }
        else if(msg.equals("Calculate Bill")){
            new CalculateBill().setVisible(true);
            
        }
        else if(msg.equals("Pay Bill")){
            new PayBill(meter).setVisible(true);}
           
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Web Browser")){
            try{
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            }catch(Exception e){ }
        }
        else if(msg.equals("Logout")){
            this.setVisible(false);
            new Login().setVisible(true);
        }
        else if(msg.equals("Generate Bill")){
            new GenerateBill(meter).setVisible(true);}
            
        else if(msg.equals("Deposit Details")){
            new DepositDetails().setVisible(true);
        }
        else if(msg.equals("View Information")){
            new ViewInformation(meter).setVisible(true);
        }
        else if(msg.equals("Update Information")){
            new UpdateInformation(meter).setVisible(true);
        }
        else if(msg.equals("Bill Details")){
            new BillDetails(meter).setVisible(true);
        }        
        
    }    
    
    public static void main(String[] args){
        new Project("", "").setVisible(true);
    }
    
}