package model;


public class Period {
	private LDate from;
	private LDate to;
	
	private Period(LDate from, LDate to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public static Period of(LDate from, LDate to){
		return new Period(from, to);
	}

	public LDate getFrom() {
		return from;
	}

	public LDate getTo() {
		return to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Period other = (Period) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	/**
	 * @param date
	 * @return
	 */
	public boolean contains(LDate date) {
		return date.ge(from) && date.le(to);
	}
	
}
