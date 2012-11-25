/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.KotayHeRuntimeException;

/**
 * @author murakamitakuya
 * 
 */
public class RenewTableBatch implements Executable<Long> {
	private Connection connection;

	public RenewTableBatch() {
		this.connection = ConnectionSupplier.getConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.Executable#execute()
	 */
	@Override
	public ExecuteResult<Long> execute() {
		Long l = System.currentTimeMillis();
		String sql = "CREATE TABLE hogeBatchTest(id Integer)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new KotayHeRuntimeException(e);
		}

		return new ExecuteResult<Long>(true, System.currentTimeMillis() - l);
	}

}
