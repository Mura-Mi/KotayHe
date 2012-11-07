package model;

public class YearMonth {
	private final int year;
	private final int month;

	public YearMonth(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public static YearMonth decode(String source) {
		if (source.length() != 6) {
			throw new IllegalArgumentException(
					"the length of source is wrong: " + source.length());
		}
		int year, month;
		try {
			year = Integer.valueOf(source.substring(0, 4));
			month = Integer.valueOf(source.substring(4, 6));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("source is illegal: " + source);
		}
		
		return new YearMonth(year, month);

	}

	public LDate getFirstDay() {
		return getDayOf(1);
	}

	public LDate getDayOf(int day) {
		// TODO 月毎におしりが違う時の処理
		return LDate.get(year, month, day);

	}

}
