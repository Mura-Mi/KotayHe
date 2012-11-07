/**
 * 
 */
package utils;

import model.LDate;

/**
 * @author murakamitakuya TODO クソ実装だからFormatterのソースを読んでみる．
 */
public class LDateParser implements ValueParser<LDate> {
	private static final String DEFAULT_FORMAT = "yyyy/MM/dd";
	private final String format;
	private final int yyPosition;
	private final int mMPosition;
	private final int ddPosition;

	private static final LDateParser DEFAULT_PARSER = new LDateParser(
			DEFAULT_FORMAT);

	public LDateParser(String format) {
		super();
		this.format = format;
		yyPosition = format.indexOf("yyyy");
		mMPosition = format.indexOf("MM");
		ddPosition = format.indexOf("dd");
	}

	public static LDateParser getDefaultParser() {
		return DEFAULT_PARSER;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see utils.ValueParser#parse(java.lang.String)
	 */
	@Override
	public LDate parse(String source) {
		if (yyPosition == -1 || mMPosition == -1 || ddPosition == -1) {
			throw new IllegalArgumentException("the parse Format is illegal: "
					+ format);
		}

		int year, month, day;

		source = addZero(source);
		try {
			String yyString = source.substring(yyPosition, yyPosition + 4);
			year = Integer.valueOf(yyString);

			String mmString = getMMString(source);
			month = Integer.valueOf(mmString);

			String ddString = getDDString(source);
			day = Integer.valueOf(ddString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("The source was invalid: "
					+ source, e);
		}

		return LDate.get(year, month, day);
	}

	private String addZero(String source) {
		addMMZero(source);
		addDDZero(source);

		return source;
	}

	private void addMMZero(String source) {
		String mmString = getMMString(source);
		if (!mmString.matches("[0-9][0-9]")) {
			source = source.substring(0, mMPosition) + "0"
					+ source.substring(mMPosition);
		}
	}

	/**
	 * @param source
	 * @return
	 */
	private String getMMString(String source) {
		String mmString;
		if (format.indexOf("MM") + 2 >= source.length()) {
			mmString = source.substring(mMPosition - 1);
			if (mmString.contains("/")) {
				mmString = source.substring(mMPosition);
			}
		} else {
			mmString = source.substring(mMPosition, mMPosition + 2);
		}
		if (!mmString.matches("[0-9][0-9]")) {
			mmString = mmString.substring(0, 1);
		}
		return mmString;
	}

	private void addDDZero(String source) {
		String ddString = getDDString(source);
		if (!ddString.matches("[0-9][0-9]")) {
			source = source.substring(0, ddPosition) + "0"
					+ source.substring(ddPosition);
		}
	}

	/**
	 * @param source
	 * @return
	 */
	private String getDDString(String source) {
		String ddString;
		if (format.indexOf("dd") + 2 >= source.length()) {
			ddString = source.substring(ddPosition - 1);
			if (ddString.contains("/")) {
				ddString = source.substring(ddPosition);
			}
		} else {
			ddString = source.substring(ddPosition, ddPosition + 2);
		}
		if (!ddString.matches("[0-9][0-9]")) {
			ddString = ddString.substring(0, 1);
		}
		return ddString;
	}

}
