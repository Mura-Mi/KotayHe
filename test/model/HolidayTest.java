package model;


import static org.junit.Assert.*;

import java.util.List;


import model.Holiday;

import org.junit.Test;

public class HolidayTest {

	@Test
	public void testGetHolidays(){
		List<Holiday> holidays = Holiday.getHolidays();
		assertNotNull(holidays);
	}
}
