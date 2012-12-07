/**
 * 
 */
package analysisTool.aggregationresult;

import java.math.BigDecimal;

import entity.CashFlowCategory;

/**
 * @author mura_mi
 * 
 *         This is the result of the aggrigation of cashflows.
 *         <p>
 *         Cashflow to be aggrigated is extracted by some condition.
 * 
 */
public interface AggrigationResult {

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
     * gets the income amount of the category.
     * 
     * @param category
     * @return
     */
    BigDecimal getIncomeCashFlowAmount(CashFlowCategory category);

    /**
     * gets the outgo amount of the category.
     * 
     * @param category
     * @return
     */
    BigDecimal getOutgoCashFlowAmount(CashFlowCategory category);
}