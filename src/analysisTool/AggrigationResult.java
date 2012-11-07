/**
 * 
 */
package analysisTool;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import model.IncomeRecord;
import model.IncomeRecordClassification;
import model.OutGoRecord;
import model.OutGoRecordClassification;
import model.Record;
import model.RecordClassification;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author murakamitakuya
 * 
 */
public class AggrigationResult {
	private Map<OutGoRecordClassification, List<OutGoRecord>> outgos;
	private Map<IncomeRecordClassification, List<IncomeRecord>> incomes;

	public AggrigationResult() {
		this.outgos = Maps.newHashMap();
		this.incomes = Maps.newHashMap();
	}

	/**
	 * Add the record result
	 * 
	 * @param record
	 * @return {@code true} when the adding succeed.
	 */
	public boolean addRecord(Record record) {
		if (record instanceof OutGoRecord) {
			putOutGoRecord((OutGoRecord) record);
		} else if (record instanceof IncomeRecord) {
			putIncomeRecord((IncomeRecord) record);
		} else {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	private boolean removeRecord(Record record) {
		// TODO 劣後させてるけど，いずれ実装．その後 public にする．
		return false;
	}

	/**
	 * gets the amount of income.
	 * 
	 * @return amount
	 */
	public BigDecimal getIncomeAmount() {
		BigDecimal result = BigDecimal.ZERO;
		for (RecordClassification cl : incomes.keySet()) {
			result = result.add(getAmount(cl));
		}

		return result;
	}

	/**
	 * the amount of outgo.
	 * 
	 * @return amount
	 */
	public BigDecimal getOutgoAmount() {
		BigDecimal result = BigDecimal.ZERO;
		for (RecordClassification cl : outgos.keySet()) {
			result = result.add(getAmount(cl));
		}

		return result;
	}

	/**
	 * gets the amount of the classification
	 * 
	 * @param classification
	 *            classification
	 * @return the amount;
	 */
	public BigDecimal getAmount(RecordClassification classification) {
		List<? extends Record> list = null;

		if (classification instanceof IncomeRecordClassification) {
			list = incomes.get(classification);
		} else if (classification instanceof OutGoRecordClassification) {
			list = outgos.get(classification);
		} else {
			throw new IllegalArgumentException(
					"the classification argument is illegal.");
		}

		BigDecimal result = BigDecimal.ZERO;

		for (Record r : list) {
			result = result.add(r.getAmount());
		}

		return result;
	}

	/**
	 * @return
	 */
	public Map<RecordClassification, BigDecimal> getIncomeAmountByClassification() {
		Map<RecordClassification, BigDecimal> result = Maps.newHashMap();
		for (RecordClassification cl : incomes.keySet()) {
			result.put(cl, getAmount(cl));
		}

		return result;
	}

	// TODO ていうか getIncomeAmountByClassification と
	// getOutgoAmountByClassificationって共通化できるよね．

	/**
	 * @return
	 */
	public Map<RecordClassification, BigDecimal> getOutgoAmountByClassification() {
		Map<RecordClassification, BigDecimal> result = Maps.newHashMap();
		for (RecordClassification cl : outgos.keySet()) {
			result.put(cl, getAmount(cl));
		}

		return result;
	}

	/**
	 * @param record
	 */
	private void putIncomeRecord(IncomeRecord record) {
		if (incomes.keySet().contains(record.getClassification())) {
			incomes.get(record.getClassification()).add(record);
		} else {
			incomes.put(record.getClassification(), Lists.newArrayList(record));
		}
	}

	/**
	 * @param record
	 */
	private void putOutGoRecord(OutGoRecord record) {
		if (outgos.keySet().contains(record.getClassification())) {
			outgos.get(record.getClassification()).add(record);
		} else {
			outgos.put(record.getClassification(), Lists.newArrayList(record));
		}
	}

}