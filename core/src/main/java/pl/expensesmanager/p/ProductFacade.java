package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.CQRSHandler;
import pl.expensesmanager.p.ProductFiltering.Filter;

import java.util.List;

import static pl.expensesmanager.util.BasicValidator.validateMinMaxValue;
import static pl.expensesmanager.util.CoreValidator.validateProductName;
import static pl.expensesmanager.util.CoreValidator.validateProductPrice;

@RequiredArgsConstructor
public class ProductFacade {
	
	private final ProductStoreQueryPort query;
	
	private final ProductStoreCommandPort command;
	
	private final CQRSHandler handler;
	
	public void create(Product product) {
		handler.executeCommand(new ProductCreate(command, product));
	}
	
	public Product findById(String id) {
		return handler.executeQuery(new ProductSearch(query, Filter.ID.of(id)));
	}
	
	public void update(String id, Product changes) {
		handler.executeCommand(new ProductUpdate(command, changes, new ProductSearch(query, Filter.ID.of(id))));
	}
	
	public void remove(String id) {
		handler.executeCommand(new ProductRemove(command, id));
	}
	
	public List<Product> findAll() {
		return handler.executeQuery(new ProductSearchAll(query, Filter.ALL));
	}
	
	public List<Product> findByName(String name) {
		return handler.executeQuery(new ProductSearchAll(query, Filter.NAME.of(validateProductName(name))));
	}
	
	public List<Product> findByPriceRange(double min, double max) {
		validateMinMaxValue(validateProductPrice(min), validateProductPrice(max));
		return handler.executeQuery(new ProductSearchAll(query, Filter.PRICE_RANGE.of(min, max)));
	}
	
	public List<Product> findByPriceCheaperThan(double price) {
		return handler.executeQuery(new ProductSearchAll(query, Filter.PRICE_CHEAPER.of(validateProductPrice(price))));
	}
	
	public List<Product> findByPriceExpensiveThan(double price) {
		return handler.executeQuery(
			new ProductSearchAll(query, Filter.PRICE_EXPENSIVE.of(validateProductPrice(price))));
	}
	
}
