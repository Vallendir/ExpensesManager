package pl.expensesmanager.util;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.ValidationExceptionFactory;
import pl.expensesmanager.product.Product;

import static org.assertj.core.api.Assertions.assertThat;

class CoreValidatorTest extends AbstractCoreTest {
	
	@Test
	void validateProductName() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> CoreValidator.validateProductName(BLANK_TEXT);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> CoreValidator.validateProductName(EMPTY_SPACE_TEXT);
		
		// Then
		assertThatThrownByValidateTextException(throwable_1, ValidationExceptionFactory.ExceptionMessage.PRODUCT_NAME,
		                                        ValidationExceptionFactory.ErrorCode.PRODUCT_NAME
		);
		assertThatThrownByValidateTextException(throwable_2, ValidationExceptionFactory.ExceptionMessage.PRODUCT_NAME,
		                                        ValidationExceptionFactory.ErrorCode.PRODUCT_NAME
		);
	}
	
	@Test
	void validateProductPrice() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> CoreValidator.validateProductPrice(null);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> CoreValidator.validateProductPrice(DOUBLE_VALUE_NAN);
		
		// Then
		assertThatThrownByValidateNumberException(throwable_1,
		                                          ValidationExceptionFactory.ExceptionMessage.PRODUCT_PRICE,
		                                          ValidationExceptionFactory.ErrorCode.PRODUCT_PRICE
		);
		assertThatThrownByValidateNumberException(throwable_2,
		                                          ValidationExceptionFactory.ExceptionMessage.PRODUCT_PRICE,
		                                          ValidationExceptionFactory.ErrorCode.PRODUCT_PRICE
		);
		assertThat(CoreValidator.validateProductPrice(PRODUCT_PRICE)).isEqualTo(PRODUCT_PRICE);
	}
	
	@Test
	void validateOrderQuanity() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> CoreValidator.validateOrderQuanity(null);
		
		// Then
		assertThatThrownByValidateNumberException(throwable_1,
		                                          ValidationExceptionFactory.ExceptionMessage.PRODUCT_QUANITY,
		                                          ValidationExceptionFactory.ErrorCode.PRODUCT_QUANITY
		);
		assertThat(CoreValidator.validateOrderQuanity(PRODUCT_QUANITY)).isEqualTo(PRODUCT_QUANITY);
	}
	
	@Test
	void validateProduct() {
		// Given
		Product product = createProduct();
		
		ThrowableAssert.ThrowingCallable throwable_1 = () -> CoreValidator.validateProduct(null);
		
		// Then
		assertThatThrownByValidateObjectException(throwable_1, ValidationExceptionFactory.ExceptionMessage.NULL_PRODUCT,
		                                          ValidationExceptionFactory.ErrorCode.NULL_PRODUCT
		);
		assertThat(CoreValidator.validateProduct(product)).isEqualTo(product);
	}
	
	@Test
	void validateBudgetName() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> CoreValidator.validateBudgetName(BLANK_TEXT);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> CoreValidator.validateBudgetName(EMPTY_SPACE_TEXT);
		
		// Then
		assertThatThrownByValidateTextException(throwable_1, ValidationExceptionFactory.ExceptionMessage.BUDGET_NAME,
		                                        ValidationExceptionFactory.ErrorCode.BUDGET_NAME
		);
		assertThatThrownByValidateTextException(throwable_2, ValidationExceptionFactory.ExceptionMessage.BUDGET_NAME,
		                                        ValidationExceptionFactory.ErrorCode.BUDGET_NAME
		);
	}
	
	@Test
	void validateBudgetValue() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> CoreValidator.validateBudgetValue(null);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> CoreValidator.validateBudgetValue(DOUBLE_VALUE_NAN);
		
		// Then
		assertThatThrownByValidateNumberException(throwable_1, ValidationExceptionFactory.ExceptionMessage.BUDGET_VALUE,
		                                          ValidationExceptionFactory.ErrorCode.BUDGET_VALUE
		);
		assertThatThrownByValidateNumberException(throwable_2, ValidationExceptionFactory.ExceptionMessage.BUDGET_VALUE,
		                                          ValidationExceptionFactory.ErrorCode.BUDGET_VALUE
		);
		assertThat(CoreValidator.validateBudgetValue(BUDGET_VALUE)).isEqualTo(BUDGET_VALUE);
	}
	
	@Test
	void validateBillOfSaleDescription() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> CoreValidator.validateBillOfSaleDescription(BLANK_TEXT);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> CoreValidator.validateBillOfSaleDescription(
			EMPTY_SPACE_TEXT);
		
		// Then
		assertThatThrownByValidateTextException(throwable_1,
		                                        ValidationExceptionFactory.ExceptionMessage.BILL_OF_SALE_DESCRIPTION,
		                                        ValidationExceptionFactory.ErrorCode.BILL_OF_SALE_DESCRIPTION
		);
		assertThatThrownByValidateTextException(throwable_2,
		                                        ValidationExceptionFactory.ExceptionMessage.BILL_OF_SALE_DESCRIPTION,
		                                        ValidationExceptionFactory.ErrorCode.BILL_OF_SALE_DESCRIPTION
		);
	}
	
	@Test
	void validateBillOfSaleBoughtDate() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> CoreValidator.validateBillOfSaleBoughtDate(null);
		
		// Then
		assertThatThrownByValidateDateException(throwable_1, ValidationExceptionFactory.ExceptionMessage.NULL_DATE,
		                                        ValidationExceptionFactory.ErrorCode.NULL_DATE
		);
		assertThat(CoreValidator.validateBillOfSaleBoughtDate(BOUGHT_DATE)).isEqualTo(BOUGHT_DATE);
	}
	
}