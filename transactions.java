package Bank.Management.System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class transactions extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	JButton deposit,withdrawl,fast,Ministatement,pinchange,exit,enquiry;
	private static final long serialVersionUID = 1L;
	String pinnumber;
	public transactions(String pinnumber) 
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900,900);
        add(l2);
        
        JLabel text= new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        l2.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        l2.add(deposit);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        l2.add(withdrawl);
        
        fast=new JButton("Fast Cash");
        fast.setBounds(170,450,150,30);
        fast.addActionListener(this);
        l2.add(fast);
        
        Ministatement=new JButton("Mini Statement");
        Ministatement.setBounds(355,450,150,30);
        Ministatement.addActionListener(this);
        l2.add(Ministatement);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        l2.add(pinchange);
        
        enquiry=new JButton("Balance Enquiry");
        enquiry.setBounds(355,485,150,30);
        enquiry.addActionListener(this);
        l2.add(enquiry);
        
        exit=new JButton("exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        l2.add(exit);
        
        
		setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
		}
		
		else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}
		
		else if(ae.getSource()==withdrawl) {
			setVisible(false);
			new withdrawl(pinnumber).setVisible(true);
		}
		
		else if(ae.getSource()==fast) {
			setVisible(false);
			new fast(pinnumber).setVisible(true);
		}
		
		else if(ae.getSource()== pinchange) {
			setVisible(false);
			new pinchange(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==enquiry) {
			setVisible(false);
			new balance(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==Ministatement) {
			setVisible(false);
			new ministatement(pinnumber).setVisible(true);
		}
	}
	
	
	public static void main(String[] args){
        new transactions("");
    }
}

