/**
 * 
 */
package model;

import java.math.BigDecimal;

/**
 * @author murakamitakuya
 * 
 */
public class DecimalModel {
	private BigDecimal decimal;

	/**
	 * 
	 */
	public DecimalModel() {
		this.decimal = BigDecimal.ZERO;
	}

	/**
	 * @param decimal
	 */
	public DecimalModel(BigDecimal decimal) {
		this.decimal = decimal;
	}

	public BigDecimal getValue() {
		return new BigDecimal(decimal.toString());
	}

	public void add(BigDecimal value) {
		this.decimal = decimal.add(value);
	}

	public void subtract(BigDecimal value) {
		this.decimal = decimal.subtract(value);
	}

	public void multiple(BigDecimal value) {
		this.decimal = decimal.multiply(value);
	}

	public void divide(BigDecimal value) {
		this.decimal = decimal.divide(value);
	}
}
