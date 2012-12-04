/**
 * 
 */
package entity.base;

import entity.CashFlow;

/**
 * @author mura_mi
 * 
 */
public class BankCashFlowBase extends CashFlow {
    private String bankName;

    public String getBankName() {
	return bankName;
    }

    public void setBankName(String bankName) {
	this.bankName = bankName;
    }

}
