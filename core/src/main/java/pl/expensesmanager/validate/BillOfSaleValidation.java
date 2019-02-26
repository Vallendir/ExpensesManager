package pl.expensesmanager.validate;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.billofsale.BillOfSale;

import static pl.expensesmanager.exception.ValidationExceptionFactory.billOfSaleException;

@RequiredArgsConstructor
public class BillOfSaleValidation implements ValidationStrategy {
	
	private final BillOfSale value;
	
	@Override
	public void validate() {
		if (value == null) {
			throw billOfSaleException();
		}
		
		validate(new BillOfSaleDescriptionValidation(value.getDescription()));
		validate(new BillOfSaleBoughtDateValidation(value.getBoughtDate()));
	}
	
}
