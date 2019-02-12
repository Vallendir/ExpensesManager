package pl.expensesmanager.util;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import pl.expensesmanager.exception.ValidationExceptionFactory;
import pl.expensesmanager.exception.validation.ValidateDateException;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateTextException;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BasicValidatorTest {
	
	@Test
	void validateText() {
		// Given
		String blankString_1 = "";
		String blankString_2 = " ";
		
		String textToEscapeHTML = "<span> Tekst ";
		String expectedTextToEscapeHTML = "&lt;span&gt; Tekst";
		
		ThrowingCallable throwable_1 = () -> BasicValidator.validateText(blankString_1);
		ThrowingCallable throwable_2 = () -> BasicValidator.validateText(blankString_2);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateTextException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.TEXT_BLANK);
		assertThatThrownBy(throwable_2).isInstanceOf(ValidateTextException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.TEXT_BLANK);
		assertThat(BasicValidator.validateText(textToEscapeHTML)).isEqualTo(expectedTextToEscapeHTML);
	}
	
	@Test
	void validateDouble() {
		// Given
		Double valueNull = null;
		Double valueNAN = Double.NaN;
		Double expectedValue = 8.13;
		
		ThrowingCallable throwable_1 = () -> BasicValidator.validateDouble(valueNull);
		ThrowingCallable throwable_2 = () -> BasicValidator.validateDouble(valueNAN);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateNumberException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.NULL_NUMBER);
		assertThatThrownBy(throwable_2).isInstanceOf(ValidateNumberException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.NUMBER_NAN);
		assertThat(BasicValidator.validateDouble(expectedValue)).isEqualTo(expectedValue);
	}
	
	@Test
	void validateInteger() {
		// Given
		Integer value = 2;
		Integer valueNull = null;
		
		ThrowingCallable throwable_1 = () -> BasicValidator.validateInteger(valueNull);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateNumberException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.NULL_NUMBER);
		assertThat(BasicValidator.validateInteger(value)).isEqualTo(value);
	}
	
	@Test
	void validateInstantDate() {
		// Given
		Instant date = Instant.now();
		Instant dateNull = null;
		
		ThrowingCallable throwable_1 = () -> BasicValidator.validateInstantDate(dateNull);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateDateException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.NULL_DATE);
		assertThat(BasicValidator.validateInstantDate(date)).isEqualTo(date);
	}
	
}