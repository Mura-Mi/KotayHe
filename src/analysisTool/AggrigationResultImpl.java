/**
 * 
 */
package analysisTool;

import java.math.BigDecimal;
import java.util.Map;

import model.InOut;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import entity.CashFlow;
import entity.CashFlowCategory;

/**
 * @author murakamitakuya
 * 
 */
public class AggrigationResultImpl implements AggrigationResult {

    private Map<CashFlowCategory, BigDecimal> incomeAmounts;
    private Map<CashFlowCategory, BigDecimal> outgoAmounts;

    public AggrigationResultImpl() {
	this.incomeAmounts = Maps.newHashMap();
	this.outgoAmounts = Maps.newHashMap();
    }

    /*
     * (non-Javadoc)
     * 
     * @see analysisTool.AggrigationResult#addCashFlow(entity.CashFlow)
     */
    @Override
    public boolean addCashFlow(CashFlow cashFlow) {
	if (cashFlow == null || cashFlow.getInOut() == null) {
	    return false;
	}
	if (cashFlow.getInOut() == InOut.IN) {
	    addIncome(cashFlow);
	} else {
	    addOutgo(cashFlow);
	}
	return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see analysisTool.AggrigationResult#getIncomeAmount()
     */
    @Override
    public BigDecimal getIncomeAmount() {
	// TODO Auto-generated method stub
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see analysisTool.AggrigationResult#getOutgoAmount()
     */
    @Override
    public BigDecimal getOutgoAmount() {
	// TODO Auto-generated method stub
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * analysisTool.AggrigationResult#getCashFlowAmount(entity.CashFlowCategory)
     */
    @Override
    public BigDecimal getCashFlowAmount(CashFlowCategory category) {
	// TODO Auto-generated method stub
	return null;
    }

    private void addIncome(CashFlow cashFlow) {
	Preconditions.checkNotNull(cashFlow);
	Preconditions.checkNotNull(cashFlow.getInOut());

	if (incomeAmounts.containsKey(cashFlow.getInOut())) {

	}
    }

    private void addOutgo(CashFlow cashFlow) {

    }
}