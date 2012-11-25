/**
 * 
 */
package dao.row;

import java.math.BigDecimal;

import model.InOut;
import model.LDate;

import entity.CashFlow;

/**
 * @author murakamitakuya
 * 
 */
public class CashFlowDBRow {
	private long id;
	private BigDecimal amount;
	private String inOut;
	private java.sql.Date date;
	private long categoryId;
	private String description;
	private long journalId;

	public long getId() {
		return id;
	}

	public static CashFlowDBRow assemble(CashFlow cf) {
		CashFlowDBRow row = new CashFlowDBRow();
		row.setId(cf.getId());
		row.setAmount(cf.getAmount());
		row.setInOut(cf.getInOut().getDBValue());
		row.setDate(cf.getDate().getSQLDate());
		row.setCategoryId(cf.getCategoryId());
		row.setDescription(cf.getDescription());
		row.setJournalId(cf.getJournalId());

		return row;
	}

	public CashFlow getCashFlow() {
		CashFlow cf = new CashFlow();
		cf.setId(this.getId());
		cf.setAmount(this.amount);
		cf.setInOut(InOut.getByDBValue(this.inOut));
		cf.setDate(LDate.get(this.getDate()));
		cf.setCategoryId(this.getCategoryId());
		cf.setDescription(this.getDescription());
		cf.setJournalId(this.getJournalId());

		return cf;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inout) {
		this.inOut = inout;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getJournalId() {
		return journalId;
	}

	public void setJournalId(long journalId) {
		this.journalId = journalId;
	}
}
