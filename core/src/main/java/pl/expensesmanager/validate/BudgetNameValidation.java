package pl.expensesmanager.validate;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.exception.validation.ValidateTextException;

import static pl.expensesmanager.exception.ValidationExceptionFactory.budgetNameException;

@RequiredArgsConstructor
public class BudgetNameValidation implements ValidationStrategy {
	
	private final String value;
	
	@Override
	public void validate() {
		try {
			validate(new StringValidation(value));
		} catch (ValidateTextException exception) {
			throw budgetNameException();
		}
	}
	
}
