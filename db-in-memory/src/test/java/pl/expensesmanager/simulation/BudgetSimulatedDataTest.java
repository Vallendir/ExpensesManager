package pl.expensesmanager.simulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BudgetSimulatedDataTest {
	
	@Test
	void testList() {
		assertThat(BudgetSimulatedData.LIST.size()).isEqualTo(BudgetSimulatedData.LIST_SIZE);
		assertThat(BudgetSimulatedData.LIST.get(0)
		                                   .getBillsOfSaleList()
		                                   .size()).isEqualTo(5);
		assertThat(BudgetSimulatedData.LIST.get(1)
		                                   .getBillsOfSaleList()
		                                   .size()).isEqualTo(3);
	}
	
}