package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.EMCommand;
import pl.expensesmanager.b.Validator;

import java.util.List;

import static pl.expensesmanager.p.ProductExceptionFactory.productCannotBeCreatedException;

@RequiredArgsConstructor
class ProductCreate implements EMCommand {
	
	private final ProductStoreCommandPort store;
	
	private final Product productToCreate;
	
	private List<Validator<Product>> validators = List.of(new ValidateProductName(), new ValidateProductPrice());
	
	@Override
	public void executeCommand() {
		validators.forEach(validator -> validator.validate(productToCreate));
		
		var saved = store.save(productToCreate);
		if (!saved.isPresent()) {
			throw productCannotBeCreatedException();
		}
	}
	
}
