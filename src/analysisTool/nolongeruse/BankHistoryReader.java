/**
 * 
 */
package analysisTool.nolongeruse;

import java.io.FileNotFoundException;
import java.util.List;

import model.IncomeRecord;
import model.IncomeRecordClassification;
import model.OutGoRecord;
import model.OutGoRecordClassification;
import model.Period;
import model.Record;

import org.apache.commons.lang3.StringUtils;

import utils.CSVReader;
import utils.LDateParser;

import com.google.common.collect.Lists;

/**
 * @author murakamitakuya
 * 
 */
public class BankHistoryReader {
	private CSVReader csvReader;
	private LDateParser parser = LDateParser.getDefaultParser();

	private BankHistoryReader(String csvFileName) throws FileNotFoundException {
		this.csvReader = CSVReader.getInstance(csvFileName);
		this.csvReader.readRecord(); // TODO ヘッダ処理
	}

	public static BankHistoryReader getInstance(String csvFileName)
			throws FileNotFoundException {
		return new BankHistoryReader(csvFileName);
	}

	public List<Record> readAll() {
		return read(null);
	}

	public List<Record> read(Period period) {
		List<Record> result = Lists.newArrayList();
		while (true) {
			String[] line = csvReader.readRecord();
			if (line == null) {
				break;
			}
			Record record = parseRecord(line);
			if (period == null || period.contains(record.getDate())) {
				result.add(record);
			}
		}
		return result;
	}

	private Record parseRecord(String[] line) {
		// TODO ヘッダや並びが変わってもいいようにしたい．
		if (line.length != 6) {
			throw new IllegalArgumentException(
					"the length of record is wrong: " + line.length);
		}
		Record record = null;
		String title = line[1];

		if (StringUtils.isBlank(line[2]) && !StringUtils.isBlank(line[3])) {
			record = new IncomeRecord();
			Long amount = Long.parseLong(line[3]);
			record.setAmount(amount);

			IncomeRecordClassification cl = IncomeRecordClassification
					.valueOf(getClassificationName(line[1]));
			((IncomeRecord) record).setClassification(cl);
		} else if (!StringUtils.isBlank(line[2])
				&& StringUtils.isBlank(line[3])) {
			Long amount = Long.parseLong(line[2]);
			record = new OutGoRecord();
			record.setAmount(amount);

			OutGoRecordClassification cl = OutGoRecordClassification
					.valueOf(getClassificationName(line[1]));
			((OutGoRecord) record).setClassification(cl);
		} else {
			throw new IllegalArgumentException(
					"Both outgo and income are written. \n" + //
							"income: " + line[3] + "\n" + //
							"outgo: " + line[2]);
		}

		record.setTitle(title);
		record.setDate(parser.parse(line[0]));

		return record;
	}

	/**
	 * @param string
	 * @return
	 */
	private String getClassificationName(String source) {
		int spaceIndex = source.indexOf("　");
		int astarIndex = source.indexOf("＊");

		try {
			return source.substring(0, Math.max(spaceIndex, astarIndex));
		} catch (StringIndexOutOfBoundsException e) {
			return source;
		}
	}
}
