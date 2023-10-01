package Bank.Management.System;
import java.awt.Color;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUpOne extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long random;
	JTextField nametext,fnametext,emailtext,addresstext,citytext,statetext,pintext;
	JButton next;
	JRadioButton Male,Female,other,married,unmarried;
	JDateChooser dateChosser;
	SignUpOne(){
		setLayout(null);
		Random ran=new Random();
		random=Math.abs((ran.nextLong()%9000L)+1000L);
		JLabel formno=new JLabel("Application Form No. "+random);
		formno.setFont(new Font("Railway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		JLabel details=new JLabel("Page 1 : Personal Details");
		details.setFont(new Font("Railway",Font.BOLD,22));
		details.setBounds(290,80,400,30);
		add(details);
		
		JLabel name=new JLabel("Name :");
		name.setFont(new Font("Railway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		nametext=new JTextField();
		nametext.setFont(new Font("Railway",Font.BOLD,14));
		nametext.setBounds(300,140,400,30);
		add(nametext);
		
		JLabel fname=new JLabel("Father's Name :");
		fname.setFont(new Font("Railway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnametext=new JTextField();
		fnametext.setFont(new Font("Railway",Font.BOLD,14));
		fnametext.setBounds(300,190,400,30);
		add(fnametext);
		
		JLabel DOB=new JLabel("Date Of Birth :");
		DOB.setFont(new Font("Railway",Font.BOLD,20));
		DOB.setBounds(100,240,200,30);
		add(DOB);
		
		dateChosser=new JDateChooser();
		dateChosser.setBounds(300,240,400,30);
		dateChosser.setForeground(new Color(105,105,105));
		add(dateChosser);
		
		JLabel gender=new JLabel("Gender :");
		gender.setFont(new Font("Railway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		Male=new JRadioButton("Male");
		Male.setBounds(300,290,60,30);
		Male.setBackground(Color.white);
		add(Male);
		
		Female=new JRadioButton("Female");
		Female.setBounds(450,290,120,30);
		Female.setBackground(Color.white);
		add(Female);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(Male);
		gendergroup.add(Female);

		JLabel email=new JLabel("Email Address :");
		email.setFont(new Font("Railway",Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		emailtext=new JTextField();
		emailtext.setFont(new Font("Railway",Font.BOLD,14));
		emailtext.setBounds(300,340,400,30);
		add(emailtext);
		
		JLabel status=new JLabel("Marital Status :");
		status.setFont(new Font("Railway",Font.BOLD,20));
		status.setBounds(100,390,200,30);
		add(status);
		
		married=new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,100,30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		other=new JRadioButton("Other");
		other.setBounds(630,390,100,30);
		other.setBackground(Color.white);
		add(other);
		
		
		ButtonGroup statusgroup=new ButtonGroup();
		statusgroup.add(married);
		statusgroup.add(unmarried);
		statusgroup.add(other);
		
		JLabel Address=new JLabel("Address :");
		Address.setFont(new Font("Railway",Font.BOLD,20));
		Address.setBounds(100,440,200,30);
		add(Address);
		
		addresstext=new JTextField();
		addresstext.setFont(new Font("Railway",Font.BOLD,14));
		addresstext.setBounds(300,440,400,30);
		add(addresstext);
		
		JLabel city=new JLabel("City :");
		city.setFont(new Font("Railway",Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		citytext=new JTextField();
		citytext.setFont(new Font("Railway",Font.BOLD,14));
		citytext.setBounds(300,490,400,30);
		add(citytext);
		
		JLabel State=new JLabel("State :");
		State.setFont(new Font("Railway",Font.BOLD,20));
		State.setBounds(100,540,200,30);
		add(State);
		
		statetext=new JTextField();
		statetext.setFont(new Font("Railway",Font.BOLD,14));
		statetext.setBounds(300,540,400,30);
		add(statetext);
		
		JLabel pinCode=new JLabel("Pin Code :");
		pinCode.setFont(new Font("Railway",Font.BOLD,20));
		pinCode.setBounds(100,590,200,30);
		add(pinCode);
		
		pintext=new JTextField();
		pintext.setFont(new Font("Railway",Font.BOLD,14));
		pintext.setBounds(300,590,400,30);
		add(pintext);
		
		next=new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Railway",Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formno=" "+ random;
		String name= nametext.getText();
		String fname= fnametext.getText();
		String DOB=((JTextField) dateChosser.getDateEditor().getUiComponent()).getText();
		String gender= null;
		if(Male.isSelected()) {
			gender="Male";
		}
		
		else if(Female.isSelected()) {
			gender="Female";
		}
		
		String email=emailtext.getText();
		String status=null;
		if(married.isSelected()) {
			status="married";
		}
		
		else if(unmarried.isSelected()) {
			status="unmarried";
		}
		
		else if(other.isSelected()) {
			status="other";
		}
		
		String address= addresstext.getText();
		String city= citytext.getText();
		String state = statetext.getText();
		String pin = pintext.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is Required");
			}
			
			else {
				Conn c=new Conn();
				String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+DOB+"','"+gender+"','"+email+"','"+status+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
				c.s.executeUpdate(query);
			}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		new SignUpOne();
	}
}
