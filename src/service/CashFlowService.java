/**
 * 
 */
package service;

import java.util.List;

import entity.CashFlow;

/**
 * @author murakamitakuya
 *
 */
public interface CashFlowService {
	List<CashFlow> getIncome();
	List<CashFlow> getOutgo();
	List<CashFlow> getAll();

	
}
