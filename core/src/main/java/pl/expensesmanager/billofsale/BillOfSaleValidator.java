package pl.expensesmanager.billofsale;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.exception.validation.ValidateTextException;
import pl.expensesmanager.util.BasicValidator;

import java.time.Instant;

import static pl.expensesmanager.exception.ValidationExceptionFactory.*;

/**
 * Validator of bill of sale
 */
@UtilityClass
class BillOfSaleValidator {
	
	static String validateDescription(String description) {
		try {
			return BasicValidator.validateText(description);
		} catch (ValidateTextException exception) {
			throw billOfSaleDescriptionException();
		}
	}
	
	static Instant validateBoughtDate(Instant boughtDate) {
		try {
			return BasicValidator.validateInstantDate(boughtDate);
		} catch (ValidateTextException exception) {
			throw dateNullException();
		}
	}
	
	static BillOfSale validateBillOfSale(BillOfSale billOfSale) {
		if (billOfSale == null) {
			throw billOfSaleException();
		}
		
		validateDescription(billOfSale.getDescription());
		validateBoughtDate(billOfSale.getBoughtDate());
		
		return billOfSale;
	}
	
}
