/**
 * 
 */
package model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author murakamitakuya
 *
 */
public class DecimalModelTest {

	@Test
	public void testGetValue() {
		DecimalModel dm = new DecimalModel();
		dm.add(BigDecimal.valueOf(500));
		BigDecimal value1 =dm.getValue();
		assertThat(value1, is(BigDecimal.valueOf(500)));
		
		dm.subtract(BigDecimal.valueOf(40.65));
		BigDecimal value2 = dm.getValue();
		assertThat(value1, is(BigDecimal.valueOf(500)));
		assertThat(value2, is(BigDecimal.valueOf(459.35d)));
	}

}
