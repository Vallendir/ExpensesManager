package pl.expensesmanager.budget;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.BusinessLogicExceptionFactory;
import pl.expensesmanager.exception.ValidationExceptionFactory;
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
		Budget expectedBudget_1 = createBudget();
		
		when(storage.findByName(BUDGET_NAME)).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		Budget actualBudget = service.searchByName(BUDGET_NAME)
		                             .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void searchAllForBudgetValue() {
		// Given
		Budget expectedBudget_1 = createBudget();
		Budget expectedBudget_2 = createBudget();
		
		List<Budget> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValue(BUDGET_VALUE)).thenReturn(expectedBudgets);
		
		// When
		List<Budget> actualBudgets = service.searchAllByValue(BUDGET_VALUE);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void searchAllForBudgetValueRange() {
		// Given
		Budget expectedBudget_1 = createBudget();
		Budget expectedBudget_2 = createBudget();
		
		List<Budget> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueBetween(BUDGET_VALUE_MIN, BUDGET_VALUE_MAX)).thenReturn(expectedBudgets);
		
		// When
		List<Budget> actualBudgets = service.searchAllByValueRange(BUDGET_VALUE_MIN, BUDGET_VALUE_MAX);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void searchAllForBoughtDateRange_throwMinIsBiggerThanMax() {
		// Then
		ThrowableAssert.ThrowingCallable throwable = () -> service.searchAllByValueRange(
			BUDGET_VALUE_MAX, BUDGET_VALUE_MIN);
		
		// Then
		assertThatThrownByPassedValueIsInvalidException(throwable,
		                                                BusinessLogicExceptionFactory.ExceptionMessage.MIN_BIGGER_THAN_MAX,
		                                                BusinessLogicExceptionFactory.ErrorCode.MIN_BIGGER_THAN_MAX
		);
	}
	
	@Test
	void searchAllForBudgetValueGreater() {
		// Given
		Budget expectedBudget_1 = createBudget();
		Budget expectedBudget_2 = createBudget();
		
		List<Budget> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueGreaterThan(BUDGET_VALUE_MIN)).thenReturn(expectedBudgets);
		
		// When
		List<Budget> actualBudgets = service.searchAllByBiggerValueThan(BUDGET_VALUE_MIN);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void searchAllForBudgetValueLower() {
		// Given
		Budget expectedBudget_1 = createBudget();
		Budget expectedBudget_2 = createBudget();
		
		List<Budget> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findByBudgetValueLessThan(BUDGET_VALUE_MAX)).thenReturn(expectedBudgets);
		
		// When
		List<Budget> actualBudgets = service.searchAllByLessValueThan(BUDGET_VALUE_MAX);
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	@Test
	void create() {
		// Given
		Budget expectedToAdd = createBudget();
		Budget expectedBudget = createBudget();
		
		when(storage.save(expectedToAdd)).thenReturn(expectedBudget);
		
		// When
		Budget actualBudget = service.create(expectedToAdd);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateByObject() {
		// Given
		Budget expectedToChange = createBudget();
		Budget expectedBudget = createBudget(500.5);
		
		when(storage.save(expectedToChange)).thenReturn(expectedBudget);
		
		// When
		Budget actualBudget = service.update(expectedToChange);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateById() {
		// Given
		Budget expectedChanges = createBudget(500.5);
		Budget expectedBudget = createBudget();
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBudget));
		when(storage.save(MergeUtil.merge(expectedChanges, expectedChanges))).thenReturn(expectedBudget);
		
		// When
		Budget actualBudget = service.update(expectedChanges, ID);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void updateById_throw() {
		// When
		Budget expectedChanges = createBudget(500.5);
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.empty());
		ThrowableAssert.ThrowingCallable throwable = () -> service.update(expectedChanges, ID);
		
		// Then
		assertThatThrownByNotFoundException(throwable, BusinessLogicExceptionFactory.ExceptionMessage.BUDGET_NOT_FOUND,
		                                    BusinessLogicExceptionFactory.ErrorCode.BUDGET_NOT_FOUND
		);
	}
	
	@Test
	void ifIdIsNotValid_throw() {
		// Given
		when(storage.isValid(ID)).thenReturn(false);
		
		// When
		ThrowableAssert.ThrowingCallable throwable = () -> service.searchById(ID)
		                                                          .get();
		
		// Then
		assertThatThrownByValidateIdException(throwable, ValidationExceptionFactory.ExceptionMessage.INVALID_ID_FORMAT,
		                                      ValidationExceptionFactory.ErrorCode.INVALID_ID_FORMAT
		);
	}
	
	@Test
	void updateOriginalAndChanges() {
		// Given
		Budget expectedToChange = createBudget();
		Budget expectedChanges = createBudget(500.5);
		Budget expectedBudget = createBudget(500.5);
		
		when(storage.save(MergeUtil.merge(expectedToChange, expectedChanges))).thenReturn(expectedBudget);
		
		// When
		Budget actualBudget = service.update(expectedToChange, expectedChanges);
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget);
	}
	
	@Test
	void searchForId() {
		// Given
		Budget expectedBudget_1 = createBudget();
		
		when(storage.isValid(ID)).thenReturn(true);
		when(storage.findById(ID)).thenReturn(Optional.of(expectedBudget_1));
		
		// When
		Budget actualBudget = service.searchById(ID)
		                             .get();
		
		// Then
		assertThat(actualBudget).isEqualTo(expectedBudget_1);
	}
	
	@Test
	void searchAll() {
		// Given
		Budget expectedBudget_1 = createBudget();
		Budget expectedBudget_2 = createBudget();
		
		List<Budget> expectedBudgets = List.of(expectedBudget_1, expectedBudget_2);
		
		when(storage.findAll()).thenReturn(expectedBudgets);
		
		// When
		List<Budget> actualBudgets = service.searchAll();
		
		// Then
		budgetListAssertions(actualBudgets, expectedBudgets, expectedBudget_1, expectedBudget_2);
	}
	
	private void budgetListAssertions(
		List<Budget> actualBudgets, List<Budget> expectedBudgets, Budget expectedBudget_1, Budget expectedBudget_2
	) {
		assertThat(actualBudgets).isEqualTo(expectedBudgets);
		assertThat(actualBudgets.size()).isEqualTo(expectedBudgets.size());
		assertThat(actualBudgets).containsExactlyInAnyOrder(expectedBudget_1, expectedBudget_2);
	}
	
}