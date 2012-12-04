/**
 * 
 */
package dao;

import org.junit.Test;

import entity.BankJournal;
import entity.Journal;

/**
 * @author mura_mi
 * 
 */
public class JournalDaoTest {

    private JournalDao dao = JournalDao.getInstance();

    @Test
    public void test() {
	Journal jou = new BankJournal();
	jou.setId(5L);
	jou.setName("name hogehoge");
	jou.setUserId(10001L);
	((BankJournal) jou).setBankName("SMBC!!!");

	dao.saveOrUpdate((BankJournal) jou);

    }

}
