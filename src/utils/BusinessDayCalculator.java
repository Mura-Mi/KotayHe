package utils;
import java.util.Calendar;

import model.LDate;
import model.Period;
import model.YearMonth;


public enum BusinessDayCalculator {
	// Singleton
	INSTANCE();
	// TODO プロパティに切り出したい．
	private static final int SALARY_DAY = 20;

	private BusinessDayCalculator() {
	}

	public Period getPeriod(YearMonth startYearMonth, YearMonth endYearMonth) {
		LDate from = getBusinessDay(LDate.get(startYearMonth.getYear(), startYearMonth.getMonth(), SALARY_DAY));
		LDate to = getBusinessDay(LDate.get(endYearMonth.getYear(), endYearMonth.getMonth(), SALARY_DAY));
		to = to.addDay(-1);

		return Period.of(from, to);
	}

	public boolean isBusinessDay(LDate date) {
		// TODO カレンダーとかに依存しない自分の判定機能を作る．
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(date.getYear(), date.getMonth() - 1, date.getDay());

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
			return false;
		}

		return true;
	}

	// TODO よく考えたらひとつの休日調整方式にしか対応してない．
	public LDate getBusinessDay(LDate date) {
		if (this.isBusinessDay(date)) {
			return date;
		}
		while (!this.isBusinessDay(date)) {
			date = date.addDay(-1);
			if (this.isBusinessDay(date)) {
				return date;
			}
			if (date.getDay() <= 0) {
				break;
			}
		}

		return date;
	}

}
