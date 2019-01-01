package pl.expensesmanager.storage;

import pl.expensesmanager.domain.ProductPort;

import java.util.List;
import java.util.Optional;

public interface ProductStorePort extends BaseStorage<ProductPort, String> {
	
	/**
	 * Method to find product by name.
	 *
	 * @param name - the name of product
	 * @return found product as optional
	 */
	Optional<ProductPort> findByName(String name);
	
	/**
	 * Method to find products by price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductPort> findByPrice(Double price);
	
	/**
	 * Method to find product between price range.
	 *
	 * @param min - minimal price
	 * @param max - maximal price
	 * @return found product objects
	 */
	List<ProductPort> findByPriceBetween(Double min, Double max);
	
	/**
	 * Method to find product more expensive than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductPort> findByPriceGreaterThan(Double price);
	
	/**
	 * Method to find product cheaper than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductPort> findByPriceLessThan(Double price);
	
	/**
	 * Method to find product between quanity range.
	 *
	 * @param min - minimal quanity
	 * @param max - maximal quanity
	 * @return found product objects
	 */
	List<ProductPort> findByQuanityBetween(Double min, Double max);
	
	/**
	 * Method to find product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductPort> findByQuanityGreaterThan(Double quanity);
	
	/**
	 * Method to find product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductPort> findByQuanityLessThan(Double quanity);
	
}
