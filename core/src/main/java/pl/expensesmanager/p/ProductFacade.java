package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.CQRSHandler;
import pl.expensesmanager.b.EmId;
import pl.expensesmanager.p.ProductFiltering.Filter;

import java.util.List;
import java.util.Objects;

import static pl.expensesmanager.p.ProductExceptionFactory.productIdInvalidException;
import static pl.expensesmanager.p.ProductExceptionFactory.productIsNullException;
import static pl.expensesmanager.util.BasicValidator.validateMinMaxValue;
import static pl.expensesmanager.util.CoreValidator.validateProductName;
import static pl.expensesmanager.util.CoreValidator.validateProductPrice;

@RequiredArgsConstructor
public class ProductFacade {
	
	private final ProductStoreQueryPort query;
	
	private final ProductStoreCommandPort command;
	
	private final CQRSHandler handler;
	
	public void create(Product product) {
		checkIfPassedProductIsNull(product);
		
		handler.executeCommand(new ProductCreate(command, product));
	}
	
	public Product findById(String id) {
		var idObject = new EmId(id);
		checkIfPassedIdIsValid(idObject);
		
		return handler.executeQuery(new ProductSearch(query, Filter.ID.of(idObject)));
	}
	
	public void update(String id, Product changes) {
		var idObject = new EmId(id);
		checkIfPassedIdIsValid(idObject);
		checkIfPassedProductIsNull(changes);
		
		handler.executeCommand(new ProductUpdate(command, changes, new ProductSearch(query, Filter.ID.of(idObject))));
	}
	
	public void remove(String id) {
		var idObject = new EmId(id);
		checkIfPassedIdIsValid(idObject);
		
		handler.executeCommand(new ProductRemove(command, idObject, new ProductSearch(query, Filter.ID.of(idObject))));
	}
	
	public List<Product> findAll() {
		return handler.executeQuery(new ProductSearchAll(query, Filter.ALL));
	}
	
	public List<Product> findByName(String name) {
		return handler.executeQuery(new ProductSearchAll(query, Filter.NAME.of(name)));
	}
	
	public List<Product> findByPriceRange(double min, double max) {
		return handler.executeQuery(new ProductSearchAll(query, Filter.PRICE_RANGE.of(min, max), List.of(new ValidateProductPrice(), new ValidateProductPriceMinMax(min, max))));
	}
	
	public List<Product> findByPriceCheaperThan(double price) {
		return handler.executeQuery(new ProductSearchAll(query, Filter.PRICE_CHEAPER.of(price), List.of(new ValidateProductPrice())));
	}
	
	public List<Product> findByPriceExpensiveThan(double price) {
		return handler.executeQuery(new ProductSearchAll(query, Filter.PRICE_EXPENSIVE.of(price), List.of(new ValidateProductPrice())));
	}
	
	private void checkIfPassedIdIsValid(EmId id) {
		if (!query.isValid(id)) {
			throw productIdInvalidException();
		}
	}
	
	private void checkIfPassedProductIsNull(Product product) {
		if (Objects.isNull(product)) {
			throw productIsNullException();
		}
	}
	
}
