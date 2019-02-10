package pl.expensesmanager.billofsale;

import org.junit.jupiter.api.Test;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderPort;
import pl.expensesmanager.product.ProductPort;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BillOfSaleValidatorTest {
	
	@Test
	void validateDescription() {
		// Given
		String blankString_1 = "";
		String blankString_2 = " ";
		
		String textToEscapeHTML = "<span> Bill Of Sale ";
		String expectedTextToEscapeHTML = "&lt;span&gt; Bill Of Sale";
		
		// Then
		assertThrows(RuntimeException.class, () -> BillOfSaleValidator.validateDescription(blankString_1));
		assertThrows(RuntimeException.class, () -> BillOfSaleValidator.validateDescription(blankString_2));
		assertThat(BillOfSaleValidator.validateDescription(textToEscapeHTML)).isEqualTo(expectedTextToEscapeHTML);
	}
	
	@Test
	void validateBoughtDate() {
		// Given
		Instant date = Instant.now();
		Instant dateNull = null;
		
		// Then
		assertThrows(RuntimeException.class, () -> BillOfSaleValidator.validateBoughtDate(dateNull));
		assertThat(BillOfSaleValidator.validateBoughtDate(date)).isEqualTo(date);
	}
	
	@Test
	void validateBillOfSale() {
		// Given
		BillOfSalePort billOfSale = createBillOfSale();
		BillOfSalePort billOfSaleNull = null;
		
		// Then
		assertThrows(RuntimeException.class, () -> BillOfSaleValidator.validateBillOfSale(billOfSaleNull));
		assertThat(BillOfSaleValidator.validateBillOfSale(billOfSale)).isEqualTo(billOfSale);
	}
	
	private ProductPort createProduct() {
		return new Product("name", 7.3);
	}
	
	private ProductOrderPort createProductOrder() {
		return new ProductOrder(createProduct(), 13);
	}
	
	private BillOfSalePort createBillOfSale() {
		return new BillOfSale(List.of(createProductOrder()), Instant.now(), "description");
	}
	
}