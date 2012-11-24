package model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;



import model.LDate;

import org.junit.Test;


public class LDateTest {

	@Test
	public void testAddDayOK1(){
		LDate today = LDate.get(2012, 10, 20);
		LDate tomorrow = today.addDay(1);
		assertEquals(2012, tomorrow.getYear());
		assertEquals(10, tomorrow.getMonth());
		assertEquals(21, tomorrow.getDay());
	}
	
	@Test
	public void testAddOK2(){
		LDate today = LDate.get(2012, 10, 20);
		LDate yesterday = today.addDay(-1);
		assertEquals(LDate.get(2012, 10, 19), yesterday);
	}
	
	@Test
	public void testGtOK1(){
		LDate value = LDate.get(2012, 4,10);
		LDate compared = LDate.get(2012, 4, 11);
		
		assertThat(true, is(value.lt(compared)));
	}
	
	@Test
	public void testEncodeOK1(){
		LDate date = LDate.get(1989, 4, 9);
		
		assertThat(date.encode(), is("19890409"));
	}
	
	@Test
	public void testGetDaysCountOK1(){
		LDate from = LDate.decode("20120410");
		LDate to = LDate.decode("20120510");
		
		assertThat(30, is(from.getDaysCount(to)));
	}

}
