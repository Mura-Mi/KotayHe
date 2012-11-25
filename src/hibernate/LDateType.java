/**
 * 
 */
package hibernate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LDate;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.IntegerType;
import org.hibernate.usertype.EnhancedUserType;

/**
 * @author murakamitakuya
 * 
 */
public class LDateType implements EnhancedUserType {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#sqlTypes()
	 */
	@Override
	public int[] sqlTypes() {
		return new int[] { IntegerType.INSTANCE.sqlType(), //
				IntegerType.INSTANCE.sqlType(), //
				IntegerType.INSTANCE.sqlType() };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#returnedClass()
	 */
	@Override
	public Class<?> returnedClass() {
		return LDate.class;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#equals(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return ObjectUtils.equals(x, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
	 */
	@Override
	public int hashCode(Object x) throws HibernateException {
		LDate lDate = (LDate) x;
		return lDate.hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet,
	 * java.lang.String[], org.hibernate.engine.spi.SessionImplementor,
	 * java.lang.Object)
	 */
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		LDate entity = null;
		Integer year = rs.getInt(names[0]);
		Integer month = rs.getInt(names[1]);
		Integer day = rs.getInt(names[2]);
		if (year != null && month != null && day != null) {
			entity = LDate.get(year, month, day);
		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement,
	 * java.lang.Object, int, org.hibernate.engine.spi.SessionImplementor)
	 */
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, IntegerType.INSTANCE.sqlType());
		} else {
			LDate date = (LDate) value;
			Integer integer = null;
			switch (index) {
			case 1:
				integer = date.getYear();
				break;
			case 2:
				integer = date.getMonth();
				break;
			case 3:
				integer = date.getDay();
			default:
				integer = Integer.valueOf(0);
				break;
			}
			st.setInt(index, integer);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
	 */
	@Override
	public Object deepCopy(Object value) throws HibernateException {
		LDate date = (LDate) value;
		return date.getClone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#isMutable()
	 */
	@Override
	public boolean isMutable() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
	 */
	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable,
	 * java.lang.Object)
	 */
	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.usertype.UserType#replace(java.lang.Object,
	 * java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.usertype.EnhancedUserType#objectToSQLString(java.lang.Object
	 * )
	 */
	@Override
	public String objectToSQLString(Object value) {
		LDate date = (LDate) value;
		return "'" + date.toString() + "'";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.usertype.EnhancedUserType#toXMLString(java.lang.Object)
	 */
	@Override
	public String toXMLString(Object value) {
		LDate date = (LDate) value;
		return date.encode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.hibernate.usertype.EnhancedUserType#fromXMLString(java.lang.String)
	 */
	@Override
	public Object fromXMLString(String xmlValue) {
		return LDate.decode(xmlValue);
	}
}
