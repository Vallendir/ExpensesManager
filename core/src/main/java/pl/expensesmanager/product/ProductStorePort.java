package pl.expensesmanager.product;

import pl.expensesmanager.base.BaseStorage;

import java.util.List;
import java.util.Optional;

public interface ProductStorePort extends BaseStorage<Product, String> {
	
	/**
	 * Method to find products by name.
	 *
	 * @param name - the name of product
	 * @return found products list
	 */
	List<Product> findByName(String name);
	
	/**
	 * Method to find product by name and price.
	 *
	 * @param name  - the name of product
	 * @param price - the price of product
	 * @return found product as optional
	 */
	Optional<Product> findByNameAndPrice(String name, Double price);
	
	/**
	 * Method to find products by price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<Product> findByPrice(Double price);
	
	/**
	 * Method to find product between price range.
	 *
	 * @param min - minimal price
	 * @param max - maximal price
	 * @return found product objects
	 */
	List<Product> findByPriceBetween(Double min, Double max);
	
	/**
	 * Method to find product more expensive than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<Product> findByPriceGreaterThan(Double price);
	
	/**
	 * Method to find product cheaper than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<Product> findByPriceLessThan(Double price);
	
}
