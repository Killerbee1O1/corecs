package corecs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDB 
{

	public static Connection getConnection()
	{
		if(conn==null)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(url,user,pwd);
			}
			catch(ClassNotFoundException ex)
			{
				System.out.println("CLASS NOT FOUND!!!!");
				ex.printStackTrace();
			}
			catch(SQLException ex)
			{
				System.out.println("SQL EXCEPTION!!!");
				ex.printStackTrace();
			}
		}
		return conn;
	}
	
	private static String url ="jdbc:mysql://localhost:3306/corecs";
	private static String user="corecsuser";
	private static String pwd="corecsuser";
	private static Connection conn=null;
}
