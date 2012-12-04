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
		KotayHeUser user1 = new KotayHeUser();
		user1.setId(1L);
		user1.setName("takuya");

		dao.saveOrUpdate(user1);

		KotayHeUser user2 = dao.findByPrimaryKey(1L);

		assertThat(user2.getId(), is(1L));
		assertThat(user2.getName(), is("takuya"));

		KotayHeUser user4 = new KotayHeUser();

		user4.setId(1L);
		user4.setName("oreore");

		dao.saveOrUpdate(user4);

		KotayHeUser user3 = dao.findByPrimaryKey(1L);

		assertThat(user3.getId(), is(1L));
		assertThat(user3.getName(), is("oreore"));
	}

}
