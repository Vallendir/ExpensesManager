package pl.expensesmanager.billofsale;

import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;

import static org.assertj.core.api.Assertions.assertThat;

class BillOfSaleTest extends AbstractCoreTest {
	
	@Test
	void testFinalPrice() {
		// Given
		BillOfSale expectedBillOfSale = createBillOfSale();
		Double expectedBillOfSaleFinalPrice = PRODUCT_PRICE * PRODUCT_QUANITY;
		
		// When
		Double actualBillOfSaleFinalPrice = expectedBillOfSale.finalPrice();
		
		// Then
		assertThat(actualBillOfSaleFinalPrice).isEqualTo(expectedBillOfSaleFinalPrice);
	}
	
}