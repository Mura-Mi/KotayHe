/**
 * 
 */
package analysisTool;

import java.math.BigDecimal;

import model.Period;

/**
 * @author murakamitakuya
 * 
 *         this is the calculator to calculate the budget for given period.
 */
public interface AverageBudgetCalculator {
    /**
     * Calculate the average budget for each day in the period.
     * 
     * @param period
     * @return
     */
    BigDecimal getDailyBudget(Period period);
}
