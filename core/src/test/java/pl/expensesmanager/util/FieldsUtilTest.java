package pl.expensesmanager.util;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FieldsUtilTest {
	
	@Test
	void testReadAllNotNullFieldsNamesFromClass_okay() {
		// Given
		ClassTest expectedObject = new ClassTest();
		expectedObject.setName("NAME");
		expectedObject.setValue(null);
		
		List<String> expectedList = List.of("name");
		
		// When
		List<String> actualList = FieldsUtil.readAllNotNullFieldsNamesFromClass(expectedObject);
		
		
		// Then
		assertThat(actualList).containsExactlyElementsOf(expectedList);
	}
	
	@Test
	void testReadAllNotNullFieldsNamesFromClass_allNullEmptyList() {
		// Given
		ClassTest expectedObject = new ClassTest();
		expectedObject.setName(null);
		expectedObject.setValue(null);
		
		List<String> expectedList = List.of();
		
		// When
		List<String> actualList = FieldsUtil.readAllNotNullFieldsNamesFromClass(expectedObject);
		
		
		// Then
		assertThat(actualList).containsExactlyElementsOf(expectedList);
	}
	
	@Test
	void readFormatedNotNullFields_okay() {
		// Given
		ClassTest expectedObject = new ClassTest();
		expectedObject.setName("Name");
		expectedObject.setValue(1);
		
		String expectedPrefix = "[PREFIX]";
		String expectedFormatedText =
			expectedPrefix + "[name -> " + expectedObject.getName() + "][value -> " + expectedObject.getValue() + "]";
		
		// When
		String actualFormatedText = FieldsUtil.readFormatedNotNullFields(expectedObject, expectedPrefix);
		
		// Then
		assertThat(actualFormatedText).isEqualTo(expectedFormatedText);
	}
	
	@Getter
	@Setter
	private static class ClassTest {
		
		private String name;
		
		private Integer value;
		
	}
	
}