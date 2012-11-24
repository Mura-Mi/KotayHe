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
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/kotayHe";
			CONNECTION = DriverManager.getConnection(url,"root","harari0027");
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
