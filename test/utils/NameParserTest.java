/**
 * 
 */
package utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Test;

/**
 * @author murakamitakuya
 *
 */
public class NameParserTest {
	private NameParser parser;
	
	@After
	public void trancate(){
		 parser = null;
	}

	/**
	 * SQL 名への変換確認
	 */
	@Test
	public void testGetSQLNameOK1() {
		parser = NameParser.getDefaultParser()	;
		
		String name = "MyNameIsMuraMi";
		
		assertThat(parser.getSQLName(name), is("MY_NAME_IS_MURA_MI"));
	}
	
	/**
	 *  大文字で出来た単語も適切に変換されることの確認
	 */
	@Test
	public void testGetSQLNameOK2(){
		parser = NameParser.getDefaultParser();
		
		String name = "ThisIsSQLWord";
		
		assertThat(parser.getSQLName(name), is("THIS_IS_SQL_WORD"));
	}

}
