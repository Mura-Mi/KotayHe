/**
 * 
 */
package utils;

/**
 * @author murakamitakuya
 * 
 */
public class NameParser {
	private static final NameParser DEFAULT_PARSER = new NameParser();

	public static NameParser getDefaultParser() {
		return DEFAULT_PARSER;
	}

	public String getSQLName(String className) {
		StringBuilder builder = new StringBuilder(className);
		for (int i = 1; i < builder.length(); i++) {
			boolean isUnderScore = builder.substring(i,i+1).equals("_");
			boolean isHeadOfWord = builder.substring(i-1, i+1).matches("_[A-Z]");
			boolean isBigCamelWord = builder.substring(i-1, Math.min(i+2, builder.length())).matches("[A-Z]{3}");
			if(isUnderScore ||isHeadOfWord||isBigCamelWord ){
				continue;
			}
			
			if (builder.substring(i, i + 1).matches("[A-Z]")) {
				builder.insert(i, '_');
			}
		}

		return builder.toString().toUpperCase();
	}
}
