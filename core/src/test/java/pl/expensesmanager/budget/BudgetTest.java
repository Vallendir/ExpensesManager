package pl.expensesmanager.budget;

import org.junit.jupiter.api.Test;
import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.billofsale.BillOfSalePort;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderPort;
import pl.expensesmanager.product.ProductPort;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BudgetTest {
	
	@Test
	void testBudgetSpent() {
		// Given
		String expectedProductName_1 = "Product 1";
		Double expectedProductPrice_1 = 3.25;
		ProductPort expectedProduct_1 = new Product(expectedProductName_1, expectedProductPrice_1);
		
		Integer productQuanity_1 = 7;
		ProductOrderPort expectedProductOrder_1 = new ProductOrder(expectedProduct_1, productQuanity_1);
		Double expectedSummaryPrice_1 = expectedProductPrice_1 * productQuanity_1;
		
		
		String expectedProductName_2 = "Product 2";
		Double expectedProductPrice_2 = 8.17;
		ProductPort expectedProduct_2 = new Product(expectedProductName_2, expectedProductPrice_2);
		
		Integer productQuanity_2 = 3;
		ProductOrderPort expectedProductOrder_2 = new ProductOrder(expectedProduct_2, productQuanity_2);
		Double expectedSummaryPrice_2 = expectedProductPrice_2 * productQuanity_2;
		
		
		BillOfSalePort expectedBillOfSale_1 = new BillOfSale(
			List.of(expectedProductOrder_1, expectedProductOrder_2), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice_1 = ((expectedProductPrice_1 * productQuanity_1) +
		                                       (expectedProductPrice_2 * productQuanity_2));
		
		BillOfSalePort expectedBillOfSale_2 = new BillOfSale(
			List.of(expectedProductOrder_1), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice_2 = expectedProductPrice_1 * productQuanity_1;
		
		BudgetPort expectedBudget = new Budget("Budget Name", 300.5, List.of(expectedBillOfSale_1, expectedBillOfSale_2));
		Double expectedBudgetSpent = expectedBillOfSaleFinalPrice_1 + expectedBillOfSaleFinalPrice_2;
		
		// When
		Double actualSummaryPrice_1 = expectedProductOrder_1.summaryPrice();
		Double actualSummaryPrice_2 = expectedProductOrder_2.summaryPrice();
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
		Double expectedProductPrice_1 = 3.25;
		ProductPort expectedProduct_1 = new Product(expectedProductName_1, expectedProductPrice_1);
		
		Integer productQuanity_1 = 7;
		ProductOrderPort expectedProductOrder_1 = new ProductOrder(expectedProduct_1, productQuanity_1);
		Double expectedSummaryPrice_1 = expectedProductPrice_1 * productQuanity_1;
		
		
		String expectedProductName_2 = "Product 2";
		Double expectedProductPrice_2 = 8.17;
		ProductPort expectedProduct_2 = new Product(expectedProductName_2, expectedProductPrice_2);
		
		Integer productQuanity_2 = 3;
		ProductOrderPort expectedProductOrder_2 = new ProductOrder(expectedProduct_2, productQuanity_2);
		Double expectedSummaryPrice_2 = expectedProductPrice_2 * productQuanity_2;
		
		
		BillOfSalePort expectedBillOfSale_1 = new BillOfSale(
			List.of(expectedProductOrder_1, expectedProductOrder_2), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice_1 = ((expectedProductPrice_1 * productQuanity_1) +
		                                         (expectedProductPrice_2 * productQuanity_2));
		
		BillOfSalePort expectedBillOfSale_2 = new BillOfSale(
			List.of(expectedProductOrder_1), Instant.now(), "Description test.");
		Double expectedBillOfSaleFinalPrice_2 = expectedProductPrice_1 * productQuanity_1;
		
		BudgetPort expectedBudget = new Budget("Budget Name", 300.5, List.of(expectedBillOfSale_1, expectedBillOfSale_2));
		Double expectedBudgetLeft = (expectedBudget.getBudgetValue() -
		                             (expectedBillOfSaleFinalPrice_1 + expectedBillOfSaleFinalPrice_2));
		
		// When
		Double actualSummaryPrice_1 = expectedProductOrder_1.summaryPrice();
		Double actualSummaryPrice_2 = expectedProductOrder_2.summaryPrice();
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