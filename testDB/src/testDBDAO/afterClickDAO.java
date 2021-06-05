package testDBDAO;
import testDBbeans.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class afterClickDAO 
{
	static String DB_URL="jdbc:mysql://examdb.cqz6xsqboad9.us-east-2.rds.amazonaws.com/examschema";
	static String DB_USER="TD";
	static String DB_PWD="priya2000";
	
	public student[] getNameFromDB(String rollnum)
	{
		student[] stuarr = null;
		int i=0;
		String sqlQuery="select * from testTable";
		
		try
		{  
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			PreparedStatement pstmt = con.prepareStatement(sqlQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=pstmt.executeQuery();
			int rowCount = 0;
		      while (rs.next())
		      {
		           rowCount++; 
		      }
			stuarr=new student[rowCount];
			rs.beforeFirst();
			while(rs.next())  
			{
				stuarr[i]=new student();
				stuarr[i].setID(rs.getInt("rollnum"));
				stuarr[i].setName(rs.getString("stuname"));
				i++;
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
		return stuarr;
	}
}
