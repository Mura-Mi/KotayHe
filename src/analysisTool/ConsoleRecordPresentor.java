/**
 * 
 */
package analysisTool;

import java.math.BigDecimal;
import java.util.Map;

import model.RecordClassification;

/**
 * @author murakamitakuya
 * TODO String#Format を使う．
 * 
 */
public class ConsoleRecordPresentor extends AbstractRecordPresentor {
	private AggrigationResult result;

	public ConsoleRecordPresentor(AggrigationResult result) {
		this.result = result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see analysisTool.RecordPresentor#showGeneralIncome()
	 */
	@Override
	public void showGeneralIncome() {
		System.out.println("Income:\t" + result.getIncomeAmount());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see analysisTool.RecordPresentor#showGeneralOutgo()
	 */
	@Override
	public void showGeneralOutgo() {
		System.out.println("Outgo:\t" + result.getOutgoAmount());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see analysisTool.RecordPresentor#showIncomeDetail()
	 */
	@Override
	public void showIncomeDetail() {
		System.out.println("The Detail Of income");
		Map<RecordClassification, BigDecimal> map = result
				.getIncomeAmountByClassification();

		for (RecordClassification cl : map.keySet()) {
			System.out.println(cl.getName() + ":\t" + map.get(cl));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see analysisTool.RecordPresentor#showOutgoDetail()
	 */
	@Override
	public void showOutgoDetail() {
		System.out.println("The Detail Of outgo");
		Map<RecordClassification, BigDecimal> map = result
				.getOutgoAmountByClassification();
		
		for(RecordClassification cl:map.keySet()){
			System.out.println(cl.getName()+":\t"+map.get(cl));
		}
	}

	/* (non-Javadoc)
	 * @see analysisTool.RecordPresentor#showTitle()
	 */
	@Override
	public void showTitle() {
		System.out.println("The Income/Outgo record");
	}

}
