package pl.expensesmanager.billofsale;

import org.junit.jupiter.api.Test;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductPort;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BillOfSaleTest {
	
	@Test
	void testFinalPrice() {
		// Given
		String expectedProductName_1 = "Product 1";
		Double expectedProductPrice_1 = 3.25;
		Integer productQuanity_1 = 7;
		
		ProductPort expectedProduct_1 = new Product(expectedProductName_1, expectedProductPrice_1, productQuanity_1);
		Double expectedSummaryPrice_1 = expectedProductPrice_1 * productQuanity_1;
		
		
		String expectedProductName_2 = "Product 2";
		Double expectedProductPrice_2 = 8.17;
		Integer productQuanity_2 = 3;
		
		ProductPort expectedProduct_2 = new Product(expectedProductName_2, expectedProductPrice_2, productQuanity_2);
		Double expectedSummaryPrice_2 = expectedProductPrice_2 * productQuanity_2;
		
		
		BillOfSalePort expectedBillOfSale = new BillOfSale(
			List.of(expectedProduct_1, expectedProduct_2), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice = ((expectedProductPrice_1 * productQuanity_1) +
		                                       (expectedProductPrice_2 * productQuanity_2));
		
		// When
		Double actualSummaryPrice_1 = expectedProduct_1.summaryPrice();
		Double actualSummaryPrice_2 = expectedProduct_2.summaryPrice();
		Double actualBillOfSaleFinalPrice = expectedBillOfSale.finalPrice();
		
		// Then
		assertThat(actualSummaryPrice_1).isEqualTo(expectedSummaryPrice_1);
		assertThat(actualSummaryPrice_2).isEqualTo(expectedSummaryPrice_2);
		assertThat(actualBillOfSaleFinalPrice).isEqualTo(expectedBillOfSaleFinalPrice);
	}
	
}