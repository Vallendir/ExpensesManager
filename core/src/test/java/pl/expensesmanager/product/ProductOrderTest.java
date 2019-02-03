package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductOrderTest {
	
	@Test
	void testSummaryPrice() {
		// Given
		String expectedProductName = "Product 1";
		Double expectedProductPrice = 5.75;
		ProductPort expectedProduct = new Product(expectedProductName, expectedProductPrice);
		
		Integer productQuanity = 4;
		ProductOrderPort expectedProductOrder = new ProductOrder(expectedProduct, productQuanity);
		
		Double expectedSummaryPrice = expectedProductPrice * productQuanity;
		
		// When
		Double actualSummaryPrice = expectedProductOrder.summaryPrice();
		
		// Then
		assertThat(actualSummaryPrice).isEqualTo(expectedSummaryPrice);
	}
	
}