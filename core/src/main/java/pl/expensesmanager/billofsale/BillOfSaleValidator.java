package pl.expensesmanager.billofsale;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import java.time.Instant;

@UtilityClass
class BillOfSaleValidator {
	
	static String validateDescription(String description) {
		if (StringUtils.isBlank(description)) {
			throw new RuntimeException();
		}
		
		return StringEscapeUtils.escapeHtml4(description)
		                        .trim();
	}
	
	static Instant validateBoughtDate(Instant boughtDate) {
		if (boughtDate == null) {
			throw new RuntimeException();
		}
		
		return boughtDate;
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
