package testDBDAO;
import testDBbeans.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class afterRegDAO 
{
	static String DB_URL="jdbc:mysql://examdb.cqz6xsqboad9.us-east-2.rds.amazonaws.com/examschema";
	static String DB_USER="TD";
	static String DB_PWD="priya2000";
	
	public boolean insertNameIntoDB(String name,String roll)
	{
		//student[] stuarr = null;
		student[] stuarr1=new student[1];
		stuarr1[0]=new student();
		stuarr1[0].setID(Integer.parseInt(roll));
		stuarr1[0].setName(name);
		//int i=0;
		int count;
		boolean s=false;
		String sqlQuery="insert into testTable(rollnum ,stuname) values ("+ roll +",\""+ name+ "\");";
		//String sqlQuery="insert into testTable(rollnum ,stuname) values (3,\"ratul\");";
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			PreparedStatement pstmt = con.prepareStatement(sqlQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//ResultSet rs=pstmt.executeQuery();
			count = pstmt.executeUpdate();
			s = (count > 0);
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
		return s;
	}
}
