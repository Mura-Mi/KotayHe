/**
 * 
 */
package dao;

import java.util.List;

import model.InOut;
import entity.CashFlow;

/**
 * @author murakamitakuya
 * 
 */
public class CashFlowDao extends AbstractDao<CashFlow> {

    private static final CashFlowDao INSTANCE = new CashFlowDao();

    private CashFlowDao() {
	super();
    }

    public static CashFlowDao getInstance() {
	return INSTANCE;
    }

    @Override
    protected Class<CashFlow> getClassType() {
	return CashFlow.class;
    }

    public List<CashFlow> get(InOut inOut) {
	// TODO auto generated.
	return null;
    }

}
