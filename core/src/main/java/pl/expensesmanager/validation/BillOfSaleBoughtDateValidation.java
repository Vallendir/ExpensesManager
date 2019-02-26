package pl.expensesmanager.validation;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.exception.validation.ValidateDateException;

import java.time.Instant;

import static pl.expensesmanager.exception.ValidationExceptionFactory.dateNullException;

@RequiredArgsConstructor
public class BillOfSaleBoughtDateValidation implements ValidationStrategy {
	
	private final Instant value;
	
	@Override
	public void validate() {
		try {
			validate(new InstantValidation(value));
		} catch (ValidateDateException exception) {
			throw dateNullException();
		}
	}
	
}
