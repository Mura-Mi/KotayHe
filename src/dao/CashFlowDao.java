/**
 * 
 */
package dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.InOut;
import model.LDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.row.CashFlowDBRow;
import entity.CashFlow;
import exception.KotayHeRuntimeException;

/**
 * @author murakamitakuya
 * 
 */
public class CashFlowDao extends AbstractDao<CashFlow> {

	private static final CashFlowDao INSTANCE = new CashFlowDao();

	private CashFlowDao() {
		super();
	}

	public static CashFlowDao getInstance() {
		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.AbstractDao#findByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public CashFlow findByPrimaryKey(Serializable pk) {
		if (!(pk instanceof Long)) {
			throw new IllegalArgumentException("The primary key must be Long.");
		}

		PreparedStatement statement = null;
		try {
			statement = getConnection().prepareStatement(findByPkQuery);
			statement.setString(1, "CASH_FLOW");
			statement.setString(2, "id");
			statement.setLong(3, (Long) pk);
		} catch (SQLException e) {
			throw new KotayHeRuntimeException("Can't generate query.", e);
		}

		CashFlow cf = new CashFlow();
		try {
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				cf.setId(result.getLong("id"));
				cf.setAmount(result.getBigDecimal("amount"));
				cf.setDate(LDate.get(result.getDate("date")));
				cf.setInOut(InOut.getByDBValue(result.getString("inOut")));
				cf.setDescription(result.getString("description"));
				cf.setJournalId(result.getLong("journalId"));
				cf.setCategoryId(result.getLong("categoryId"));

			} else {
				return null;
			}

			if (result.next()) {
				throw new KotayHeRuntimeException(
						"The Query Result was not unique.");
			}
		} catch (SQLException e) {
			throw new KotayHeRuntimeException(e);
		}

		return cf;
	}

	public List<CashFlow> get(InOut inOut) {
		// TODO auto generated.
		return null;
	}

	public void saveOrUpdate(CashFlow cashFlow) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		CashFlowDBRow row = CashFlowDBRow.assemble(cashFlow);

		session.saveOrUpdate(row);

		transaction.commit();

		session.close();
	}

}
