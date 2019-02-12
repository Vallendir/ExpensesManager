package pl.expensesmanager.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import pl.expensesmanager.exception.validation.ValidateDateException;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateTextException;

import java.time.Instant;

import static pl.expensesmanager.exception.ValidationExceptionFactory.*;

/**
 * Basic validator of basic values.
 */
@UtilityClass
public class BasicValidator {
	
	/**
	 * Validate the passed text if is not blank and escape HTML4 characters
	 *
	 * @param text text to validate
	 * @return validated text
	 * @throws ValidateTextException if text is null
	 */
	public static String validateText(String text) {
		if (StringUtils.isBlank(text)) {
			blankTextException();
		}
		
		return StringEscapeUtils.escapeHtml4(text)
		                        .trim();
	}
	
	/**
	 * Validate the passed double value if is not NAN and not null
	 *
	 * @param value value to validate
	 * @return validated value
	 * @throws ValidateNumberException if double value is null
	 */
	public static Double validateDouble(Double value) {
		if (value == null) {
			numberNullException();
		}
		
		if (value.isNaN()) {
			numberNANException();
		}
		
		return value;
	}
	
	/**
	 * Validate the passed integer value if is not null
	 *
	 * @param value value to validate
	 * @return validated value
	 * @throws ValidateNumberException if integer value is null
	 */
	public static Integer validateInteger(Integer value) {
		if (value == null) {
			numberNullException();
		}
		
		return value;
	}
	
	/**
	 * Validate the passed date as instant value if is not null
	 *
	 * @param value date value to validate
	 * @return validated date value
	 * @throws ValidateDateException if date is null
	 */
	public static Instant validateInstantDate(Instant value) {
		if (value == null) {
			dateNullException();
		}
		
		return value;
	}
	
}
