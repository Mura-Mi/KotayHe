/**
 * 
 */
package model;

/**
 * @author murakamitakuya
 * 
 */
@Deprecated
public class IncomeRecord extends Record {
    private IncomeRecordClassification classification;

    /**
     * @return the classification
     */
    public IncomeRecordClassification getClassification() {
	return classification;
    }

    /**
     * @param classification
     *            the classification to set
     */
    public void setClassification(IncomeRecordClassification classification) {
	this.classification = classification;
    }

}
