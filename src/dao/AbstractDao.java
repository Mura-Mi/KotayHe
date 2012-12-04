/**
 * 
 */
package dao;

import java.io.Serializable;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author murakamitakuya
 * 
 * @param <E>
 */
public abstract class AbstractDao<E> {

    private static final SessionFactory SESSION_FACTORY;

    static {

	Configuration config = new Configuration().configure();
	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
		config.getProperties()).buildServiceRegistry();
	SESSION_FACTORY = new Configuration().configure().buildSessionFactory(
		sr);
    }

    protected static Session getSession() {

	return SESSION_FACTORY.openSession();
    }

    protected AbstractDao() {
    }

    /**
     * returns the class type this dao deals.
     * 
     * @return the type of the class
     */
    protected abstract Class<E> getClassType();

    /**
     * Find the unique entity by using the primary key.
     * 
     * @param pk
     *            primary key
     * @return the unique entity. {@code null} when the entity was not found.
     */
    @SuppressWarnings("unchecked")
    public E findByPrimaryKey(Serializable pk) {
	Session session = getSession();

	if (session == null) {
	    return null;
	}

	try {
	    return (E) session.load(getClassType(), pk);
	} catch (ObjectNotFoundException e) {
	    return null;
	} finally {
	    session.close();
	}
    }

    public void saveOrUpdate(E e) {
	Session session = getSession();
	Transaction transaction = session.beginTransaction();

	// session.saveOrUpdate(e);
	session.saveOrUpdate(e);

	transaction.commit();

	session.close();

    }
}
