package pl.expensesmanager.billofsale;

import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderPort;
import pl.expensesmanager.product.ProductPort;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BillOfSaleTest extends AbstractCoreTest {
	
	@Test
	void testFinalPrice() {
		// Given
		ProductPort expectedProduct_1 = createProduct();
		ProductOrderPort expectedProductOrder_1 = new ProductOrder(expectedProduct_1, PRODUCT_QUANITY);
		Double expectedSummaryPrice_1 = PRODUCT_PRICE * PRODUCT_QUANITY;
		
		ProductPort expectedProduct_2 = createProduct();
		ProductOrderPort expectedProductOrder_2 = new ProductOrder(expectedProduct_2, PRODUCT_QUANITY);
		Double expectedSummaryPrice_2 = PRODUCT_PRICE * PRODUCT_QUANITY;
		
		BillOfSalePort expectedBillOfSale = new BillOfSale(
			List.of(expectedProductOrder_1, expectedProductOrder_2), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice = ((PRODUCT_PRICE * PRODUCT_QUANITY) + (PRODUCT_PRICE * PRODUCT_QUANITY));
		
		// When
		Double actualSummaryPrice_1 = expectedProductOrder_1.summaryPrice();
		Double actualSummaryPrice_2 = expectedProductOrder_2.summaryPrice();
		Double actualBillOfSaleFinalPrice = expectedBillOfSale.finalPrice();
		
		// Then
		assertThat(actualSummaryPrice_1).isEqualTo(expectedSummaryPrice_1);
		assertThat(actualSummaryPrice_2).isEqualTo(expectedSummaryPrice_2);
		assertThat(actualBillOfSaleFinalPrice).isEqualTo(expectedBillOfSaleFinalPrice);
	}
	
}