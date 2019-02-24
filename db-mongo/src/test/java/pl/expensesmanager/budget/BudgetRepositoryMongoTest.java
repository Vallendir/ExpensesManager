package pl.expensesmanager.budget;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractMongoDBTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BudgetRepositoryMongoTest extends AbstractMongoDBTest {
	
	private static final Double BUDGET_VALUE_MIN = BUDGET_VALUE - 2.55;
	
	private static final Double BUDGET_VALUE_MAX = BUDGET_VALUE + 2.75;
	
	@Mock
	private BudgetRepositoryMongo storage;
	
	@Test
	void findByName() {
		// Given
		BudgetDocument expectedBudget_1 = createBudget();
		
		when(storage.findByName(BUDGET_NAME)).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		BudgetDocument actualBudget = storage.findByName(BUDGET_NAME)
		                                     .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void findByBudgetValue() {
		// Given
		BudgetDocument expectedBudget_1 = createBudget();
		BudgetDocument expectedBudget_2 = createBudget();
		
		List<BudgetDocument> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValue(BUDGET_VALUE)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetDocument> actualBudgets = storage.findByBudgetValue(BUDGET_VALUE);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void findByBudgetValueBetween() {
		// Given
		BudgetDocument expectedBudget_1 = createBudget();
		BudgetDocument expectedBudget_2 = createBudget();
		
		List<BudgetDocument> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueBetween(BUDGET_VALUE_MIN, BUDGET_VALUE_MAX)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetDocument> actualBudgets = storage.findByBudgetValueBetween(BUDGET_VALUE_MIN, BUDGET_VALUE_MAX);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void findByBudgetValueGreaterThan() {
		// Given
		BudgetDocument expectedBudget_1 = createBudget();
		BudgetDocument expectedBudget_2 = createBudget();
		
		List<BudgetDocument> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueGreaterThan(BUDGET_VALUE_MIN)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetDocument> actualBudgets = storage.findByBudgetValueGreaterThan(BUDGET_VALUE_MIN);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void findByBudgetValueLessThan() {
		// Given
		BudgetDocument expectedBudget_1 = createBudget();
		BudgetDocument expectedBudget_2 = createBudget();
		
		List<BudgetDocument> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueLessThan(BUDGET_VALUE_MAX)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetDocument> actualBudgets = storage.findByBudgetValueLessThan(BUDGET_VALUE_MAX);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void add() {
		// Given
		BudgetDocument expectedToAdd = createBudget();
		
		BudgetDocument expectedBudget = createBudget();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedBudget);
		
		// When
		BudgetDocument actualBudget = storage.save(expectedToAdd);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void findById() {
		// Given
		BudgetDocument expectedBudget_1 = createBudget();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		BudgetDocument actualBudget = storage.findById(ID)
		                                     .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void findAll() {
		// Given
		BudgetDocument expectedBudget_1 = createBudget();
		BudgetDocument expectedBudget_2 = createBudget();
		
		List<BudgetDocument> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findAll()).thenReturn(expectedBudgets);
		
		// When
		List<BudgetDocument> actualBudgets = storage.findAll();
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	private void budgetListAssertions(
		List<BudgetDocument> actualBudgets, List<BudgetDocument> expectedBudgets, BudgetDocument expectedBudget_1,
		BudgetDocument expectedBudget_2
	) {
		assertThat(actualBudgets).isEqualTo(expectedBudgets);
		assertThat(actualBudgets.size()).isEqualTo(expectedBudgets.size());
		assertThat(actualBudgets).containsExactlyInAnyOrder(expectedBudget_1, expectedBudget_2);
	}
	
}
