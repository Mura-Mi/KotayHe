/**
 * 
 */
package dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.KotayHeUser;
import exception.KotayHeRuntimeException;

/**
 * @author murakamitakuya
 * 
 */
public class UserDao extends AbstractDao<KotayHeUser> {

	private static final UserDao INSTANCE = new UserDao();

	private UserDao() {
		super();
	}

	public static UserDao getInstance() {
		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.AbstractDao#findByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public KotayHeUser findByPrimaryKey(Serializable pk) {
		if (!(pk instanceof Long)) {
			throw new IllegalArgumentException(
					"The type of Primary Key is Wrong. It should be Long.");
		}

		String str = "SELECT * FROM KOTAYHE_USER WHERE ID = ?";
		PreparedStatement statement = null;
		try {
			statement = getConnection().prepareStatement(str);
			statement.setLong(1, (Long) pk);
		} catch (SQLException e) {
			throw new KotayHeRuntimeException(e);
		}
		ResultSet result = null;
		try {
			result = statement.executeQuery();
		} catch (SQLException e) {
			throw new KotayHeRuntimeException(e);
		}

		KotayHeUser entity = new KotayHeUser();
		try {
			if (result.next()) {
				entity.setId(result.getLong("id"));
				entity.setName(result.getString("name"));
			} else {
				return null;
			}

			if (result.next()) {
				throw new KotayHeRuntimeException("The result was not unique.");
			}
		} catch (SQLException e) {
			throw new KotayHeRuntimeException(e);
		}

		return entity;
	}

}
