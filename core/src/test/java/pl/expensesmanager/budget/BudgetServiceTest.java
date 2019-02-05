package pl.expensesmanager.budget;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BudgetServiceTest extends AbstractCoreTest {
	
	@Mock
	private BudgetStorePort storage;
	
	@InjectMocks
	private BudgetService service;
	
	@Test
	void searchForName() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		
		when(storage.findByName(expectedBudget_1.getName())).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		BudgetPort actualBudget = service.searchForName(expectedBudget_1.getName())
		                                 .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void searchAllForBudgetValue() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		List<BudgetPort> expectedBudgets = List.of(expectedBudget_1);
		
		when(storage.findByBudgetValue(expectedBudget_1.getBudgetValue())).thenReturn(List.of(expectedBudget_1));
		
		// When
		List<BudgetPort> actualBudget = service.searchAllForBudgetValue(expectedBudget_1.getBudgetValue());
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudgets);
	}
	
	@Test
	void searchAllForBudgetValueRange() {
		// Given
		double budgetMin = BUDGET_VALUE - 3.5;
		double budgetMax = BUDGET_VALUE + 13.5;
		
		BudgetPort expectedBudget_1 = createBudget();
		
		List<BudgetPort> expectedBudgetList = List.of(expectedBudget_1);
		
		when(storage.findByBudgetValueBetween(budgetMin, budgetMax)).thenReturn(List.of(expectedBudget_1));
		
		// When
		List<BudgetPort> actualBudget = service.searchAllForBudgetValueRange(budgetMin, budgetMax);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudgetList);
	}
	
	@Test
	void searchAllForBudgetValueGreater() {
		// Given
		double budget = BUDGET_VALUE - 3.5;
		
		BudgetPort expectedBudget_1 = createBudget();
		
		List<BudgetPort> expectedBudgetList = List.of(expectedBudget_1);
		
		when(storage.findByBudgetValueGreaterThan(budget)).thenReturn(List.of(expectedBudget_1));
		
		// When
		List<BudgetPort> actualBudget = service.searchAllForBudgetValueGreater(budget);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudgetList);
	}
	
	@Test
	void searchAllForBudgetValueLower() {
		// Given
		double budget = BUDGET_VALUE + 6.25;
		
		BudgetPort expectedBudget_1 = createBudget();
		
		List<BudgetPort> expectedBudgetList = List.of(expectedBudget_1);
		
		when(storage.findByBudgetValueLessThan(budget)).thenReturn(expectedBudgetList);
		
		// When
		List<BudgetPort> actualBudget = service.searchAllForBudgetValueLower(budget);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudgetList);
	}
	
	@Test
	void create() {
		// Given
		BudgetPort expectedToAdd = createBudget();
		
		BudgetPort expectedBudget = createBudget();
		
		when(storage.add(expectedToAdd)).thenReturn(expectedBudget);
		
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
		
		when(storage.update(expectedToChange)).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = service.update(expectedToChange);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateById() {
		// Given
		BudgetPort expectedToChange = createBudget();
		
		BudgetPort expectedChanges = createBudget(500.5);
		
		BudgetPort expectedBudget = createBudget(500.5);
		
		when(storage.update(expectedToChange.getId(), expectedChanges)).thenReturn(expectedBudget);
		
		// When
		BudgetPort actualBudget = service.update(expectedChanges, expectedToChange.getId());
		
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
		BudgetPort actualBudget = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void delete() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		
		when(storage.remove(expectedBudget_1.getId())).thenReturn(true);
		
		// When
		boolean actualBudgets = service.delete(expectedBudget_1.getId());
		
		// Then
		assertThat(actualBudgets).isTrue();
	}
	
	@Test
	void searchForId() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		
		when(storage.findById(expectedBudget_1.getId())).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		BudgetPort actualBudget = service.searchForId(expectedBudget_1.getId())
		                                 .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void searchAll() {
		// Given
		BudgetPort expectedBudget_1 = createBudget();
		BudgetPort expectedBudget_2 = createBudget();
		
		when(storage.findAll()).thenReturn(List.of(expectedBudget_1, expectedBudget_2));
		
		// When
		List<BudgetPort> actualBudgets = service.searchAll();
		
		// Then
		assertThat(actualBudgets).isEqualTo(List.of(expectedBudget_1, expectedBudget_2));
		assertThat(actualBudgets.size()).isEqualTo(2);
		assertThat(actualBudgets).containsExactlyInAnyOrder(expectedBudget_1, expectedBudget_2);
	}
	
}