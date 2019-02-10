package pl.expensesmanager.billofsale;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.ValidationExceptionFactory;
import pl.expensesmanager.exception.validation.ValidateObjectException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BillOfSaleValidatorTest extends AbstractCoreTest {
	
	@Test
	void validateDescription() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> BillOfSaleValidator.validateDescription(BLANK_TEXT);
		ThrowableAssert.ThrowingCallable throwable_2 = () -> BillOfSaleValidator.validateDescription(EMPTY_SPACE_TEXT);
		
		// Then
		assertThatThrownByValidateTextException(
			throwable_1, ValidationExceptionFactory.ExceptionMessage.BILL_OF_SALE_DESCRIPTION);
		assertThatThrownByValidateTextException(
			throwable_2, ValidationExceptionFactory.ExceptionMessage.BILL_OF_SALE_DESCRIPTION);
		assertThat(BillOfSaleValidator.validateDescription(TEXT_WITH_HTML4_TO_ESCAPE)).isEqualTo(
			TEXT_WITH_HTML4_AFTER_ESCAPE);
	}
	
	@Test
	void validateBoughtDate() {
		// Given
		ThrowableAssert.ThrowingCallable throwable_1 = () -> BillOfSaleValidator.validateBoughtDate(null);
		
		// Then
		assertThatThrownByValidateDateException(throwable_1, ValidationExceptionFactory.ExceptionMessage.DATE_NULL);
		assertThat(BillOfSaleValidator.validateBoughtDate(BOUGHT_DATE)).isEqualTo(BOUGHT_DATE);
	}
	
	@Test
	void validateBillOfSale() {
		// Given
		BillOfSalePort billOfSale = createBillOfSale();
		
		ThrowableAssert.ThrowingCallable throwable_1 = () -> BillOfSaleValidator.validateBillOfSale(null);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateObjectException.class)
		                               .hasMessage(ValidationExceptionFactory.ExceptionMessage.BILL_OF_SALE_NULL);
		assertThat(BillOfSaleValidator.validateBillOfSale(billOfSale)).isEqualTo(billOfSale);
	}
	
}