/**
 * 
 */
package analysisTool;

/**
 * RecordPresentor
 * 
 * @author murakamitakuya
 */
public interface RecordPresentor {
	
	/**
	 * show the title
	 */
	void showTitle();

	/**
	 * Show the income amount.
	 */
	void showGeneralIncome();

	/**
	 * Show the outgo amount.
	 */
	void showGeneralOutgo();

	/**
	 * Show the detail of the income.
	 */
	void showIncomeDetail();

	/**
	 * Show the detail of the outgo.
	 */
	void showOutgoDetail();

	/**
	 * Show the general result.
	 */
	void show();
}
