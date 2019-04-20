package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.EMCommand;
import pl.expensesmanager.b.EMQuery;
import pl.expensesmanager.b.EmId;

import java.util.Objects;

import static pl.expensesmanager.exception.ValidationExceptionFactory.productException;
import static pl.expensesmanager.p.ProductExceptionFactory.productNotRemovedException;
import static pl.expensesmanager.util.CoreValidator.validateProductName;
import static pl.expensesmanager.util.CoreValidator.validateProductPrice;

@RequiredArgsConstructor
class ProductRemove implements EMCommand {
	
	private final ProductStoreCommandPort store;
	
	private final EmId id;
	
	private final EMQuery<Product> query;
	
	@Override
	public void executeCommand() {
		store.deleteById(id);
		
		var deletedProduct = query.executeQuery();
		if(Objects.nonNull(deletedProduct)) {
			throw productNotRemovedException();
		}
	}
	
}
