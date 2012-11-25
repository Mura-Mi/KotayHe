/**
 * 
 */
package analysisTool;

import java.io.FileNotFoundException;
import java.util.List;

import utils.BusinessDayCalculator;

import model.LDate;
import model.Period;
import model.Record;
import model.YearMonth;

/**
 * @author murakamitakuya
 * 
 */
public class MonthlyCashflowAggrigator {

	/**
	 * @param args
	 * TODO 給料日は外出し．
	 */
	public static void main(String[] args) {
		LDate from = YearMonth.decode(args[0]).getDayOf(20);
		LDate to = YearMonth.decode(args[1]).getDayOf(20);
		
		BusinessDayCalculator calclator = BusinessDayCalculator.INSTANCE;
		from = calclator.getBusinessDay(from);
		to = calclator.getBusinessDay(to);
		

		List<Record> records = getRecords(
				"/Users/murakamitakuya/Desktop/utfRecord.csv", from, to.addDay(-1));
		RecordAggrigator aggrigator = RecordAggrigator.getInstance();

		AggrigationResult result = aggrigator.aggrigate(records);

		RecordPresentor presentor = new ConsoleRecordPresentor(result);
		presentor.show();
	}

	private static List<Record> getRecords(String fileName, LDate from, LDate to) {
		BankHistoryReader reader = null;
		try {
			reader = BankHistoryReader.getInstance(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		return reader.read(Period.of(from, to));
	}
}
