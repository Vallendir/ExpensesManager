package pl.expensesmanager.validate;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.exception.validation.ValidateTextException;

import static pl.expensesmanager.exception.ValidationExceptionFactory.billOfSaleDescriptionException;

@RequiredArgsConstructor
public class BillOfSaleDescriptionValidation implements ValidationStrategy {
	
	private final String value;
	
	@Override
	public void validate() {
		try {
			validate(new StringValidation(value));
		} catch (ValidateTextException exception) {
			throw billOfSaleDescriptionException();
		}
	}
	
}
