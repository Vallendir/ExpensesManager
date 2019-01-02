package pl.expensesmanager.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductSimulatedDataTest {
	
	@Test
	void testList() {
		assertThat(ProductSimulatedData.LIST.size()).isEqualTo(ProductSimulatedData.LIST_SIZE);
	}
	
}