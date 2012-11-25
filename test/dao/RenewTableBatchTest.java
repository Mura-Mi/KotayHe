/**
 * 
 */
package dao;

import org.junit.Before;
import org.junit.Test;

/**
 * @author murakamitakuya
 * 
 */
public class RenewTableBatchTest {
	private RenewTableBatch batch;

	/**
	 * 
	 */
	@Before
	public void setup() {
		this.batch = new RenewTableBatch();
	}

	@Test
	public void test() {
		batch.execute();
	}

}
