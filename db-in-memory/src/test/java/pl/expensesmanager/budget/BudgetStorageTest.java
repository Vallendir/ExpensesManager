package pl.expensesmanager.budget;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractDBInMemoryTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BudgetStorageTest extends AbstractDBInMemoryTest {
	
	private static final Double BUDGET_VALUE_MIN = BUDGET_VALUE - 2.75;
	
	private static final Double BUDGET_VALUE_MAX = BUDGET_VALUE + 2.95;
	
	@Mock
	private BudgetStorage storage;
	
	@Test
	void findByName() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		
		when(storage.findByName(BUDGET_NAME)).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		BudgetPort actualBudget = storage.findByName(BUDGET_NAME)
		                                 .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void findByBudgetValue() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValue(BUDGET_VALUE)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = storage.findByBudgetValue(BUDGET_VALUE);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void findByBudgetValueBetween() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueBetween(BUDGET_VALUE_MIN, BUDGET_VALUE_MAX)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = storage.findByBudgetValueBetween(BUDGET_VALUE_MIN, BUDGET_VALUE_MAX);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void findByBudgetValueGreaterThan() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueGreaterThan(BUDGET_VALUE_MIN)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = storage.findByBudgetValueGreaterThan(BUDGET_VALUE_MIN);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void findByBudgetValueLessThan() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueLessThan(BUDGET_VALUE_MAX)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = storage.findByBudgetValueLessThan(BUDGET_VALUE_MAX);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void add() {
		// Given
		BudgetPort expectedToAdd = createBudget();
		
		BudgetPort expectedBudget = createBudget();
		
		when(storage.add(expectedToAdd)).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = storage.add(expectedToAdd);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateByObject() {
		// Given
		BudgetPort expectedToChange = createBudget();
		
		BudgetPort expectedBudget = createBudget(500.5);
		
		when(storage.update(expectedToChange)).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = storage.update(expectedToChange);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateById() {
		// Given
		BudgetPort expectedChanges = createBudget(500.5);
		
		BudgetPort expectedBudget = createBudget(500.5);
		
		when(storage.update(ID, expectedChanges)).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = storage.update(ID, expectedChanges);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		BudgetPort expectedToChange = createBudget();
		
		BudgetPort expectedChanges = createBudget(500.5);
		
		BudgetPort expectedBudget = createBudget(500.5);
		
		when(storage.update(expectedToChange, expectedChanges)).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = storage.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void remove() {
		// Given
		when(storage.remove(ID)).thenReturn(true);
		
		// When
		boolean actualBudgets = storage.remove(ID);
		
		// Then
		assertThat(actualBudgets).isTrue();
	}
	
	@Test
	void findById() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		BudgetPort actualBudget = storage.findById(ID)
		                                 .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void findAll() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findAll()).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = storage.findAll();
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	private void budgetListAssertions(
		List<BudgetPort> actualBudgets, List<BudgetPort> expectedBudgets, BudgetPort expectedBudget_1,
		BudgetPort expectedBudget_2
	) {
		assertThat(actualBudgets).isEqualTo(expectedBudgets);
		assertThat(actualBudgets.size()).isEqualTo(expectedBudgets.size());
		assertThat(actualBudgets).containsExactlyInAnyOrder(expectedBudget_1, expectedBudget_2);
	}
	
}