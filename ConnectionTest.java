import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT","root","root");
		Statement stmt =conn.createStatement();
		ResultSet rs =stmt.executeQuery("select* from marksheet");
		while (rs.next()) 
		{
		System.out.print(rs.getString(1));
		System.out.print(rs.getString(1));
		System.out.print(rs.getString(1));		
		}
		stmt.close();
		conn.close();
	}
	
	
}
