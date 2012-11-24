/**
 * 
 */
package model;

/**
 * @author murakamitakuya
 * 
 */
public enum InOut  {
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
	
	public static InOut getByDBValue(String i){
		for(InOut e:values()){
			if(i == e.getDBValue()){
				return e;
			}
		}
		throw new IllegalArgumentException("input must be \"i\" or \"o\".");
	}
	
	public String getDBValue(){
		return this.dbValue;
	}
}
