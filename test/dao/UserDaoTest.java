/**
 * 
 */
package dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import entity.KotayHeUser;

/**
 * @author murakamitakuya
 * 
 */
public class UserDaoTest {
	UserDao dao = UserDao.getInstance();

	@Test
	public void test() {
		KotayHeUser user = dao.findByPrimaryKey(1L);
		
		assertThat(user.getId(), is(1L));
		assertThat(user.getName(), is("takuya"));
	}

}
