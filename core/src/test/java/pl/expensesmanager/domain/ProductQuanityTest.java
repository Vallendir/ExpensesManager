package pl.expensesmanager.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductQuanityTest {
	
	@Test
	void testSummaryPrice() {
		// Given
		String expectedProductName = "Product 1";
		Double expectedProductPrice = 5.75;
		Integer productQuanity = 4;
		
		ProductApi expectedProduct = new Product(expectedProductName, expectedProductPrice);
		
		ProductQuanityApi expectedProductQuanity = new ProductQuanity(expectedProduct, productQuanity);
		Double expectedSummaryPrice = expectedProductPrice * productQuanity;
		
		// When
		Double actualSummaryPrice = expectedProductQuanity.summaryPrice();
		
		// Then
		assertThat(actualSummaryPrice).isEqualTo(expectedSummaryPrice);
	}
	
}