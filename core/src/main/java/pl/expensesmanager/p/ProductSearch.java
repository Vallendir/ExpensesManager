package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.EMQuery;
import pl.expensesmanager.exception.BusinessLogicExceptionFactory;
import pl.expensesmanager.p.ProductFiltering.Filter;

@RequiredArgsConstructor
class ProductSearch implements EMQuery<Product> {
	
	private final ProductStoreQueryPort query;
	
	private final Filter filter;
	
	@Override
	public Product executeQuery() {
		switch (filter) {
			case ID:
				var id = String.valueOf(filter.getParameters()[0]);
				return query.findById(id).orElseThrow(BusinessLogicExceptionFactory::productNotFoundException);
			default:
				return null;
		}
	}
	
}
