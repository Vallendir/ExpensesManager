package pl.expensesmanager.product;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.ValidationExceptionFactory;

import static org.assertj.core.api.Assertions.assertThat;

class ProductValidatorTest extends AbstractCoreTest {
	
	@Test
	void validateName() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validateName(BLANK_TEXT);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> ProductValidator.validateName(EMPTY_SPACE_TEXT);
		
		// Then
		assertThatThrownByValidateTextException(throwable_1, ValidationExceptionFactory.ExceptionMessage.PRODUCT_NAME);
		assertThatThrownByValidateTextException(throwable_2, ValidationExceptionFactory.ExceptionMessage.PRODUCT_NAME);
		assertThat(ProductValidator.validateName(TEXT_WITH_HTML4_TO_ESCAPE)).isEqualTo(TEXT_WITH_HTML4_AFTER_ESCAPE);
	}
	
	@Test
	void validatePrice() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validatePrice(null);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> ProductValidator.validatePrice(DOUBLE_VALUE_NAN);
		
		// Then
		assertThatThrownByValidateNumberException(
			throwable_1, ValidationExceptionFactory.ExceptionMessage.PRODUCT_PRICE);
		assertThatThrownByValidateNumberException(
			throwable_2, ValidationExceptionFactory.ExceptionMessage.PRODUCT_PRICE);
		assertThat(ProductValidator.validatePrice(PRODUCT_PRICE)).isEqualTo(PRODUCT_PRICE);
	}
	
	@Test
	void validateQuanity() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validateQuanity(null);
		
		// Then
		assertThatThrownByValidateNumberException(
			throwable_1, ValidationExceptionFactory.ExceptionMessage.PRODUCT_QUANITY);
		assertThat(ProductValidator.validateQuanity(PRODUCT_QUANITY)).isEqualTo(PRODUCT_QUANITY);
	}
	
	@Test
	void validateProduct() {
		// Given
		ProductPort product = createProduct();
		
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validateProduct(null);
		
		// Then
		assertThatThrownByValidateObjectException(
			throwable_1, ValidationExceptionFactory.ExceptionMessage.PRODUCT_NULL);
		assertThat(ProductValidator.validateProduct(product)).isEqualTo(product);
	}
	
	@Test
	void validateOrder() {
		// Given
		ProductPort product = createProduct();
		ProductOrderPort order = createProductOrder();
		
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validateProduct(null);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> ProductValidator.validateOrder(null);
		
		// Then
		assertThatThrownByValidateObjectException(
			throwable_1, ValidationExceptionFactory.ExceptionMessage.PRODUCT_NULL);
		assertThatThrownByValidateObjectException(
			throwable_2, ValidationExceptionFactory.ExceptionMessage.PRODUCT_ORDER_NULL);
		assertThat(ProductValidator.validateProduct(product)).isEqualTo(product);
		assertThat(ProductValidator.validateOrder(order)).isEqualTo(order);
	}
	
}