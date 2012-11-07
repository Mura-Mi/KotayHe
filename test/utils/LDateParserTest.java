/**
 * 
 */
package utils;

import static org.junit.Assert.assertEquals;
import model.LDate;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author murakamitakuya
 * 
 */
public class LDateParserTest {

	private static LDateParser parser;
	private static LDateParser illeglarParser;

	@BeforeClass
	public static void setUpBefore() {
		parser = LDateParser.getDefaultParser();
		illeglarParser=new LDateParser("yyyy/dd/MM");
	}

	@Test
	public void testParseOK1() {
		String source = "2012/10/12";
		LDate value = parser.parse(source);
		assertEquals(LDate.get(2012, 10, 12), value);
	}

	@Test
	public void testParseOK2() {
		String source = "2012/5/24";
		LDate value = parser.parse(source);
		assertEquals(2012, value.getYear());
		assertEquals(5, value.getMonth());
		assertEquals(24, value.getDay());
	}

	@Test
	public void testParseOK3() {
		String source = "2012/12/8";
		LDate value = parser.parse(source);
		assertEquals(LDate.get(2012, 12, 8), value);
	}

	@Test
	public void testParseOK4() {
		String source = "2012/3/9";
		LDate value = parser.parse(source);
		assertEquals(LDate.get(2012, 3, 9), value);
	}
	
	@Test
	public void testParseIlleglarOK1(){
		String source = "2012/12/10";
		LDate value = illeglarParser.parse(source);
		assertEquals(2012, value.getYear());
		assertEquals(10, value.getMonth());
		assertEquals(12, value.getDay());
	}
	@Test
	public void testParseIlleglarOK2(){
		String source = "2012/12/1";
		LDate value = illeglarParser.parse(source);
		assertEquals(LDate.get(2012, 1, 12), value);
	}
	@Test
	public void testParseIlleglarOK3(){
		String source = "2012/1/10";
		LDate value = illeglarParser.parse(source);
		assertEquals(2012, value.getYear());
		assertEquals(10, value.getMonth());
		assertEquals(1, value.getDay());
	}
	@Test
	public void testParseIlleglarOK4(){
		String source = "2012/2/1";
		LDate value = illeglarParser.parse(source);
		assertEquals(2012, value.getYear());
		assertEquals(1, value.getMonth());
		assertEquals(2, value.getDay());
	}
}
