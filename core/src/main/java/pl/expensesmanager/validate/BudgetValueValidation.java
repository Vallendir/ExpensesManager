package pl.expensesmanager.validate;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.exception.validation.ValidateNumberException;

import static pl.expensesmanager.exception.ValidationExceptionFactory.budgetValueException;

@RequiredArgsConstructor
public class BudgetValueValidation implements ValidationStrategy {
	
	private final Double value;
	
	@Override
	public void validate() {
		try {
			validate(new DoubleValidation(value));
		} catch (ValidateNumberException exception) {
			throw budgetValueException();
		}
	}
	
}
