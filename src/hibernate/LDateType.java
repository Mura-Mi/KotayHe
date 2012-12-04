/**
 * 
 */
package hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LDate;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

/**
 * @author murakamitakuya
 * 
 */
public class LDateType extends AbstractCustomType {

	@Override
	public Class<?> returnedClass() {
		return LDate.class;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		String value = null;
		// if (rs.next()) {
		value = rs.getString(names[0]);
		// }
		return LDate.decode(value);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		if (!(value instanceof LDate)) {
			throw new IllegalArgumentException();
		}
		LDate date = (LDate) value;

		st.setString(index, date.toString());
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		if (!(value instanceof LDate)) {
			throw new IllegalArgumentException();
		}
		LDate date = (LDate) value;
		return date.getClone();
	}

}
