/**
 * 
 */
package dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import entity.CashFlowCategory;

/**
 * @author mura_mi
 * 
 */
public class CashFlowCategoryDaoTest {

    private CashFlowCategoryDao dao = CashFlowCategoryDao.getInstance();

    @Test
    public void testSaveOrUpdateOK1() {
	CashFlowCategory cfCategory = new CashFlowCategory();

	cfCategory.setId(1L);
	cfCategory.setParent(5L);
	cfCategory.setDescription("this is test");

	dao.saveOrUpdate(cfCategory);
    }

    @Test
    public void testLoadOK1() {
	CashFlowCategory category = dao.findByPrimaryKey(1L);

	assertThat(category.getId(), is(1L));
	assertThat(category.getParent(), is(5L));
	assertThat(category.getDescription(), is("this is test"));
    }

}
