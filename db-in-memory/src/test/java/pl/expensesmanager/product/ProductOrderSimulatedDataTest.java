package pl.expensesmanager.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductOrderSimulatedDataTest {
	
	@Test
	void testList() {
		assertThat(ProductOrderSimulatedData.LIST.size()).isEqualTo(ProductOrderSimulatedData.LIST_SIZE);
	}
	
}