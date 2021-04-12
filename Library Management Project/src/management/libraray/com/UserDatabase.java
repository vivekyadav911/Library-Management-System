package management.libraray.com;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDatabase {
	public static void main(String [] args) {
		
		UserModel user = new UserModel();
		
		new UserDatabase().insert(user);
		System.out.println("ok ok and ok");
	}

	public int insert(UserModel user) {
		
		int i = 0;
		try (Connection con = DatabaseDriver.getConnection();) {
			PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?)");
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return i;
		
	}
	
}
