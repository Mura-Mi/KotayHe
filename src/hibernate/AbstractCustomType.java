package hibernate;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.HibernateException;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

public abstract class AbstractCustomType implements UserType {

	@Override
	public int[] sqlTypes() {
		return new int[] { StringType.INSTANCE.sqlType() };
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return ObjectUtils.equals(x, y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

}
