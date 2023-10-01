package Bank.Management.System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
public class fast extends JFrame implements ActionListener
{

	/**
	 * 
	 */
	JButton deposit,withdrawl,fast,ministatement,pinchange,exit,enquiry;
	private static final long serialVersionUID = 1L;
	String pinnumber;
	public fast(String pinnumber) 
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900,900);
        add(l2);
        
        JLabel text= new JLabel("Select withdrawl amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        l2.add(text);
        
        deposit=new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        l2.add(deposit);
        
        withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        l2.add(withdrawl);
        
        fast=new JButton("Rs 1000");
        fast.setBounds(170,450,150,30);
        fast.addActionListener(this);
        l2.add(fast);
        
        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        l2.add(ministatement);
        
        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        l2.add(pinchange);
        
        enquiry=new JButton("Rs 10000");
        enquiry.setBounds(355,485,150,30);
        enquiry.addActionListener(this);
        l2.add(enquiry);
        
        exit=new JButton("Back");
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
			setVisible(false);
			new transactions(pinnumber).setVisible(true);
		}
		
		else{
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn c=new Conn();
			try {
				ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")){
						balance=balance+Integer.parseInt(rs.getString("amount"));
					}
					
					else {
						balance=balance-Integer.parseInt(rs.getString("amount"));
					}
				}
					
					if(ae.getSource()!=exit && balance<Integer.parseInt(amount)) {
						JOptionPane.showMessageDialog(null,"Insuffcient Balance");
						return;
					}
					
					Date date=new Date();
					String query="insert into bank values('"+pinnumber+"','"+date+"','withdrwal','"+amount+"')";
					c.s.executeUpdate(query);
            		JOptionPane.showMessageDialog(null,"Rs."+amount+" Debited Successfully");
            		setVisible(false);
            		new transactions(pinnumber).setVisible(true);
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
	public static void main(String[] args){
        new fast("");
    }
}


