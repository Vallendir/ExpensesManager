package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductValidatorTest {
	
	@Test
	void validateProductName() {
		// Given
		String blankString_1 = "";
		String blankString_2 = " ";
		
		String textToEscapeHTML = "<span> Tekst ";
		String expectedTextToEscapeHTML = "&lt;span&gt; Tekst";
		
		// Then
		assertThrows(RuntimeException.class, () -> ProductValidator.validateProductName(blankString_1));
		assertThrows(RuntimeException.class, () -> ProductValidator.validateProductName(blankString_2));
		assertThat(ProductValidator.validateProductName(textToEscapeHTML)).isEqualTo(expectedTextToEscapeHTML);
	}
	
	@Test
	void validatePrice() {
		// Given
		Double priceNull = null;
		Double priceNAN = Double.NaN;
		Double expectedPrice = 5.75;
		
		// Then
		assertThrows(RuntimeException.class, () -> ProductValidator.validatePrice(priceNull));
		assertThrows(RuntimeException.class, () -> ProductValidator.validatePrice(priceNAN));
		assertThat(ProductValidator.validatePrice(expectedPrice)).isEqualTo(expectedPrice);
	}
	
	@Test
	void validateQuanity() {
		// Given
		Integer quanity = 2;
		Integer quanityNull = null;
		
		// Then
		assertThrows(RuntimeException.class, () -> ProductValidator.validateQuanity(quanityNull));
		assertThat(ProductValidator.validateQuanity(quanity)).isEqualTo(quanity);
	}
	
	@Test
	void validateProduct() {
		// Given
		ProductPort product = createProduct();
		ProductPort productNull = null;
		
		// Then
		assertThrows(RuntimeException.class, () -> ProductValidator.validateProduct(productNull));
		assertThat(ProductValidator.validateProduct(product)).isEqualTo(product);
	}
	
	@Test
	void validateOrder() {
		// Given
		ProductPort product = createProduct();
		ProductPort productNull = null;
		
		ProductOrderPort order = createProductOrder();
		ProductOrderPort orderNull = null;
		
		// Then
		assertThrows(RuntimeException.class, () -> ProductValidator.validateProduct(productNull));
		assertThat(ProductValidator.validateProduct(product)).isEqualTo(product);
		assertThrows(RuntimeException.class, () -> ProductValidator.validateOrder(orderNull));
		assertThat(ProductValidator.validateOrder(order)).isEqualTo(order);
	}
	
	private ProductPort createProduct() {
		return new Product("name", 3.25);
	}
	
	private ProductOrderPort createProductOrder() {
		return new ProductOrder(createProduct(), 10);
	}
	
}