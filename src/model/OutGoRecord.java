/**
 * 
 */
package model;

/**
 * @author murakamitakuya
 * 
 */
@Deprecated
public class OutGoRecord extends Record {
    private OutGoRecordClassification classification;

    /**
     * @return the classification
     */
    public OutGoRecordClassification getClassification() {
	return classification;
    }

    /**
     * @param classification
     *            the classification to set
     */
    public void setClassification(OutGoRecordClassification classification) {
	this.classification = classification;
    }

}