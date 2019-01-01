package pl.expensesmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BudgetTest {
	
	@Test
	void testBudgetSpent() {
		// Given
		String expectedProductName_1 = "Product 1";
		Double expectedProductPrice_1 = 7.85;
		Integer productQuanity_1 = 4;
		
		ProductPort expectedProduct_1 = new Product(expectedProductName_1, expectedProductPrice_1, productQuanity_1);
		Double expectedSummaryPrice_1 = expectedProductPrice_1 * productQuanity_1;
		
		
		String expectedProductName_2 = "Product 2";
		Double expectedProductPrice_2 = 4.30;
		Integer productQuanity_2 = 6;
		
		ProductPort expectedProduct_2 = new Product(expectedProductName_2, expectedProductPrice_2, productQuanity_2);
		Double expectedSummaryPrice_2 = expectedProductPrice_2 * productQuanity_2;
		
		
		BillOfSalePort expectedBillOfSale_1 = new BillOfSale(
			List.of(expectedProduct_1, expectedProduct_2), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice_1 = ((expectedProductPrice_1 * productQuanity_1) +
		                                         (expectedProductPrice_2 * productQuanity_2));
		
		BillOfSalePort expectedBillOfSale_2 = new BillOfSale(
			List.of(expectedProduct_1), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice_2 = expectedProductPrice_1 * productQuanity_1;
		
		BudgetPort expectedBudget = new Budget("Budget Name", 300.5, List.of(expectedBillOfSale_1, expectedBillOfSale_2));
		Double expectedBudgetSpent = expectedBillOfSaleFinalPrice_1 + expectedBillOfSaleFinalPrice_2;
		
		// When
		Double actualSummaryPrice_1 = expectedProduct_1.summaryPrice();
		Double actualSummaryPrice_2 = expectedProduct_2.summaryPrice();
		Double actualBillOfSaleFinalPrice_1 = expectedBillOfSale_1.finalPrice();
		Double actualBillOfSaleFinalPrice_2 = expectedBillOfSale_2.finalPrice();
		Double actualBudgetSpent = expectedBudget.budgetSpent();
		
		// Then
		assertThat(actualSummaryPrice_1).isEqualTo(expectedSummaryPrice_1);
		assertThat(actualSummaryPrice_2).isEqualTo(expectedSummaryPrice_2);
		assertThat(actualBillOfSaleFinalPrice_1).isEqualTo(expectedBillOfSaleFinalPrice_1);
		assertThat(actualBillOfSaleFinalPrice_2).isEqualTo(expectedBillOfSaleFinalPrice_2);
		assertThat(actualBudgetSpent).isEqualTo(expectedBudgetSpent);
	}
	
	@Test
	void testBudgetLeft() {
		// Given
		String expectedProductName_1 = "Product 1";
		Double expectedProductPrice_1 = 7.85;
		Integer productQuanity_1 = 4;
		
		ProductPort expectedProduct_1 = new Product(expectedProductName_1, expectedProductPrice_1, productQuanity_1);
		Double expectedSummaryPrice_1 = expectedProductPrice_1 * productQuanity_1;
		
		
		String expectedProductName_2 = "Product 2";
		Double expectedProductPrice_2 = 4.30;
		Integer productQuanity_2 = 6;
		
		ProductPort expectedProduct_2 = new Product(expectedProductName_2, expectedProductPrice_2, productQuanity_2);
		Double expectedSummaryPrice_2 = expectedProductPrice_2 * productQuanity_2;
		
		
		BillOfSalePort expectedBillOfSale_1 = new BillOfSale(
			List.of(expectedProduct_1, expectedProduct_2), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice_1 = ((expectedProductPrice_1 * productQuanity_1) +
		                                         (expectedProductPrice_2 * productQuanity_2));
		
		BillOfSalePort expectedBillOfSale_2 = new BillOfSale(
			List.of(expectedProduct_1), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice_2 = expectedProductPrice_1 * productQuanity_1;
		
		BudgetPort expectedBudget = new Budget("Budget Name", 300.5, List.of(expectedBillOfSale_1, expectedBillOfSale_2));
		Double expectedBudgetLeft = (expectedBudget.getBudgetValue() -
		                             (expectedBillOfSaleFinalPrice_1 + expectedBillOfSaleFinalPrice_2));
		
		// When
		Double actualSummaryPrice_1 = expectedProduct_1.summaryPrice();
		Double actualSummaryPrice_2 = expectedProduct_2.summaryPrice();
		Double actualBillOfSaleFinalPrice_1 = expectedBillOfSale_1.finalPrice();
		Double actualBillOfSaleFinalPrice_2 = expectedBillOfSale_2.finalPrice();
		Double actualBudgetLeft = expectedBudget.budgetLeft();
		
		// Then
		assertThat(actualSummaryPrice_1).isEqualTo(expectedSummaryPrice_1);
		assertThat(actualSummaryPrice_2).isEqualTo(expectedSummaryPrice_2);
		assertThat(actualBillOfSaleFinalPrice_1).isEqualTo(expectedBillOfSaleFinalPrice_1);
		assertThat(actualBillOfSaleFinalPrice_2).isEqualTo(expectedBillOfSaleFinalPrice_2);
		assertThat(actualBudgetLeft).isEqualTo(expectedBudgetLeft);
	}
	
}