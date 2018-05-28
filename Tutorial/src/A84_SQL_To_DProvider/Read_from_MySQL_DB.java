package A84_SQL_To_DProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read_from_MySQL_DB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// JDBC Driver class
		Class.forName("com.mysql.jdbc.Driver");
		//Creating a connection to the database.
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/project2", "root", "");
		
		//Executing SQL queries-
		Statement stmt = null;
		stmt = conn.createStatement();

		// query
		String sql = "select * from CalcTable";
		ResultSet rs = stmt.executeQuery(sql);

		//Fetching data from result set-
		while (rs.next()) {

			int ID = rs.getInt("ID");
			String Name = rs.getString("Name");
			Double Salary = rs.getDouble("Salary");

			System.out.println(ID + " " + Name + " " + Salary);
		}

		stmt.close();
		conn.close();
	}
}
