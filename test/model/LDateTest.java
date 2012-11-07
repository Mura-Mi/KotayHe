package model;

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
	

}
