package pl.expensesmanager.budget;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.util.BasicValidator;

/**
 * Validator of budget
 */
@UtilityClass
class BudgetValidator {
	
	static String validateName(String name) {
		return BasicValidator.validateText(name);
	}
	
	static Double validateBudgetValue(Double budgetValue) {
		return BasicValidator.validateDouble(budgetValue);
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
