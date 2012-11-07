package model;

import java.io.FileNotFoundException;
import java.util.List;

import utils.CSVReader;



import com.google.common.collect.Lists;

// TODO ハードコードを解消する．
public class Holiday {
	private static final List<Holiday> VALUES;
	private final String name;
	private final LDate date;

	static {
		List<Holiday> values = Lists.newArrayList();

		CSVReader reader = null;
		try {
			reader=CSVReader.getInstance("holiday.csv");
		} catch (FileNotFoundException e) {
			// logとか吐くべきなの？
		}

		if (reader == null) {
			VALUES = null;
		} else {
			while (true) {
				String[] record = reader.readRecord();
				if (record == null) {
					break;
				}
				int year = Integer.parseInt(record[0]);
				int month = Integer.parseInt(record[1]) - 1;
				int day = Integer.parseInt(record[2]);
				LDate date = LDate.get(year, month, day);
				String title = record[3];
				Holiday holiday = new Holiday(title, date);
				values.add(holiday);
			}
			VALUES = values;
		}

	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            holiday name
	 * @param date
	 *            holiday date
	 */
	public Holiday(String name, LDate date) {
		this.name = name;
		this.date = date;
	}

	/**
	 * ask if the date is holiday.
	 * 
	 * @param date
	 *            date to be judged
	 * @return return {@code true} when the date is holiday.
	 */
	public static boolean isHoliday(LDate date) {
		return VALUES.contains(date);
	}

	/**
	 * gets the holidays. 
	 * @return holidays
	 */
	public static List<Holiday> getHolidays() {
		return VALUES;
	}

	/**
	 * name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * date
	 * @return date
	 */
	public LDate getDate() {
		return date;
	}

}
