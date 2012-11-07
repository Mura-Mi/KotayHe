/**
 * 
 */
package analysisTool;

import java.util.List;

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
		AggrigationResult result = new AggrigationResult();

		for (Record record : records) {
			result.addRecord(record);
		}

		return result;
	}
}
