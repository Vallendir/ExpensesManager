package pl.expensesmanager.billofsale;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.util.BasicValidator;

import java.time.Instant;

/**
 * Validator of bill of sale
 */
@UtilityClass
class BillOfSaleValidator {
	
	static String validateDescription(String description) {
		return BasicValidator.validateText(description);
	}
	
	static Instant validateBoughtDate(Instant boughtDate) {
		return BasicValidator.validateInstantDate(boughtDate);
	}
	
	static BillOfSalePort validateBillOfSale(BillOfSalePort billOfSale) {
		if (billOfSale == null) {
			throw new RuntimeException();
		}
		
		validateDescription(billOfSale.getDescription());
		validateBoughtDate(billOfSale.getBoughtDate());
		
		return billOfSale;
	}
	
}
