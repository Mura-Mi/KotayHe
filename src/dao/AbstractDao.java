/**
 * 
 */
package dao;

import java.io.Serializable;
import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author murakamitakuya
 * 
 * @param <E>
 */
public abstract class AbstractDao<E> {
	private static final Connection CONNECTION = ConnectionSupplier
			.getConnection();

	protected static Session getSession() {
		Configuration config = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory(sr);

		return sessionFactory.openSession();
	}

	/**
	 * 1 = domain name
	 * <p>
	 * 2 = pk name
	 * <p>
	 * 3 = pk value
	 */
	@Deprecated
	protected static final String findByPkQuery = "SELECT * FROM ? WHERE ? = ?";

	protected AbstractDao() {

	}

	/**
	 * get the connection
	 * 
	 * @return connection
	 */
	@Deprecated
	protected Connection getConnection() {
		return CONNECTION;
	}

	/**
	 * Find the unique entity by using the primary key.
	 * 
	 * @param pk
	 *            primary key
	 * @return the unique entity. {@code null} when the entity was not found.
	 */
	public abstract E findByPrimaryKey(Serializable pk);

}
