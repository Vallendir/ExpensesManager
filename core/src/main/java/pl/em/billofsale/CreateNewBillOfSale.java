package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainCommand;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
final class CreateNewBillOfSale implements DomainCommand<BillOfSale> {
	
	private final Function<BillOfSale, Optional<BillOfSale>> createFunction;
	
	private final BillOfSale toSave;
	
	private final BillOfSaleValidator validator;
	
	@Override
	public BillOfSale execute() {
		validator.validateDescription();
		validator.validateBoughtDate();
		validator.validateOrders();
		
		return createFunction.apply(toSave)
		                     .orElseThrow(
			                     BillOfSaleExceptionFactory::billOfSaleNotSaved
		                     );
	}
	
}
