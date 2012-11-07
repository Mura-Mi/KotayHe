/**
 * 
 */
package dao;

import java.sql.Connection;

import org.junit.Test;

/**
 * @author murakamitakuya
 *
 */
public class ConnectionSupplierTest {

	@Test
	public void test() {
		@SuppressWarnings("unused")
		Connection con = ConnectionSupplier.getConnection();
	}

}
