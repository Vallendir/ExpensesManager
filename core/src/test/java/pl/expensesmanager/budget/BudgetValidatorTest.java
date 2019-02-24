package pl.expensesmanager.budget;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.validation.ValidateObjectException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static pl.expensesmanager.exception.ValidationExceptionFactory.ErrorCode;
import static pl.expensesmanager.exception.ValidationExceptionFactory.ExceptionMessage;

class BudgetValidatorTest extends AbstractCoreTest {
	
	@Test
	void validateName() {
		// Given
		ThrowingCallable throwable_1 = () -> BudgetValidator.validateName(BLANK_TEXT);
		ThrowingCallable throwable_2 = () -> BudgetValidator.validateName(EMPTY_SPACE_TEXT);
		
		// Then
		assertThatThrownByValidateTextException(throwable_1, ExceptionMessage.BUDGET_NAME, ErrorCode.BUDGET_NAME);
		assertThatThrownByValidateTextException(throwable_2, ExceptionMessage.BUDGET_NAME, ErrorCode.BUDGET_NAME);
		assertThat(BudgetValidator.validateName(TEXT_WITH_HTML4_TO_ESCAPE)).isEqualTo(TEXT_WITH_HTML4_AFTER_ESCAPE);
	}
	
	@Test
	void validateBudgetValue() {
		// Given
		ThrowingCallable throwable_1 = () -> BudgetValidator.validateBudgetValue(null);
		ThrowingCallable throwable_2 = () -> BudgetValidator.validateBudgetValue(DOUBLE_VALUE_NAN);
		
		// Then
		assertThatThrownByValidateNumberException(throwable_1, ExceptionMessage.BUDGET_VALUE, ErrorCode.BUDGET_VALUE);
		assertThatThrownByValidateNumberException(throwable_2, ExceptionMessage.BUDGET_VALUE, ErrorCode.BUDGET_VALUE);
		assertThat(BudgetValidator.validateBudgetValue(BUDGET_VALUE)).isEqualTo(BUDGET_VALUE);
	}
	
	@Test
	void validateBudget() {
		// Given
		Budget budget = createBudget();
		
		ThrowingCallable throwable_1 = () -> BudgetValidator.validateBudget(null);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateObjectException.class)
		                               .hasMessage(ExceptionMessage.NULL_BUDGET);
		assertThat(BudgetValidator.validateBudget(budget)).isEqualTo(budget);
	}
	
}