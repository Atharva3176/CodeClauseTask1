package Bank.Management.System;
import java.sql.*;
public class Conn 
{
	Connection c;
	Statement s;
	public Conn() 
	{
		try
		{
			c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Atharva21161");
			s=c.createStatement();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
