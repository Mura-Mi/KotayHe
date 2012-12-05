/**
 * 
 */
package entity;

import utils.Nullable;
import entity.base.CashFlowCategoryBase;

/**
 * @author murakamitakuya
 * 
 */
public class CashFlowCategory extends CashFlowCategoryBase implements Nullable {
    private static final CashFlowCategory NULL_INSTANCE = new NullCashFlowCategory();

    public static CashFlowCategory getNull() {
	return NULL_INSTANCE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see utils.Nullable#isNull()
     */
    @Override
    public boolean isNull() {
	return false;
    }

    private static class NullCashFlowCategory extends CashFlowCategory {

	@Override
	public Long getId() {
	    return null;
	}

	@Override
	public Long getParent() {
	    return null;
	}

	@Override
	public String getDescription() {
	    return null;
	}

	@Override
	public boolean isNull() {
	    return true;
	}

    }
}
