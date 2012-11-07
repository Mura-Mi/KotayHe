package model;

public class LDate {
	private final int year;
	private final int month;
	private final int day;

	private LDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public static LDate get(int year, int month, int day) {
		// TODO 異常値を受け取った際の挙動．
		return new LDate(year, month, day);
	}

	public static LDate decode(String value) {
		if (value.length() != 8) {
			throw new IllegalArgumentException("the length is illegal: "
					+ value.length());
		}
		int year;
		int month;
		int day;
		try {
			year = Integer.valueOf(value.substring(0, 4));
			month = Integer.valueOf(value.substring(4, 6));
			day = Integer.valueOf(value.substring(6, 8));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					"the value is illegal: " + value, e);
		}
		return new LDate(year, month, day);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public LDate addDay(int i) {
		// TODO 異常値を受け取った際の挙動．
		return LDate.get(year, month, (day + i));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LDate other = (LDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/**
	 * @param from
	 * @return
	 */
	public boolean ge(LDate o) {
		if (this.equals(o)) {
			return true;
		}
		return this.gt(o);
	}

	/**
	 * @param o
	 * @return
	 */
	private boolean gt(LDate o) {
		if (this.getYear() > o.getYear()) {
			return true;
		} else if (this.getYear() < o.getYear()) {
			return false;
		}

		if (this.getMonth() > o.getMonth()) {
			return true;
		} else if (this.getMonth() < o.getMonth()) {
			return false;
		}

		if (this.getDay() > o.getDay()) {
			return true;
		}
		return false;
	}

	/**
	 * @param o
	 * @return
	 */
	public boolean le(LDate o) {
		return !gt(o);
	}

	public boolean lt(LDate o) {
		return !ge(o);
	}

}
