package A84_SQL_To_DProvider;

/*connect to SQLserver DB using (SQL connection) [server name, Username, Password] after 
 * 1- add (sqljdbc4-4.0.jar) to build path.
 * 2- and enable TCP/IP SQL service with used port like 1434.
 * 3- Run SQL Server (MSSQLSERVER).
*/

//::Reference::
//	http://artoftesting.com/automationTesting/sqlServerAutomation.html
//	https://stackoverflow.com/questions/2451892/how-do-i-connect-to-a-sql-server-2008-database-using-jdbc


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class From_SQL_DB____Manually_Print {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

String userName = "sa";
String password = "0123456789";


		// JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//Creating a connection to the database.		//like(Connection conn = DriverManager.getConnection("DatabaseURL","UserName", "Password");
//		String url = "jdbc:sqlserver://DESKTOP-1TGL11O;databaseName=NORTHWND"; //"jdbc:sqlserver://[servername];databaseName=MYDB"; 
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-1TGL11O;databaseName=NORTHWND", userName, password);
		
		//Executing SQL queries-
		Statement stmt = null;
		stmt = conn.createStatement();

		// query
		String sql = "select * from CalcTable";
		ResultSet rs = stmt.executeQuery(sql);

		//Fetching data from result set-
		while (rs.next()) {

			String No1 = rs.getString("No1");
			String Operator = rs.getString("Operator");
			String No2 = rs.getString("No2");
			String Result= rs.getString ("Result");

			System.out.println(No1 + " " + Operator+ " " + No2+ " " + Result);
		}

		stmt.close();
		conn.close();
	}
}
