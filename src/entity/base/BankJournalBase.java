/**
 * 
 */
package entity.base;

import entity.Journal;

/**
 * @author mura_mi
 * 
 */
public class BankJournalBase extends Journal {
    private String bankName;

    public String getBankName() {
	return bankName;
    }

    public void setBankName(String bankName) {
	this.bankName = bankName;
    }
}
