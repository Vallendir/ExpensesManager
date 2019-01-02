package pl.expensesmanager.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BillOfSaleSimulatedDataTest {
	
	@Test
	void testList() {
		assertThat(BillOfSaleSimulatedData.LIST.size()).isEqualTo(BillOfSaleSimulatedData.LIST_SIZE);
		assertThat(BillOfSaleSimulatedData.LIST.get(0)
		                                       .getProductList()).isNotNull();
		assertThat(BillOfSaleSimulatedData.LIST.get(0)
		                                       .getProductList()
		                                       .size()).isGreaterThan(0);
		assertThat(BillOfSaleSimulatedData.LIST.get(1)
		                                       .getProductList()).isNotNull();
		assertThat(BillOfSaleSimulatedData.LIST.get(1)
		                                       .getProductList()
		                                       .size()).isGreaterThan(0);
		assertThat(BillOfSaleSimulatedData.LIST.get(2)
		                                       .getProductList()).isNotNull();
		assertThat(BillOfSaleSimulatedData.LIST.get(2)
		                                       .getProductList()
		                                       .size()).isGreaterThan(0);
		assertThat(BillOfSaleSimulatedData.LIST.get(3)
		                                       .getProductList()).isNotNull();
		assertThat(BillOfSaleSimulatedData.LIST.get(3)
		                                       .getProductList()
		                                       .size()).isGreaterThan(0);
		assertThat(BillOfSaleSimulatedData.LIST.get(4)
		                                       .getProductList()).isNotNull();
		assertThat(BillOfSaleSimulatedData.LIST.get(4)
		                                       .getProductList()
		                                       .size()).isGreaterThan(0);
		assertThat(BillOfSaleSimulatedData.LIST.get(5)
		                                       .getProductList()).isNotNull();
		assertThat(BillOfSaleSimulatedData.LIST.get(5)
		                                       .getProductList()
		                                       .size()).isGreaterThan(0);
		assertThat(BillOfSaleSimulatedData.LIST.get(6)
		                                       .getProductList()).isNotNull();
		assertThat(BillOfSaleSimulatedData.LIST.get(6)
		                                       .getProductList()
		                                       .size()).isGreaterThan(0);
		assertThat(BillOfSaleSimulatedData.LIST.get(7)
		                                       .getProductList()).isNotNull();
		assertThat(BillOfSaleSimulatedData.LIST.get(7)
		                                       .getProductList()
		                                       .size()).isGreaterThan(0);
	}
	
}