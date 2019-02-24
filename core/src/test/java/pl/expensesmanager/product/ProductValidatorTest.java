package pl.expensesmanager.product;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.ValidationExceptionFactory.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.expensesmanager.exception.ValidationExceptionFactory.ErrorCode;

class ProductValidatorTest extends AbstractCoreTest {
	
	@Test
	void validateName() {
		// Given
		ThrowingCallable throwable_1 = () -> ProductValidator.validateName(BLANK_TEXT);
		ThrowingCallable throwable_2 = () -> ProductValidator.validateName(EMPTY_SPACE_TEXT);
		
		// Then
		assertThatThrownByValidateTextException(throwable_1, ExceptionMessage.PRODUCT_NAME, ErrorCode.PRODUCT_NAME);
		assertThatThrownByValidateTextException(throwable_2, ExceptionMessage.PRODUCT_NAME, ErrorCode.PRODUCT_NAME);
		assertThat(ProductValidator.validateName(TEXT_WITH_HTML4_TO_ESCAPE)).isEqualTo(TEXT_WITH_HTML4_AFTER_ESCAPE);
	}
	
	@Test
	void validatePrice() {
		// Given
		ThrowingCallable throwable_1 = () -> ProductValidator.validatePrice(null);
		ThrowingCallable throwable_2 = () -> ProductValidator.validatePrice(DOUBLE_VALUE_NAN);
		
		// Then
		assertThatThrownByValidateNumberException(throwable_1, ExceptionMessage.PRODUCT_PRICE, ErrorCode.PRODUCT_PRICE);
		assertThatThrownByValidateNumberException(throwable_2, ExceptionMessage.PRODUCT_PRICE, ErrorCode.PRODUCT_PRICE);
		assertThat(ProductValidator.validatePrice(PRODUCT_PRICE)).isEqualTo(PRODUCT_PRICE);
	}
	
	@Test
	void validateQuanity() {
		// Given
		ThrowingCallable throwable_1 = () -> ProductValidator.validateQuanity(null);
		
		// Then
		assertThatThrownByValidateNumberException(
			throwable_1, ExceptionMessage.PRODUCT_QUANITY, ErrorCode.PRODUCT_QUANITY);
		assertThat(ProductValidator.validateQuanity(PRODUCT_QUANITY)).isEqualTo(PRODUCT_QUANITY);
	}
	
	@Test
	void validateProduct() {
		// Given
		Product product = createProduct();
		
		ThrowingCallable throwable_1 = () -> ProductValidator.validateProduct(null);
		
		// Then
		assertThatThrownByValidateObjectException(throwable_1, ExceptionMessage.NULL_PRODUCT, ErrorCode.NULL_PRODUCT);
		assertThat(ProductValidator.validateProduct(product)).isEqualTo(product);
	}
	
	@Test
	void validateOrder() {
		// Given
		Product product = createProduct();
		ProductOrder order = createProductOrder();
		
		ThrowingCallable throwable_1 = () -> ProductValidator.validateProduct(null);
		ThrowingCallable throwable_2 = () -> ProductValidator.validateOrder(null);
		
		// Then
		assertThatThrownByValidateObjectException(throwable_1, ExceptionMessage.NULL_PRODUCT, ErrorCode.NULL_PRODUCT);
		assertThatThrownByValidateObjectException(
			throwable_2, ExceptionMessage.NULL_PRODUCT_ORDER, ErrorCode.NULL_PRODUCT_ORDER);
		assertThat(ProductValidator.validateProduct(product)).isEqualTo(product);
		assertThat(ProductValidator.validateOrder(order)).isEqualTo(order);
	}
	
}