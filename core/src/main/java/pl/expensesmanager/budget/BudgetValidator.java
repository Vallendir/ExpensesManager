package pl.expensesmanager.budget;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

@UtilityClass
class BudgetValidator {
	
	static String validateName(String name) {
		if (StringUtils.isBlank(name)) {
			throw new RuntimeException();
		}
		
		return StringEscapeUtils.escapeHtml4(name)
		                        .trim();
	}
	
	static Double validateBudgetValue(Double budgetValue) {
		if (budgetValue.isNaN() || budgetValue == null) {
			throw new RuntimeException();
		}
		
		return budgetValue;
	}
	
	static BudgetPort validateBudget(BudgetPort budget) {
		if (budget == null) {
			throw new RuntimeException();
		}
		
		validateName(budget.getName());
		validateBudgetValue(budget.getBudgetValue());
		
		return budget;
	}
	
}
