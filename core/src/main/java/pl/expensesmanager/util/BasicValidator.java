package pl.expensesmanager.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import pl.expensesmanager.base.IdValidatorPort;
import pl.expensesmanager.exception.business.PassedValueIsInvalidException;
import pl.expensesmanager.exception.validation.ValidateDateException;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateTextException;

import java.time.Instant;
import java.util.Objects;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.minBiggerThanMaxException;
import static pl.expensesmanager.exception.ValidationExceptionFactory.*;

/**
 * Basic validator of basic values.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BasicValidator {
	
	/**
	 * Validate the passed text if is not blank
	 *
	 * @param text text to validate
	 * @return validated text
	 * @throws ValidateTextException if text is null
	 */
	public static String validateText(String text) {
		if (StringUtils.isBlank(text)) {
			blankTextException();
		}
		
		return text.trim();
	}
	
	/**
	 * Validate the passed double value if is not NAN and not null
	 *
	 * @param value value to validate
	 * @return validated value
	 * @throws ValidateNumberException if double value is null
	 */
	public static Double validateDouble(Double value) {
		if (Objects.isNull(value)) {
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
		if (Objects.isNull(value)) {
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
		if (Objects.isNull(value)) {
			dateNullException();
		}
		
		return value;
	}
	
	/**
	 * Validate passed values if the minimum value is bigger than maximum
	 *
	 * @param min min value
	 * @param max value
	 * @throws PassedValueIsInvalidException if min value is bigger than max
	 */
	public static void validateMinMaxValue(Double min, Double max) {
		if (min > max) {
			throw minBiggerThanMaxException();
		}
	}
	
	/**
	 * Validate passed values if the minimum value is bigger than maximum
	 *
	 * @param min min value
	 * @param max value
	 * @throws PassedValueIsInvalidException if min value is bigger than max
	 */
	public static void validateMinMaxValue(Integer min, Integer max) {
		if (min > max) {
			throw minBiggerThanMaxException();
		}
	}
	
	/**
	 * Validate if the minimal date is after the maximum date
	 *
	 * @param min min date
	 * @param max date
	 * @throws PassedValueIsInvalidException if min date is bigger than max
	 */
	public static void validateMinMaxValue(Instant min, Instant max) {
		if (min.isAfter(max)) {
			throw minBiggerThanMaxException();
		}
	}
	
	/**
	 * Validate if given id has valid format
	 *
	 * @param validator port of specific implementation of id validation
	 * @param id        identificator to validate
	 */
	public static void checkIfGivenIdIsValid(IdValidatorPort validator, String id) {
		if (!validator.isValid(id)) {
			throw invalidIdFormatException();
		}
	}
	
}
