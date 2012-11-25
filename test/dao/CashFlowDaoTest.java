/**
 * 
 */
package dao;

import java.math.BigDecimal;

import model.InOut;
import model.LDate;

import org.junit.Test;

import entity.CashFlow;

/**
 * @author murakamitakuya
 *
 */
public class CashFlowDaoTest {

	@Test
	public void test() {
		CashFlowDao dao = CashFlowDao.getInstance();
		CashFlow cf = new CashFlow();
		cf.setId(1L);
		cf.setAmount(BigDecimal.valueOf(5000));
		cf.setCategoryId(1L);
		cf.setDate(LDate.decode("19890410"));
		cf.setInOut(InOut.IN);
		cf.setDescription("Description");
		cf.setJournalId(5L);
		
		dao.saveOrUpdate(cf);
	}

}
