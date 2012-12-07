package analysisTool.aggregationresult;

import model.LDate;
import model.Period;

/**
 * @author mura_mi
 * 
 */
public interface PeriodAggrigationResult extends AggrigationResult {

    /**
     * Get the period of the aggregation.
     * 
     * @return
     */
    Period getPeriod();

    /**
     * get the start date of the aggregation period.
     * 
     * @return
     */
    LDate getFrom();

    /**
     * get the end date of the aggregation period.
     * 
     * @return
     */
    LDate getTo();
}
