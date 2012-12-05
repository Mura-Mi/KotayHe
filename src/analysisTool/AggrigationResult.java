/**
 * 
 */
package analysisTool;

import java.math.BigDecimal;

import entity.CashFlow;
import entity.CashFlowCategory;

/**
 * @author mura_mi
 * 
 */
public interface AggrigationResult {

    /**
     * add the cash flow.
     * 
     * @param cashFlow
     * @return
     */
    boolean addCashFlow(CashFlow cashFlow);

    /**
     * gets the amount of income.
     * 
     * @return amount
     */
    BigDecimal getIncomeAmount();

    /**
     * the amount of outgo.
     * 
     * @return amount
     */
    BigDecimal getOutgoAmount();

    /**
     * gets the amount of the category.
     * 
     * @param category
     * @return
     */
    public BigDecimal getCashFlowAmount(CashFlowCategory category);
}