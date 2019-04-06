package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.EMCommand;

import java.util.Objects;

import static pl.expensesmanager.exception.ValidationExceptionFactory.productException;
import static pl.expensesmanager.util.CoreValidator.validateProductName;
import static pl.expensesmanager.util.CoreValidator.validateProductPrice;

@RequiredArgsConstructor
class ProductRemove implements EMCommand {
	
	private final ProductStoreCommandPort store;
	
	private final String id;
	
	@Override
	public void executeCommand() {
		store.deleteById(id);
	}
	
}
