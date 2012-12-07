/**
 * 
 */
package analysisTool.nolongeruse;


/**
 * @author murakamitakuya
 *
 */
public abstract class AbstractRecordPresentor implements RecordPresentor {

	@Override
	public void show(){
		showTitle();
		System.out.println();
		showGeneralIncome();
		showGeneralOutgo();
		System.out.println();
		showIncomeDetail();
		System.out.println();
		showOutgoDetail();
	}

}
