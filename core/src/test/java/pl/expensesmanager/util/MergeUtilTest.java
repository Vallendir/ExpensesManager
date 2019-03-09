package pl.expensesmanager.util;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeUtilTest {
	
	@Test
	void testMerge_okay() {
		// Given
		ClassTest expectedObject = new ClassTest();
		expectedObject.setName("NAME_2");
		
		ClassTest expectedChanges = new ClassTest();
		expectedChanges.setValue(5);
		
		ClassTest expectedMerged = new ClassTest();
		expectedMerged.setName("NAME_2");
		expectedMerged.setValue(5);
		
		// When
		ClassTest actualMergedObject = MergeUtil.merge(expectedObject, expectedChanges);
		
		// Then
		assertThat(actualMergedObject.getName()).isEqualTo(expectedObject.getName());
		assertThat(actualMergedObject.getValue()).isEqualTo(expectedChanges.getValue());
		assertThat(actualMergedObject.getName()).isEqualTo(expectedMerged.getName());
		assertThat(actualMergedObject.getValue()).isEqualTo(expectedMerged.getValue());
	}
	
	@Getter
	@Setter
	private static class ClassTest {
		
		private String name;
		
		private Integer value;
		
	}
	
}