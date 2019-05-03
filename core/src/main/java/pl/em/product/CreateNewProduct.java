package pl.em.product;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainCommand;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
final class CreateNewProduct implements DomainCommand<Product> {
	
	private final Function<Product, Optional<Product>> createFunction;
	
	private final Product toSave;
	
	private final ProductValidator validator;
	
	@Override
	public Product execute() {
		validator.validateName();
		validator.validatePrice();
		
		return createFunction.apply(toSave)
		                     .orElseThrow(
		                     	ProductExceptionFactory::productNotSaved
		                     );
	}
	
}
