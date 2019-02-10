package pl.expensesmanager.util;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicValidatorTest {
	
	@Test
	void validateText() {
		// Given
		String blankString_1 = "";
		String blankString_2 = " ";
		
		String textToEscapeHTML = "<span> Tekst ";
		String expectedTextToEscapeHTML = "&lt;span&gt; Tekst";
		
		// Then
		assertThrows(RuntimeException.class, () -> BasicValidator.validateText(blankString_1));
		assertThrows(RuntimeException.class, () -> BasicValidator.validateText(blankString_2));
		assertThat(BasicValidator.validateText(textToEscapeHTML)).isEqualTo(expectedTextToEscapeHTML);
	}
	
	@Test
	void validateDouble() {
		// Given
		Double valueNull = null;
		Double valueNAN = Double.NaN;
		Double expectedValue = 8.13;
		
		// Then
		assertThrows(RuntimeException.class, () -> BasicValidator.validateDouble(valueNull));
		assertThrows(RuntimeException.class, () -> BasicValidator.validateDouble(valueNAN));
		assertThat(BasicValidator.validateDouble(expectedValue)).isEqualTo(expectedValue);
	}
	
	@Test
	void validateInteger() {
		// Given
		Integer value = 2;
		Integer valueNull = null;
		
		// Then
		assertThrows(RuntimeException.class, () -> BasicValidator.validateInteger(valueNull));
		assertThat(BasicValidator.validateInteger(value)).isEqualTo(value);
	}
	
	@Test
	void validateInstantDate() {
		// Given
		Instant date = Instant.now();
		Instant dateNull = null;
		
		// Then
		assertThrows(RuntimeException.class, () -> BasicValidator.validateInstantDate(dateNull));
		assertThat(BasicValidator.validateInstantDate(date)).isEqualTo(date);
	}
	
}