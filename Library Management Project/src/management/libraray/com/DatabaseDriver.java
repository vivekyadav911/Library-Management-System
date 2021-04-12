package management.libraray.com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseDriver {
	
	private static Connection con;
	

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "vivekyadav");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
