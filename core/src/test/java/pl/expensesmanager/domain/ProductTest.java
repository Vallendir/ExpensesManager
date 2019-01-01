package pl.expensesmanager.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {
	
	@Test
	void testSummaryPrice() {
		// Given
		String expectedProductName = "Product 1";
		Double expectedProductPrice = 5.75;
		Integer productQuanity = 4;
		
		ProductPort expectedProduct = new Product(expectedProductName, expectedProductPrice, productQuanity);
		Double expectedSummaryPrice = expectedProductPrice * productQuanity;
		
		// When
		Double actualSummaryPrice = expectedProduct.summaryPrice();
		
		// Then
		assertThat(actualSummaryPrice).isEqualTo(expectedSummaryPrice);
	}
	
}