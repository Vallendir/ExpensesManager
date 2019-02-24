package pl.expensesmanager.budget;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateTextException;
import pl.expensesmanager.util.BasicValidator;

import static pl.expensesmanager.exception.ValidationExceptionFactory.*;

/**
 * Validator of budget
 */
@UtilityClass
class BudgetValidator {
	
	static String validateName(String name) {
		try {
			return BasicValidator.validateText(name);
		} catch (ValidateTextException exception) {
			throw budgetNameException();
		}
	}
	
	static Double validateBudgetValue(Double budgetValue) {
		try {
			return BasicValidator.validateDouble(budgetValue);
		} catch (ValidateNumberException exception) {
			throw budgetValueException();
		}
	}
	
	static Budget validateBudget(Budget budget) {
		if (budget == null) {
			throw budgetException();
		}
		
		validateName(budget.getName());
		validateBudgetValue(budget.getBudgetValue());
		
		return budget;
	}
	
}
