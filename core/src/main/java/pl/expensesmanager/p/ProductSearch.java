package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.EMQuery;
import pl.expensesmanager.b.EmId;
import pl.expensesmanager.p.ProductFiltering.Filter;

@RequiredArgsConstructor
class ProductSearch implements EMQuery<Product> {
	
	private final ProductStoreQueryPort query;
	
	private final Filter filter;
	
	@Override
	public Product executeQuery() {
		switch (filter) {
			case ID:
				var id = EmId.fromObject(filter.getParameters()[0]);
				
				return query.findById(id)
				            .orElseThrow(ProductExceptionFactory::productNotFoundException);
			default:
				return null;
		}
	}
	
}
