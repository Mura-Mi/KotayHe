package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

// TODO 綺麗に値を取得する方法ないかな．
public class CSVReader {

	private static final String DEFALUT_DELIMITER = ",";
	private BufferedReader csvFileReader;
	@SuppressWarnings("unused")
	private int i;
	private String delimiter;

	/**
	 * Constructor
	 * 
	 * @param filename
	 *            File Name
	 * @throws FileNotFoundException
	 *             when the designated file was not found.
	 */
	private CSVReader(String filename) throws FileNotFoundException {
		this(filename, DEFALUT_DELIMITER);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param filename
	 *            File Name
	 * @param delimiter
	 *            delimiter
	 * @throws FileNotFoundException
	 *             when the designated file was not found.
	 */
	private CSVReader(String filename, String delimiter)
			throws FileNotFoundException {
		Reader r = new FileReader(filename);
		this.csvFileReader = new BufferedReader(r);
		this.delimiter = delimiter;
		i = 0;
	}

	public static CSVReader getInstance(String filename)
			throws FileNotFoundException {
		return new CSVReader(filename);
	}

	public static CSVReader getInstance(String filename, String delimiter)
			throws FileNotFoundException {
		return new CSVReader(filename, delimiter);
	}

	/**
	 * 行を読み込みます．
	 * 
	 * @return
	 */
	public String[] readRecord() {
		String record = null;
		try {
			record = csvFileReader.readLine();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		if (record != null) {
			try {
				record = new String(record.getBytes("UTF8"), "UTF8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return modifyValues(record.split(delimiter));
		} else {
			return null;
		}
	}

	public void close() {
		if (csvFileReader != null) {
			try {
				csvFileReader.close();
			} catch (IOException e) {
				// quietly close.
			}

		}
	}

	/**
	 * @param values
	 * @return
	 */
	private String[] modifyValues(String[] values) {

		List<ValueType> valueTypes = generateValueType(values);

		List<String> resultList = Lists.newArrayList();

		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			switch (valueTypes.get(i)) {
			case COMPLETE:
				resultList.add(value.substring(1, value.length() - 1));
				break;
			case NULL:
				resultList.add("");
				break;
			case START:
				StringBuilder builder = new StringBuilder(value.substring(1));
				L1: for (int j = i + 1; j < values.length; j++) {
					ValueType type = valueTypes.get(j);
					if (type == ValueType.END) {
						builder.append(values[j].substring(0,
								values[j].length() - 1));
						break L1;
					} else {
						builder.append(values[j]);

					}
				}
				resultList.add(builder.toString());
				break;
			default:
				break;
			}
		}

		return resultList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
	}

	/**
	 * @param values
	 * @return
	 */
	private List<ValueType> generateValueType(String[] values) {
		List<ValueType> valueTypes = Lists.newArrayList();
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			boolean startWithQuatation = value.startsWith("\"");
			boolean endWithQuatation = value.endsWith("\"");
			if (StringUtils.isBlank(value)) {
				valueTypes.add(i, ValueType.NULL);
			} else if (startWithQuatation && endWithQuatation) {
				valueTypes.add(i, ValueType.COMPLETE);
			} else if (startWithQuatation && !endWithQuatation) {
				valueTypes.add(i, ValueType.START);
			} else if (!startWithQuatation && endWithQuatation) {
				valueTypes.add(i, ValueType.END);
			} else {
				valueTypes.add(i, ValueType.PLAIN);
			}
		}
		return valueTypes;
	}

	private enum ValueType {
		COMPLETE, START, PLAIN, END, NULL;
	}
}
