package dms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://123.206.48.254:11525/dms";
		String username="cdb_outerroot";
		String password="lshsb123";
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		statement.execute("INSERT INTO `group`(gid,gname) VALUE(1,'2')");
		statement.close();
		connection.close();
	}
}
