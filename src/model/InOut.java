/**
 * 
 */
package model;

/**
 * @author murakamitakuya
 * 
 */
public enum InOut {
	/**
	 * Income(0)
	 */
	IN(0),
	/**
	 * outgoing(1)
	 */
	OUT(1);

	private int dbValue;

	private InOut(int dbValue) {
		this.dbValue = dbValue;
	}
	
	public static InOut getByDBValue(int i){
		for(InOut e:values()){
			if(i == e.getDBValue()){
				return e;
			}
		}
		throw new IllegalArgumentException("input must be 0 or 1.");
	}
	
	public int getDBValue(){
		return this.dbValue;
	}
}
