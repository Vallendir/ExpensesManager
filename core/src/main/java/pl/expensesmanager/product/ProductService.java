package pl.expensesmanager.product;

import org.springframework.stereotype.Service;
import pl.expensesmanager.base.BaseService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.productNotFoundException;
import static pl.expensesmanager.exception.ValidationExceptionFactory.productNameException;
import static pl.expensesmanager.exception.ValidationExceptionFactory.productPriceException;
import static pl.expensesmanager.util.CoreValidator.*;

@Service
final class ProductService extends BaseService<Product> {
	
	private ProductStorePort storage;
	
	ProductService(ProductStorePort storage) {
		super(storage);
		this.storage = storage;
	}
	
	/**
	 * Method to search products by name.
	 *
	 * @param name - the name of product
	 * @return found products list
	 */
	List<Product> searchByName(String name) {
		return storage.findByName(validateProductName(name));
	}
	
	/**
	 * Method to find product by name and price.
	 *
	 * @param name  - the name of product
	 * @param price - the price of product
	 * @return found product as optional
	 */
	Optional<Product> searchByNameAndPrice(String name, Double price) {
		return storage.findByNameAndPrice(validateProductName(name), validateProductPrice(price));
	}
	
	/**
	 * Method to search products between price range.
	 *
	 * @param min - minimal price
	 * @param max - maximal price
	 * @return found product objects
	 */
	List<Product> searchAllByPriceRange(Double min, Double max) {
		validateMinMaxValue(validateProductPrice(min), validateProductPrice(max));
		
		return storage.findByPriceBetween(min, max);
	}
	
	/**
	 * Method to search products more expensive than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<Product> searchAllExpensiveThan(Double price) {
		return storage.findByPriceGreaterThan(validateProductPrice(price));
	}
	
	/**
	 * Method to search product cheaper than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<Product> searchAllCheaperThan(Double price) {
		return storage.findByPriceLessThan(validateProductPrice(price));
	}
	
	Product create(Product object) {
		return createObject(() -> validateProduct(object));
	}
	
	Product update(Product originalObject, Product changes) {
		return updateObject(originalObject, changes);
	}
	
	Product update(Product changes, String id) {
		return updateObject(changes, id, () -> productNotFoundException());
	}
	
	@Override
	protected void checkChangesIn(Product changes, Product originalObject) {
		if (Objects.isNull(originalObject.getName()) && Objects.nonNull(changes.getName()) || Objects.nonNull(
			originalObject.getName()) && Objects.nonNull(changes.getName())) {
			validateProductName(changes.getName());
		} else if (Objects.nonNull(originalObject.getName()) && Objects.isNull(changes.getName())) {
			validateProductName(originalObject.getName());
		} else {
			throw productNameException();
		}
		
		if (Objects.isNull(originalObject.getPrice()) && Objects.nonNull(changes.getPrice()) || Objects.nonNull(
			originalObject.getPrice()) && Objects.nonNull(changes.getPrice())) {
			validateProductPrice(changes.getPrice());
		} else if (Objects.nonNull(originalObject.getPrice()) && Objects.isNull(changes.getPrice())) {
			validateProductPrice(originalObject.getPrice());
		} else {
			throw productPriceException();
		}
	}
	
}
