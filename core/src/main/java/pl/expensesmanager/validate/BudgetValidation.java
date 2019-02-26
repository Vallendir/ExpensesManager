package pl.expensesmanager.validate;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.budget.Budget;

import static pl.expensesmanager.exception.ValidationExceptionFactory.budgetException;

@RequiredArgsConstructor
public class BudgetValidation implements ValidationStrategy {
	
	private final Budget value;
	
	@Override
	public void validate() {
		if (value == null) {
			throw budgetException();
		}
		
		validate(new BudgetNameValidation(value.getName()));
		validate(new BudgetValueValidation(value.getBudgetValue()));
	}
	
}
