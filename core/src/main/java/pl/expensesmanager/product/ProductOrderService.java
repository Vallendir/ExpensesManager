package pl.expensesmanager.product;

import org.springframework.stereotype.Service;
import pl.expensesmanager.base.BaseService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.productOrderNotFoundException;
import static pl.expensesmanager.exception.ValidationExceptionFactory.*;
import static pl.expensesmanager.util.CoreValidator.*;

@Service
final class ProductOrderService extends BaseService<ProductOrder> {
	
	private ProductOrderStorePort storage;
	
	ProductOrderService(ProductOrderStorePort storage) {
		super(storage);
		this.storage = storage;
	}
	
	/**
	 * Method to find order by product name.
	 *
	 * @param name - the product name
	 * @return found products
	 */
	List<ProductOrder> searchAllByProductName(String name) {
		return storage.findByProductName(validateProductName(name));
	}
	
	/**
	 * Method to find order by product name and price.
	 *
	 * @param name  - the product name
	 * @param price - the product price
	 * @return found product
	 */
	Optional<ProductOrder> searchAllByProductNameAndProductPrice(String name, Double price) {
		return storage.findByProductNameAndProductPrice(validateProductName(name), validateProductPrice(price));
	}
	
	/**
	 * Method to search product between quanity range.
	 *
	 * @param min - minimal quanity
	 * @param max - maximal quanity
	 * @return found product objects
	 */
	List<ProductOrder> searchAllByQuanityRange(Integer min, Integer max) {
		validateMinMaxValue(validateOrderQuanity(min), validateOrderQuanity(max));
		
		return storage.findByQuanityBetween(min, max);
	}
	
	/**
	 * Method to search product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrder> searchAllByBiggerQuanityThan(Integer quanity) {
		return storage.findByQuanityGreaterThan(validateOrderQuanity(quanity));
	}
	
	/**
	 * Method to search product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrder> searchAllByLessQuanityThan(Integer quanity) {
		return storage.findByQuanityLessThan(validateOrderQuanity(quanity));
	}
	
	ProductOrder create(ProductOrder object) {
		return createObject(() -> {
			if (Objects.isNull(object)) {
				throw orderException();
			}
			
			validateProduct(object.getProduct());
			validateOrderQuanity(object.getQuanity());
			
			return object;
		});
	}
	
	ProductOrder update(ProductOrder originalObject, ProductOrder changes) {
		return updateObject(originalObject, changes);
	}
	
	ProductOrder update(ProductOrder changes, String id) {
		return updateObject(changes, id, () -> productOrderNotFoundException());
	}
	
	@Override
	protected void checkChangesIn(ProductOrder changes, ProductOrder originalObject) {
		if (Objects.isNull(originalObject.getQuanity()) && Objects.nonNull(changes.getQuanity()) || Objects.nonNull(
			originalObject.getQuanity()) && Objects.nonNull(changes.getQuanity())) {
			validateOrderQuanity(changes.getQuanity());
		} else if (Objects.nonNull(originalObject.getQuanity()) && Objects.isNull(changes.getQuanity())) {
			validateOrderQuanity(originalObject.getQuanity());
		} else {
			throw productQuanityException();
		}
		
		if (Objects.isNull(originalObject.getProduct()) && Objects.nonNull(changes.getProduct()) || Objects.nonNull(
			originalObject.getProduct()) && Objects.nonNull(changes.getProduct())) {
			validateProduct(changes.getProduct());
		} else if (Objects.nonNull(originalObject.getProduct()) && Objects.isNull(changes.getProduct())) {
			validateProduct(originalObject.getProduct());
		} else {
			throw productException();
		}
	}
	
}
