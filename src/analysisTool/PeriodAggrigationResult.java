/**
 * 
 */
package analysisTool;

import model.LDate;
import model.Period;

/**
 * @author mura_mi
 * 
 */
public interface PeriodAggrigationResult extends AggrigationResult {

    Period getPeriod();

    LDate getFrom();

    LDate getTo();
}
