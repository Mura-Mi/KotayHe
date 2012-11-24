package model;

import java.math.BigDecimal;

/**
 * @author murakamitakuya
 *
 *TODO 現状では，銀行勘定のみに使っている．
 */
public abstract class Record {
	private BigDecimal amount;
	private String title;
	private LDate date;
	
	/**
	 * @param amount
	 * @param title
	 */
	public Record() {
	}
	

	/**
	 * @return
	 */
	
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 */
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	public void setAmount(long amount){
		this.amount = BigDecimal.valueOf(amount);
	}

	/**
	 * @return
	 */
	
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return date
	 */
	
	public LDate getDate() {
		return date;
	}


	/**
	 * @param date date
	 */
	
	public void setDate(LDate date) {
		this.date = date;
	}
	
}
