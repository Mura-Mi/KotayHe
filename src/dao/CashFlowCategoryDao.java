/**
 * 
 */
package dao;

import entity.CashFlowCategory;

/**
 * @author mura_mi
 * 
 */
public class CashFlowCategoryDao extends AbstractDao<CashFlowCategory> {

    private static final CashFlowCategoryDao INSTANCE = new CashFlowCategoryDao();

    private CashFlowCategoryDao() {

    }

    public static CashFlowCategoryDao getInstance() {
	return INSTANCE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see dao.AbstractDao#getClassType()
     */
    @Override
    protected Class<CashFlowCategory> getClassType() {
	return CashFlowCategory.class;
    }

}
