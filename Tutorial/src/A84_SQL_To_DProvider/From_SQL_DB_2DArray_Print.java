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
import java.util.ArrayList;
import java.util.List;

public class From_SQL_DB_2DArray_Print {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String userName = "sa";
		String password = "0123456789";
		String ServerName= "DESKTOP-1TGL11O";
		String DBName="NORTHWND";
		String TableName="CalcTable";

		// JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Creating a connection to the database. //like(Connection conn = DriverManager.getConnection("DatabaseURL","UserName", "Password");
		// String url ="jdbc:sqlserver://DESKTOP-1TGL11O;databaseName=NORTHWND"; //"jdbc:sqlserver://[servername];databaseName=MYDB";
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://"+ServerName+";databaseName="+DBName+"",userName, password);

		// Executing SQL queries-
		Statement stmt = null;
		stmt = conn.createStatement();

		// query
		String sql = "select * from "+TableName+"";
		ResultSet result = stmt.executeQuery(sql);

		int nCol = result.getMetaData().getColumnCount();
		List<String[]> table = new ArrayList<>();
		String[][] data;

		// a conditional procedure that will be executed only if the file has a
		// next non-empty line
		while (result.next()) {

			String[] row = new String[nCol];

			// Loop to fill row from ResultSet [Result]
			for (int iCol = 1; iCol <= nCol; iCol++) {
				Object obj = result.getObject(iCol);
				row[iCol - 1] = (obj == null) ? null : obj.toString();
			}
			// Add array String [row]to array list (ArrayList<>).
			table.add(row);
		}
		// cast the (ArrayList<>) to 2D array of Strings (String [][]) so that it can match the DataProvider return type
		data = table.toArray(new String[table.size()][]);

		// Loop for print
		// 1- loop in 2D array [MyData] Rows.
		for (int i = 0; i < data.length; i++) {
			String[] inner = data[i];

			// 1- loop in 2D array [MyData] Columns.
			for (int j = 0; j < inner.length; j++) {
				if (j == inner.length - 1)
					System.out.print(data[i][j]);
				else
					System.out.print(data[i][j] + ",");
			}
			System.out.println();
		}

		stmt.close();
		conn.close();
	}

}
