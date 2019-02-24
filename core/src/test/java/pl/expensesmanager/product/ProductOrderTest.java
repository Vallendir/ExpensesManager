package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;

import static org.assertj.core.api.Assertions.assertThat;

class ProductOrderTest extends AbstractCoreTest {
	
	@Test
	void testSummaryPrice() {
		// Given
		ProductOrder expectedProductOrder = createProductOrder();
		
		Double expectedSummaryPrice = PRODUCT_PRICE * PRODUCT_QUANITY;
		
		// When
		Double actualSummaryPrice = expectedProductOrder.summaryPrice();
		
		// Then
		assertThat(actualSummaryPrice).isEqualTo(expectedSummaryPrice);
	}
	
}