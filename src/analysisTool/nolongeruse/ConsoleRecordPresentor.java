/**
 * 
 */
package analysisTool.nolongeruse;

import analysisTool.AggrigationResult;

/**
 * @author murakamitakuya TODO String#Format を使う．
 * 
 */
@Deprecated
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
    }

    /*
     * (non-Javadoc)
     * 
     * @see analysisTool.RecordPresentor#showOutgoDetail()
     */
    @Override
    public void showOutgoDetail() {
	System.out.println("The Detail Of outgo");

    }

    /*
     * (non-Javadoc)
     * 
     * @see analysisTool.RecordPresentor#showTitle()
     */
    @Override
    public void showTitle() {
	System.out.println("The Income/Outgo record");
    }

}
