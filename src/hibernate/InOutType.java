/**
 * 
 */
package hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.InOut;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

/**
 * @author murakamitakuya
 * 
 */
public class InOutType extends AbstractCustomType {

	@Override
	public Class<?> returnedClass() {
		return InOut.class;
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		String source = null;
		// if (rs.next()) {
		source = rs.getString(names[0]);
		// }

		return InOut.getByDBValue(source);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		InOut inout = (InOut) value;

		st.setString(index, inout.getDBValue());
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		InOut inout = (InOut) value;
		return InOut.getByDBValue(inout.getDBValue());
	}

}
