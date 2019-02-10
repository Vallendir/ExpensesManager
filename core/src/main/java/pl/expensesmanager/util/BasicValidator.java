package pl.expensesmanager.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import java.time.Instant;

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
	 */
	public static String validateText(String text) {
		if (StringUtils.isBlank(text)) {
			throw new RuntimeException();
		}
		
		return StringEscapeUtils.escapeHtml4(text)
		                        .trim();
	}
	
	/**
	 * Validate the passed double value if is not NAN and not null
	 *
	 * @param value value to validate
	 * @return validated value
	 */
	public static Double validateDouble(Double value) {
		if (value.isNaN() || value == null) {
			throw new RuntimeException();
		}
		
		return value;
	}
	
	/**
	 * Validate the passed integer value if is not null
	 *
	 * @param value value to validate
	 * @return validated value
	 */
	public static Integer validateInteger(Integer value) {
		if (value == null) {
			throw new RuntimeException();
		}
		
		return value;
	}
	
	/**
	 * Validate the passed date as instant value if is not null
	 *
	 * @param value date value to validate
	 * @return validated date value
	 */
	public static Instant validateInstantDate(Instant value) {
		if (value == null) {
			throw new RuntimeException();
		}
		
		return value;
	}
	
}
