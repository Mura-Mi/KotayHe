/**
 * 
 */
package dao;

import entity.Journal;

/**
 * @author mura_mi
 * 
 */
public class JournalDao extends AbstractDao<Journal> {
    private static final JournalDao INSTANCE = new JournalDao();

    private JournalDao() {
    }

    public static JournalDao getInstance() {
	return INSTANCE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see dao.AbstractDao#getClassType()
     */
    @Override
    protected Class<Journal> getClassType() {
	return Journal.class;
    }

}
