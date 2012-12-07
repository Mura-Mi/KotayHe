/**
 * 
 */
package analysisTool.aggregationresult.impl;

import java.math.BigDecimal;
import java.util.Map;

import model.DecimalModel;
import model.InOut;

import analysisTool.aggregationresult.MutableAggrigationResult;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import entity.CashFlow;
import entity.CashFlowCategory;

/**
 * @author murakamitakuya
 * 
 *         This is an implementation of {@link MutableAggrigationResult}.
 */
public class MutableAggrigationResultImpl implements MutableAggrigationResult {

    private Map<Long, BigDecimal> incomeAmounts;
    private Map<Long, BigDecimal> outgoAmounts;

    public MutableAggrigationResultImpl() {
	this.incomeAmounts = Maps.newHashMap();
	this.outgoAmounts = Maps.newHashMap();
    }

    /*
     * (non-Javadoc)
     * 
     * @see analysisTool.MutableAggrigationResult#addCashFlow(entity.CashFlow)
     */
    @Override
    public boolean addCashFlow(CashFlow cashFlow) {
	if (cashFlow == null || cashFlow.getInOut() == null) {
	    return false;
	}
	if (cashFlow.getInOut() == InOut.IN) {
	    addCashFlow(cashFlow, incomeAmounts);
	} else {
	    addCashFlow(cashFlow, outgoAmounts);
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
	return getAmount(incomeAmounts);
    }

    /*
     * (non-Javadoc)
     * 
     * @see analysisTool.AggrigationResult#getOutgoAmount()
     */
    @Override
    public BigDecimal getOutgoAmount() {
	return getAmount(outgoAmounts);
    }

    private BigDecimal getAmount(Map<Long, BigDecimal> amounts) {
	DecimalModel model = new DecimalModel();
	for (BigDecimal value : amounts.values()) {
	    model.add(value);
	}
	return model.getValue();

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * analysisTool.AggrigationResult#getCashFlowAmount(entity.CashFlowCategory)
     */
    @Override
    public BigDecimal getIncomeCashFlowAmount(CashFlowCategory category) {
	return incomeAmounts.get(category.getId());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * analysisTool.AggrigationResult#getOutgoCashFlowAmount(entity.CashFlowCategory
     * )
     */
    @Override
    public BigDecimal getOutgoCashFlowAmount(CashFlowCategory category) {
	return outgoAmounts.get(category.getId());
    }

    private void addCashFlow(CashFlow cashFlow, Map<Long, BigDecimal> amounts) {
	Preconditions.checkNotNull(cashFlow);
	Preconditions.checkNotNull(cashFlow.getInOut());

	Long categoryId = cashFlow.getCategoryId();
	if (amounts.containsKey(categoryId)) {
	    amounts.put(categoryId,
		    amounts.get(categoryId).add(cashFlow.getAmount()));
	} else {
	    amounts.put(categoryId, cashFlow.getAmount());
	}

    }
}