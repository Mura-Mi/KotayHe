package model;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class LDate implements Serializable, Cloneable {
	private final int year;
	private final int month;
	private final int day;

	private LDate(int year, int month, int day) {
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

	public static LDate get(java.util.Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return get(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
				cal.get(Calendar.DAY_OF_MONTH));
	}

	// TODO 不要かも
	public java.sql.Date getSQLDate() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(year, month - 1, day);

		return new java.sql.Date(cal.getTime().getTime());
	}

	public Integer getDaysCount(LDate date) {

		LDate compared;
		try {
			compared = (LDate) date.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalArgumentException();
		}

		if (this.equals(compared)) {
			return 0;
		}

		boolean isGtArg = this.gt(compared);
		for (int i = 0;; i++) {
			compared = compared.addDay(isGtArg ? 1 : -1);
			if (this.equals(compared)) {
				return i;
			}
		}
	}

	public String encode() {
		StringBuilder builder = new StringBuilder();
		builder.append(year);
		builder.append(StringUtils.leftPad(String.valueOf(month), 2, "0"));
		builder.append(StringUtils.leftPad(String.valueOf(day), 2, "0"));
		return builder.toString();
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
		// TODO java.util.Calndar を使わないようにする
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(year, month, day);
		cal.add(Calendar.DAY_OF_MONTH, i);

		return new LDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH));
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
	
	@Override
	public String toString() {
		return encode();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new LDate(year, month, day);
	}
	
	public LDate getClone(){
		try {
			return (LDate) this.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
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
