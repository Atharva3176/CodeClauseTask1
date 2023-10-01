package Bank.Management.System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Deposit  extends JFrame implements ActionListener{

	JButton deposit,back;
	JTextField amount;
	String pinnumber;
	public Deposit(String pinnumber) 
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,900,900);
        add(l3);
        
        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        l3.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170,350,320,25);
        l3.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        l3.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        l3.add(back);

        
		setSize(900,900);
        //setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit) {
        	String number=amount.getText();
        	Date date=new Date();
        	if(number.equals("")) {
        		JOptionPane.showMessageDialog(null,"Please enter the amount that you want to deposit");
        	}
        	
        	else {
        		try {
        			Conn conn=new Conn();
            		String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
            		conn.s.executeUpdate(query);
            		JOptionPane.showMessageDialog(null,"Rs."+number+" Deposited Successfully");
            		setVisible(false);
            		new transactions(pinnumber).setVisible(true);
        		}
        		
        		catch(Exception e)
        		{
        			System.out.println(e);
        		}
        	}
        }
        
        else if(ae.getSource()==back) {
        	setVisible(false);
        	new transactions(pinnumber).setVisible(true);
        }
            
    }

	public static void main(String[] args) 
	{
		new Deposit("");
	}

}