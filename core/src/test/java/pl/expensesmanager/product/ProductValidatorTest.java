package pl.expensesmanager.product;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import pl.expensesmanager.exception.ValidationExceptionFactory;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateObjectException;
import pl.expensesmanager.exception.validation.ValidateTextException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProductValidatorTest {
	
	@Test
	void validateName() {
		// Given
		String blankString_1 = "";
		String blankString_2 = " ";
		
		String textToEscapeHTML = "<span> Name Tekst ";
		String expectedTextToEscapeHTML = "&lt;span&gt; Name Tekst";
		
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validateName(blankString_1);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> ProductValidator.validateName(blankString_2);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateTextException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.PRODUCT_NAME);
		assertThatThrownBy(throwable_2).isInstanceOf(ValidateTextException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.PRODUCT_NAME);
		assertThat(ProductValidator.validateName(textToEscapeHTML)).isEqualTo(expectedTextToEscapeHTML);
	}
	
	@Test
	void validatePrice() {
		// Given
		Double priceNull = null;
		Double priceNAN = Double.NaN;
		Double expectedPrice = 5.75;
		
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validatePrice(priceNull);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> ProductValidator.validatePrice(priceNAN);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateNumberException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.PRODUCT_PRICE);
		assertThatThrownBy(throwable_2).isInstanceOf(ValidateNumberException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.PRODUCT_PRICE);
		assertThat(ProductValidator.validatePrice(expectedPrice)).isEqualTo(expectedPrice);
	}
	
	@Test
	void validateQuanity() {
		// Given
		Integer quanity = 2;
		Integer quanityNull = null;
		
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validateQuanity(quanityNull);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateNumberException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.PRODUCT_QUANITY);
		assertThat(ProductValidator.validateQuanity(quanity)).isEqualTo(quanity);
	}
	
	@Test
	void validateProduct() {
		// Given
		ProductPort product = createProduct();
		ProductPort productNull = null;
		
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validateProduct(productNull);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateObjectException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.PRODUCT_NULL);
		assertThat(ProductValidator.validateProduct(product)).isEqualTo(product);
	}
	
	@Test
	void validateOrder() {
		// Given
		ProductPort product = createProduct();
		ProductPort productNull = null;
		
		ProductOrderPort order = createProductOrder();
		ProductOrderPort orderNull = null;
		
		ThrowableAssert.ThrowingCallable throwable_1 = () -> ProductValidator.validateProduct(productNull);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> ProductValidator.validateOrder(orderNull);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateObjectException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.PRODUCT_NULL);
		assertThatThrownBy(throwable_2).isInstanceOf(ValidateObjectException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.PRODUCT_ORDER_NULL);
		assertThat(ProductValidator.validateProduct(product)).isEqualTo(product);
		assertThat(ProductValidator.validateOrder(order)).isEqualTo(order);
	}
	
	private ProductPort createProduct() {
		return new Product("name", 3.25);
	}
	
	private ProductOrderPort createProductOrder() {
		return new ProductOrder(createProduct(), 10);
	}
	
}