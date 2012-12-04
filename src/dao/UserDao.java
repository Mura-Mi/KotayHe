/**
 * 
 */
package dao;

import entity.KotayHeUser;

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

    @Override
    protected Class<KotayHeUser> getClassType() {
	return KotayHeUser.class;
    }

}
