package Bank.Management.System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import com.mysql.cj.protocol.Resultset;

public class Login extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton login,SIGNUP,clear;
	JTextField cardtext,pintext;
	JPasswordField password;
	Login()
	{
		setTitle("ATM MACHINE");
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label=new JLabel (i3);
		label.setBounds(70,10,100,100);
		add(label);
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("osward",Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		JLabel cardno = new JLabel("Card No :");
		cardno.setFont(new Font("Railway",Font.BOLD,28));
		cardno.setBounds(120,150,150,30);
		add(cardno);
		cardtext=new JTextField();
		cardtext.setBounds(300,150,230,30);
		cardtext.setFont(new Font("Arial",Font.BOLD,14));
		add(cardtext);
		
		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("Railway",Font.BOLD,28));
		pin.setBounds(120,220,250,30);
		add(pin);
		pintext=new JPasswordField();
		pintext.setBounds(300,220,230,30);
		pintext.setFont(new Font("Arial",Font.BOLD,14));
		add(pintext);
		
		login=new JButton("SIGN IN");
		login.setBounds(300,300,100,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		clear=new JButton("CLEAR");
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		SIGNUP=new JButton("SIGN UP");
		SIGNUP.setBounds(300,350,230,30);
		SIGNUP.setBackground(Color.black);
		SIGNUP.setForeground(Color.white);
		SIGNUP.addActionListener(this);
		add(SIGNUP);
		
		getContentPane().setBackground(Color.white);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear)
		{
			cardtext.setText("");
			pintext.setText("");
		}
		
		else if(ae.getSource()==login)
		{
			Conn conn=new Conn();
			String cardnumber=cardtext.getText();
			String pinnumber=pintext.getText();
			String query ="select * from login1 where cardnum='"+cardnumber+"' and pin='"+pinnumber+"'";
			try {
				ResultSet rs=conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new transactions(pinnumber).setVisible(true);
				}
				
				else {
					JOptionPane.showMessageDialog(null,"Incorrect Card Number");
				}
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		else if(ae.getSource()==SIGNUP)
		{
			setVisible(false);
			new SignUpOne().setVisible(true);
		}
	}
	public static void main(String args[])
	{
		new Login();
	}
}
