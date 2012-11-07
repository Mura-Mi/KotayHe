package utils;

import static org.junit.Assert.*;



import model.LDate;
import model.Period;
import model.YearMonth;

import org.junit.Test;

import utils.BusinessDayCalculator;


public class BusinessPeriodCalculatorTest {
	private BusinessDayCalculator calculator = BusinessDayCalculator.INSTANCE;

	@Test
	public void testGetPeriodOK1() {
		YearMonth start = new YearMonth(2012, 9);
		YearMonth end = new YearMonth(2012, 10);
		
		Period period = calculator.getPeriod(start, end);
		LDate from = LDate.get(2012, 9, 20);
		LDate to = LDate.get(2012,10, 18);
		assertEquals(Period.of(from, to), period);
	}

}
