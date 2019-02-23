package pl.expensesmanager.budget;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BudgetServiceTest extends AbstractCoreTest {
	
	private static final Double BUDGET_VALUE_MIN = BUDGET_VALUE - 2.25;
	
	private static final Double BUDGET_VALUE_MAX = BUDGET_VALUE + 2.25;
	
	@Mock
	private BudgetStorePort storage;
	
	@InjectMocks
	private BudgetService service;
	
	@Test
	void searchForName() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		
		when(storage.findByName(BUDGET_NAME)).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		BudgetPort actualBudget = service.searchForName(BUDGET_NAME)
		                                 .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void searchAllForBudgetValue() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValue(BUDGET_VALUE)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = service.searchAllForBudgetValue(BUDGET_VALUE);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void searchAllForBudgetValueRange() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueBetween(BUDGET_VALUE_MIN, BUDGET_VALUE_MAX)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = service.searchAllForBudgetValueRange(BUDGET_VALUE_MIN, BUDGET_VALUE_MAX);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void searchAllForBudgetValueGreater() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueGreaterThan(BUDGET_VALUE_MIN)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = service.searchAllForBudgetValueGreater(BUDGET_VALUE_MIN);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void searchAllForBudgetValueLower() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueLessThan(BUDGET_VALUE_MAX)).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = service.searchAllForBudgetValueLower(BUDGET_VALUE_MAX);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void create() {
		// Given
		BudgetPort expectedToAdd = createBudget();
		BudgetPort expectedBudget = createBudget();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = service.create(expectedToAdd);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateByObject() {
		// Given
		BudgetPort expectedToChange = createBudget();
		BudgetPort expectedBudget = createBudget(500.5);
		
		when(storage.save(expectedToChange)).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = service.update(expectedToChange);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateById() {
		// Given
		BudgetPort expectedChanges = createBudget(500.5);
		BudgetPort expectedBudget = createBudget();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBudget));
		when(storage.save(MergeUtil.merge(expectedChanges, expectedChanges))).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = service.update(expectedChanges, ID);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		BudgetPort expectedToChange = createBudget();
		BudgetPort expectedChanges = createBudget(500.5);
		BudgetPort expectedBudget = createBudget(500.5);
		
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void searchForId() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		BudgetPort actualBudget = service.searchForId(ID)
		                                 .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void searchAll() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findAll()).thenReturn(expectedBudgets);
		
		// When
		List<BudgetPort> actualBudgets = service.searchAll();
		
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