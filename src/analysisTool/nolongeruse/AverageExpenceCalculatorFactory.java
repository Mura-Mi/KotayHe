/**
 * 
 */
package analysisTool.nolongeruse;

import java.math.BigDecimal;
import java.util.List;

import analysisTool.AverageBudgetCalculator;

import model.DecimalModel;
import model.LDate;
import model.Period;
import service.CashFlowService;
import entity.CashFlow;

/**
 * @author murakamitakuya
 * 
 */
public class AverageExpenceCalculatorFactory {
	private CashFlowService cashFlowService;

	public AverageExpenceCalculatorFactory(CashFlowService cashFlowService) {
		this.cashFlowService = cashFlowService;
	}

	public AverageBudgetCalculator getCalculator(LDate from, LDate to) {
		return new AverageBudgetCalculatorImpl(from, to);
	}

	public AverageBudgetCalculator getCalculator(Period period) {
		return new AverageBudgetCalculatorImpl(period.getFrom(),
				period.getTo());
	}

	/**
	 * @author murakamitakuya
	 * 
	 */
	class AverageBudgetCalculatorImpl implements AverageBudgetCalculator {

		private LDate from;
		private LDate to;

		/**
		 * @param from
		 *            from
		 * @param to
		 *            to
		 */
		AverageBudgetCalculatorImpl(LDate from, LDate to) {
			this.from = from;
			this.to = to;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see analysisTool.AverageExpenceCalculator#getDailyBudget()
		 */
		@Override
		public BigDecimal getDailyBudget(Period period) {
			int dayCount = to.getDaysCount(from);
			
			return aggregateIncome().divide(BigDecimal.valueOf(dayCount));
		}

		private BigDecimal aggregateIncome() {
			List<CashFlow> incomeCashFlows = cashFlowService.getIncome();
			
			DecimalModel decimalModel= new DecimalModel();
			for(CashFlow cf:incomeCashFlows){
				decimalModel.add(cf.getAmount());
			}
			
			return decimalModel.getValue();
		}

		@SuppressWarnings("unused")
		private BigDecimal aggregateOutgo() {
			return null;
		}

	}

}
