/**
 * 
 */
package model;

import org.apache.commons.lang3.ObjectUtils;

/**
 * @author murakamitakuya
 * 
 */
public enum InOut {
	/**
	 * Income(0)
	 */
	IN("i"),
	/**
	 * outgoing(1)
	 */
	OUT("o");

	private String dbValue;

	private InOut(String dbValue) {
		this.dbValue = dbValue;
	}

	public static InOut getByDBValue(String i) {
		for (InOut e : values()) {
			if (ObjectUtils.equals(i, e.getDBValue())) {
				return e;
			}
		}
		return null;
	}

	public String getDBValue() {
		return this.dbValue;
	}
}
