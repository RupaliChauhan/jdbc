import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test
{
public static void main(String[] args) throws Exception
{
    testSelect();
	//testUpdate();
  // testDelete();
   // testInsert();
}
   public static void testInsert() throws Exception
   {
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
			Statement stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("insert into marksheet value(11,111,'priya','shukla',78,66,66)");
			
			System.out.println(i + "Inserted");
			
			stmt.close();
			conn.close();
		}
	
    }
public static void testDelete() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("delete from marksheet where id =4");
		
		System.out.println(i + "Deleted");
		
		stmt.close();
		conn.close();
	}
	

public static void testUpdate() throws Exception
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
	Statement stmt = conn.createStatement();
	
	int i = stmt.executeUpdate("update marksheet set fname='Disha' where id =4");
	
	System.out.println(i + "updated");
	
	stmt.close();
	conn.close();
}


private static void testSelect() throws Exception
{
Class.forName("com.mysql.jdbc.Driver");

	// TODO Auto-generated method stub
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
	Statement stmt =conn.createStatement();
	ResultSet rs =stmt.executeQuery("select* from marksheet");
	while (rs.next()) 
	{
		//System.out.print(rs.getString(1));
		//System.out.print("\t" +rs.getString(2));	
		//System.out.print("\t" +rs.getString(3));
		//System.out.print("\t" +rs.getString(4));
		//System.out.print("\t" +rs.getString(5));
		//System.out.print("\t" +rs.getString(6));
		//System.out.print("\t" +rs.getString(7));
		//System.out.print("\t" +rs.getString(8));
		//System.out.println("\t" +rs.getString(9));
		System.out.println("\t" +rs.getString("FNAME"));	
	}
	stmt.close();
	conn.close();
	}
}