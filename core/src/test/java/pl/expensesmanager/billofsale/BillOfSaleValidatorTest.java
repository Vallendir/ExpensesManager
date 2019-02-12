package pl.expensesmanager.billofsale;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import pl.expensesmanager.AbstractCoreTest;
import pl.expensesmanager.exception.validation.ValidateObjectException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static pl.expensesmanager.exception.ValidationExceptionFactory.ErrorCode;
import static pl.expensesmanager.exception.ValidationExceptionFactory.ExceptionMessage;

class BillOfSaleValidatorTest extends AbstractCoreTest {
	
	@Test
	void validateDescription() {
		// Given
		ThrowingCallable throwable_1 = () -> BillOfSaleValidator.validateDescription(BLANK_TEXT);
		ThrowingCallable throwable_2 = () -> BillOfSaleValidator.validateDescription(EMPTY_SPACE_TEXT);
		
		// Then
		assertThatThrownByValidateTextException(
			throwable_1, ExceptionMessage.BILL_OF_SALE_DESCRIPTION, ErrorCode.BILL_OF_SALE_DESCRIPTION);
		assertThatThrownByValidateTextException(
			throwable_2, ExceptionMessage.BILL_OF_SALE_DESCRIPTION, ErrorCode.BILL_OF_SALE_DESCRIPTION);
		assertThat(BillOfSaleValidator.validateDescription(TEXT_WITH_HTML4_TO_ESCAPE)).isEqualTo(
			TEXT_WITH_HTML4_AFTER_ESCAPE);
	}
	
	@Test
	void validateBoughtDate() {
		// Given
		ThrowingCallable throwable_1 = () -> BillOfSaleValidator.validateBoughtDate(null);
		
		// Then
		assertThatThrownByValidateDateException(throwable_1, ExceptionMessage.NULL_DATE, ErrorCode.NULL_DATE);
		assertThat(BillOfSaleValidator.validateBoughtDate(BOUGHT_DATE)).isEqualTo(BOUGHT_DATE);
	}
	
	@Test
	void validateBillOfSale() {
		// Given
		BillOfSalePort billOfSale = createBillOfSale();
		
		ThrowingCallable throwable_1 = () -> BillOfSaleValidator.validateBillOfSale(null);
		
		// Then
		assertThatThrownBy(throwable_1).isInstanceOf(ValidateObjectException.class)
		                               .hasMessage(ExceptionMessage.NULL_BILL_OF_SALE);
		assertThat(BillOfSaleValidator.validateBillOfSale(billOfSale)).isEqualTo(billOfSale);
	}
	
}