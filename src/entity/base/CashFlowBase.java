/**
 * 
 */
package entity.base;

import java.math.BigDecimal;

import model.InOut;
import model.LDate;

/**
 * @author murakamitakuya
 * 
 */
public class CashFlowBase {

    private Long id;
    private BigDecimal amount;
    private InOut inOut;
    private LDate date;
    private Long categoryId;
    private String description;
    private Long journalId;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public BigDecimal getAmount() {
	return amount;
    }

    public void setAmount(BigDecimal amount) {
	this.amount = amount;
    }

    public InOut getInOut() {
	return inOut;
    }

    public void setInOut(InOut inOut) {
	this.inOut = inOut;
    }

    public LDate getDate() {
	return date;
    }

    public void setDate(LDate date) {
	this.date = date;
    }

    public Long getCategoryId() {
	return categoryId;
    }

    public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Long getJournalId() {
	return journalId;
    }

    public void setJournalId(Long journalId) {
	this.journalId = journalId;
    }

}
