package pl.expensesmanager.validate;

import lombok.RequiredArgsConstructor;

import java.time.Instant;

import static pl.expensesmanager.exception.ValidationExceptionFactory.dateNullException;

/**
 * Classto validate Instant value.
 */
@RequiredArgsConstructor
public class InstantValidation implements ValidationStrategy {
	
	private final Instant value;
	
	@Override
	public void validate() {
		if (value == null) {
			dateNullException();
		}
	}
	
}
