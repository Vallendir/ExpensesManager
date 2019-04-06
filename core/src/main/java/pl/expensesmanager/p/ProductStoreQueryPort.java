package pl.expensesmanager.p;

import pl.expensesmanager.b.BaseStoreQuery;

import java.util.List;

interface ProductStoreQueryPort extends BaseStoreQuery<Product, String> {
	
	/**
	 * Method to find products by name.
	 *
	 * @param name - the name of product
	 * @return found products list
	 */
	List<Product> findByName(String name);
	
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
