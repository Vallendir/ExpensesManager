package pl.em.order;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainCommand;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
final class CreateNewOrder implements DomainCommand<Order> {
	
	private final Function<Order, Optional<Order>> createFunction;
	
	private final Order toSave;
	
	private final OrderValidator validator;
	
	@Override
	public Order execute() {
		validator.validateProduct();
		validator.validateQuanity();
		
		return createFunction.apply(toSave)
		                     .orElseThrow(
		                     	OrderExceptionFactory::orderNotSaved
		                     );
	}
	
}
