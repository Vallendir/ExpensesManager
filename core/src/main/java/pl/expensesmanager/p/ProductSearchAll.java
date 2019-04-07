package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.EMQuery;
import pl.expensesmanager.b.EMQueryList;
import pl.expensesmanager.exception.BusinessLogicExceptionFactory;
import pl.expensesmanager.p.ProductFiltering.Filter;

import java.util.List;

@RequiredArgsConstructor
class ProductSearchAll implements EMQueryList<Product> {
	
	private final ProductStoreQueryPort query;
	
	private final Filter filter;
	
	@Override
	public List<Product> executeQuery() {
		switch (filter) {
			case ALL:
				return query.findAll();
			case NAME:
				var name = String.valueOf(filter.getParameters()[0]);
				return query.findByName(name);
			case PRICE_RANGE:
				var min = Double.valueOf(filter.getParameters()[0].toString());
				var max = Double.valueOf(filter.getParameters()[1].toString());
				return query.findByPriceBetween(min, max);
			case PRICE_CHEAPER:
				var cheaper = Double.valueOf(filter.getParameters()[0].toString());
				return query.findByPriceGreaterThan(cheaper);
			case PRICE_EXPENSIVE:
				var expensive = Double.valueOf(filter.getParameters()[0].toString());
				return query.findByPriceLessThan(expensive);
			default:
				return null;
		}
	}
	
}
