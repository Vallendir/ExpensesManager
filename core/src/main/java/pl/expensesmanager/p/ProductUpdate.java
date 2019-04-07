package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.EMCommand;
import pl.expensesmanager.b.EMQuery;
import pl.expensesmanager.util.MergeUtil;

import java.util.Objects;
import java.util.Optional;

import static pl.expensesmanager.exception.ValidationExceptionFactory.productException;
import static pl.expensesmanager.util.CoreValidator.validateProductName;
import static pl.expensesmanager.util.CoreValidator.validateProductPrice;

@RequiredArgsConstructor
class ProductUpdate implements EMCommand {
	
	private final ProductStoreCommandPort save;
	
	private final Product changes;
	
	private final EMQuery<Product> query;
	
	@Override
	public void executeCommand() {
		var found = query.executeQuery();
		
		var update = new ProductCreate(save, MergeUtil.merge(found, changes));
		update.executeCommand();
	}
	
}
