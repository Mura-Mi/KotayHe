/**
 * 
 */
package dao;

import java.io.Serializable;
import java.sql.Connection;

/**
 * @author murakamitakuya
 *
 * @param <E>
 */
public abstract class AbstractDao<E> {
	private static final Connection CONNECTION = ConnectionSupplier.getConnection();
	
	protected AbstractDao() {
		
	}
	
	/**
	 * get the connection
	 * @return connection
	 */
	protected Connection getConnection(){
		return CONNECTION;
	}
	
	/**
	 * Find the unique entity by using the primary key.
	 * @param pk primary key
	 * @return the unique entity. {@code null} when the entity was not found.
	 */
	public abstract E findByPrimaryKey(Serializable pk);
	
}
