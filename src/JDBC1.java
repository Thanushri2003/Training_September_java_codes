package jdbc_connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {
	public static void main(String[] args)throws ClassNotFoundException,SQLException
	{
		String url="jdbc:mysql://localhost:3306/java";
		String user="root";
		String pass="root@39";
		
		Class.forName("com.mysql.jdbc.Driver");//load the driver class
		Connection con=DriverManager.getConnection(url,user,pass);
		Statement stmt=con.createStatement();
		
		String sql="create table Thanu(id int,stdame varchar);";
		stmt.execute(sql);
		
		con.close();
		System.out.println("done");
		
	}
}
