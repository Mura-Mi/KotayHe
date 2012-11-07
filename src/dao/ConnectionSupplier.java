/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author murakamitakuya
 * 
 * TODO: ログイン名とかをプロパティに切り出せるようにする．
 */
public class ConnectionSupplier {

	private static Connection CONNECTION = null;

	static {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql:KotayHe";
			CONNECTION = DriverManager.getConnection(url, "takuya", "takuya");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ConnectionSupplier() {

	}

	public static Connection getConnection(){
		return CONNECTION;
	}
}
