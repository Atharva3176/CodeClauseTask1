package Bank.Management.System;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
public class ministatement extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pinnumber;
	public ministatement(String pinnumber) 
	{
		this.pinnumber=pinnumber;
		setTitle("Mini Statement");
		setLayout(null);
		
		JLabel mini=new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank=new JLabel("SBI BANK");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card =new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance =new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		
		
		try {
			Conn conn=new Conn();
			ResultSet rs=conn.s.executeQuery("select * from login1 where pin ='"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number : "+rs.getString("cardnum").substring(0,4)+"XXXXXXXX"+rs.getString("cardnum").substring(12));
			}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn=new Conn();
			int bal=0;
			ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+"<html>"+rs.getString("tarik")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br></html>");
				if(rs.getString("type").equals("Deposit")){
					bal=bal+Integer.parseInt(rs.getString("amount"));
				}
				
				else {
					bal=bal-Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your Current Account Balance is"+bal);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new ministatement("");
	}

}
