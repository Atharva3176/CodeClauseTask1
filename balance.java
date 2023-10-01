package Bank.Management.System;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;
public class balance extends JFrame implements ActionListener
{
	String pinnumber;
	JButton back;
	public balance(String pinnumber) 
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 900);
        add(l3);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        l3.add(back);
        
        Conn c=new Conn();
        int balance=0;
		try {
			ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")){
					balance=balance+Integer.parseInt(rs.getString("amount"));
				}
				
				else {
					balance=balance-Integer.parseInt(rs.getString("amount"));
				}
			  }
		   }
			
			catch(Exception e)
			{
				System.out.println(e);
			}
        JLabel text=new JLabel("Your Current Account balance is Rs"+balance);
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        l3.add(text);

		setSize(900, 900);
        //setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new transactions(pinnumber).setVisible(true);
	}

	public static void main(String[] args) 
	{
		new balance("");
	}

}
