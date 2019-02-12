package pl.expensesmanager.budget;

import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;

import static org.assertj.core.api.Assertions.assertThat;

class BudgetTest extends AbstractCoreTest {
	
	@Test
	void testBudgetSpent() {
		// Given
		BudgetPort expectedBudget = createBudget();
		Double expectedBudgetSpent = PRODUCT_QUANITY * PRODUCT_PRICE;
		
		// When
		Double actualBudgetSpent = expectedBudget.budgetSpent();
		// Then
		assertThat(actualBudgetSpent).isEqualTo(expectedBudgetSpent);
	}
	
	@Test
	void testBudgetLeft() {
		// Given
		BudgetPort expectedBudget = createBudget();
		Double expectedBudgetLeft = BUDGET_VALUE - (PRODUCT_QUANITY * PRODUCT_PRICE);
		
		// When
		Double actualBudgetLeft = expectedBudget.budgetLeft();
		
		// Then
		assertThat(actualBudgetLeft).isEqualTo(expectedBudgetLeft);
	}
	
}