import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;



public class TestPreparedStatement {

	public static void main(String[] args) throws Exception
	{
		
		//testSelect();
		//testUpdate();
		//testDelete();
		//testInsert();
		testAdd();
	}

	
	private static void testSelect() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select* from marksheet");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			
			System.out.print("\t" +rs.getString("1"));
			System.out.print("\t" +rs.getString("2"));
			System.out.print("\t" +rs.getString("3"));
			System.out.print("\t" +rs.getString("4"));
			System.out.print("\t"+rs.getString("5"));
			System.out.print("\t" +rs.getString("5"));
			System.out.println("\t"+rs.getString("6"));
		
		}
		rs.close();
		conn.close();
		
	}
	

	private static void testDelete() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
		conn.setAutoCommit(false);
		try
		{
		int id=11;
		int rn=112;
		String fn="mahan";
		String ln="MISHRA";
		int phy=60;
		int chem=75;
		int m=34;
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id =?");
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Deleted");
		
		conn.commit();
		ps.close();
		}
	   catch(SQLException e)
		{
		   conn.rollback();
		}
		conn.close();
		
	}

	public static void testInsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
		 
		conn.setAutoCommit(false);
		try {
			
		int id=11;
		int rn=111;
		String fn="vijay";
		String ln="Mishra";
		int phy=60;
		int chem=75;
		int m=34;
		
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setInt(2, rn);
		ps.setString(3, fn);
		ps.setString(4, ln);
		ps.setInt(5, phy);
		ps.setInt(6, chem);
		ps.setInt(7, m);
		
		
		ps.executeUpdate();
		System.out.println("Inserted");
		
		conn.commit();
		ps.close();
		}
		catch(SQLException e)
		{
			conn.rollback();
		}
		
		conn.close();
		
	}
	public static void testUpdate() throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
		 
		conn.setAutoCommit(false);
		try {
		int rn=110;
		String fn="Sheema";
		String ln="Sharma";
		int phy=60;
		int chem=75;
		int m=34;
		int id=10;
		PreparedStatement ps = conn.prepareStatement("update marksheet set Roll_no=?,Fname=?,Lname=?,PHYSICS=?,CHEMISTRY=?,MATHS=? where id=?");
		ps.setInt(1, rn);
		ps.setString(2, fn);
		ps.setString(3, ln);
		ps.setInt(4, phy);
		ps.setInt(5, chem);
		ps.setInt(6, m);
		ps.setInt(7, id);
		int i =ps.executeUpdate();
		System.out.println(i+"updated");
		conn.commit();
		ps.close();
		}
		catch(SQLException e)
		{
			conn.rollback();
		}
		conn.close();
	}
	public static void testAdd() throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMOPROJECT", "root", "root");
		
		
		
		CallableStatement cs=conn.prepareCall("{CALL TestMark(?)}");
	    cs.registerOutParameter(1,Types.INTEGER);
	
	     cs.execute();
		System.out.println(cs.getInt(1));
	} 

	

}
