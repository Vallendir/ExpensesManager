package pl.expensesmanager.validate;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import static pl.expensesmanager.exception.ValidationExceptionFactory.blankTextException;

/**
 * Classto validate string value
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
