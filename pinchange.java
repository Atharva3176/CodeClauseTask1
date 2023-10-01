package Bank.Management.System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class pinchange extends JFrame implements ActionListener{
	String pinnumber;
	JPasswordField pin,repin;
	JButton change,back;
	public pinchange(String pinnumber)
	{
		this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 900, 900);
        add(l4); 
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(250,280,500,20);
        l4.add(text);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330,320,180,25);
        l4.add(pin);

        
        JLabel pintext=new JLabel("New Pin :");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165,320,180,20);
        l4.add(pintext);
        
        JLabel retext=new JLabel("re-enter New Pin :");
        retext.setFont(new Font("System", Font.BOLD, 16));
        retext.setForeground(Color.WHITE);
        retext.setBounds(165,360,180,25);
        l4.add(retext);
        
        repin=new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330,360,180,25);
        l4.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,455,150,30);
        change.addActionListener(this);
        l4.add(change);
        
        back = new JButton("Back");
        back.setBounds(355,490,150,30);
        back.addActionListener(this);
        l4.add(back);

        
		setSize(900,900);
	     setLocation(300,0);
	     //setUndecorated(true);
	     setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
		try {
			String npin=pin.getText();
			String renterpin=repin.getText();
			
			if(!npin.equals(renterpin)) {
				JOptionPane.showMessageDialog(null,"Pin Does not match");
				return;
			}
			
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null,"Pin enter new Pin");
				return;
			}
			
			if(renterpin.equals("")) {
				JOptionPane.showMessageDialog(null,"Pin re-enter new Pin");
				return;
			}
			
			Conn conn=new Conn();
			String query1="update bank set pin='"+renterpin+"' where pin='"+pinnumber+"'";
			String query2="update login1 set pin='"+renterpin+"' where pin='"+pinnumber+"'";
			conn.s.executeUpdate(query1);
			conn.s.executeUpdate(query2);
			JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
			setVisible(false);
			new transactions(renterpin).setVisible(true);
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	  }
	  else {
			setVisible(false);
			new transactions(pinnumber).setVisible(true);
		}
	}
	
	

	public static void main(String[] args) 
	{
		new pinchange("").setVisible(true);;
	}

}
