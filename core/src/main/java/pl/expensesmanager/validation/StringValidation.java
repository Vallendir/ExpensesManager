package pl.expensesmanager.validation;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import static pl.expensesmanager.exception.ValidationExceptionFactory.blankTextException;

/**
 * Classto validation string value
 */
@RequiredArgsConstructor
public class StringValidation implements ValidationStrategy {
	
	private final String value;
	
	@Override
	public void validate() {
		if (StringUtils.isBlank(value)) {
			blankTextException();
		}
		
		if (StringUtils.isEmpty(value)) {
			blankTextException();
		}
	}
	
}
