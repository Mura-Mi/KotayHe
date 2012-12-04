/**
 * 
 */
package dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import model.InOut;
import model.LDate;

import org.junit.Test;

import entity.ActualCashFlow;
import entity.CashFlow;

/**
 * @author murakamitakuya
 * 
 */
public class CashFlowDaoTest {

    @Test
    public void testSaveOrUpdate() {
	CashFlowDao dao = CashFlowDao.getInstance();
	CashFlow cf = new ActualCashFlow();
	cf.setId(2L);
	cf.setAmount(BigDecimal.valueOf(7280));
	cf.setCategoryId(1L);
	cf.setDate(LDate.decode("19890410"));
	cf.setInOut(InOut.IN);
	cf.setDescription("Description");
	cf.setJournalId(5L);

	dao.saveOrUpdate(cf);
    }

    @Test
    public void testLoad() {
	CashFlowDao dao = CashFlowDao.getInstance();
	CashFlow cf = dao.findByPrimaryKey(2L);

	assertNotNull(cf);

	assertThat(cf.getId(), is(2L));
	assertThat(cf.getAmount(), is(BigDecimal.valueOf(7280)));
	assertThat(cf.getCategoryId(), is(1L));
	assertThat(cf.getDate(), is(LDate.decode("19890410")));
	assertThat(cf.getInOut(), is(InOut.IN));
	assertThat(cf.getDescription(), is("Description"));
	assertThat(cf.getJournalId(), is(5L));
    }

}
