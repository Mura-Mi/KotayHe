/**
 * 
 */
package analysisTool.aggregationresult;

import entity.CashFlow;

/**
 * @author mura_mi
 * 
 *         This is an extension of {@link AggrigationResult}. This
 *         {@code AggrigationResult} is able to be added new cashflow.
 */
public interface MutableAggrigationResult extends AggrigationResult {

    /**
     * add the cash flow.
     * 
     * @param cashFlow
     * @return
     */
    public abstract boolean addCashFlow(CashFlow cashFlow);

}