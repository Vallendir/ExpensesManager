package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.EMCommand;

import java.util.Objects;
import java.util.Optional;

import static pl.expensesmanager.exception.ValidationExceptionFactory.productException;
import static pl.expensesmanager.util.CoreValidator.validateProductName;
import static pl.expensesmanager.util.CoreValidator.validateProductPrice;

@RequiredArgsConstructor
class ProductCreate implements EMCommand {
	
	private final ProductStoreCommandPort store;
	
	private final Product productToCreate;
	
	@Override
	public void executeCommand() {
		if (Objects.isNull(productToCreate)) {
			throw productException();
		}
		productToCreate.setName(validateProductName(productToCreate.getName()));
		validateProductPrice(productToCreate.getPrice());
		
		Optional<Product> saved = store.save(productToCreate);
		if(!saved.isPresent()) {
			throw productException();
		}
	}
	
}
