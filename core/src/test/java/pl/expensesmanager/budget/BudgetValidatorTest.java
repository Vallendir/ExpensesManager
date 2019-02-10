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
import static org.junit.jupiter.api.Assertions.assertThrows;

class BudgetValidatorTest {
	
	@Test
	void validateName() {
		// Given
		String blankString_1 = "";
		String blankString_2 = " ";
		
		String textToEscapeHTML = "<span> Budget Tekst ";
		String expectedTextToEscapeHTML = "&lt;span&gt; Budget Tekst";
		
		// Then
		assertThrows(RuntimeException.class, () -> BudgetValidator.validateName(blankString_1));
		assertThrows(RuntimeException.class, () -> BudgetValidator.validateName(blankString_2));
		assertThat(BudgetValidator.validateName(textToEscapeHTML)).isEqualTo(expectedTextToEscapeHTML);
	}
	
	@Test
	void validateBudgetValue() {
		// Given
		Double priceNull = null;
		Double priceNAN = Double.NaN;
		Double expectedPrice = 7.82;
		
		// Then
		assertThrows(RuntimeException.class, () -> BudgetValidator.validateBudgetValue(priceNull));
		assertThrows(RuntimeException.class, () -> BudgetValidator.validateBudgetValue(priceNAN));
		assertThat(BudgetValidator.validateBudgetValue(expectedPrice)).isEqualTo(expectedPrice);
	}
	
	@Test
	void validateBudget() {
		// Given
		BudgetPort budget = createBudget();
		BudgetPort budgetNull = null;
		
		// Then
		assertThrows(RuntimeException.class, () -> BudgetValidator.validateBudget(budgetNull));
		assertThat(BudgetValidator.validateBudget(budget)).isEqualTo(budget);
	}
	
	private ProductPort createProduct() {
		return new Product("name", 3.23);
	}
	
	private ProductOrderPort createProductOrder() {
		return new ProductOrder(createProduct(), 9);
	}
	
	private BillOfSalePort createBillOfSale() {
		return new BillOfSale(List.of(createProductOrder()), Instant.now(), "description");
	}
	
	private BudgetPort createBudget() {
		return new Budget("name", 250.75, List.of(createBillOfSale()));
	}
	
}