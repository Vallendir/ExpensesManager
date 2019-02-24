package pl.expensesmanager.product;

import pl.expensesmanager.base.BaseStorage;

import java.util.List;
import java.util.Optional;

public interface ProductOrderStorePort extends BaseStorage<ProductOrder, String> {
	
	/**
	 * Method to find order by product name.
	 *
	 * @param name - the product name
	 * @return found products
	 */
	List<ProductOrder> findByProductName(String name);
	
	/**
	 * Method to find order by product name and price.
	 *
	 * @param name  - the product name
	 * @param price - the product price
	 * @return found product
	 */
	Optional<ProductOrder> findByProductNameAndProductPrice(String name, Double price);
	
	/**
	 * Method to find product between quanity range.
	 *
	 * @param min - minimal quanity
	 * @param max - maximal quanity
	 * @return found product objects
	 */
	List<ProductOrder> findByQuanityBetween(Integer min, Integer max);
	
	/**
	 * Method to find product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrder> findByQuanityGreaterThan(Integer quanity);
	
	/**
	 * Method to find product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrder> findByQuanityLessThan(Integer quanity);
	
}
