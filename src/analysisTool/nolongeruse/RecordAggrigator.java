/**
 * 
 */
package analysisTool.nolongeruse;

import java.util.List;

import analysisTool.aggregationresult.AggrigationResult;

import model.Record;

/**
 * @author murakamitakuya
 * 
 */
public class RecordAggrigator {
    private static final RecordAggrigator INSTANCE = new RecordAggrigator();

    /**
	 * 
	 */
    private RecordAggrigator() {

    }

    public static RecordAggrigator getInstance() {
	return INSTANCE;
    }

    /**
     * @param records
     * @return
     */
    public AggrigationResult aggrigate(List<Record> records) {
	return null;
    }
}
