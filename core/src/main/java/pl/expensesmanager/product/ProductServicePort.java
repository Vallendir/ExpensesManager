package pl.expensesmanager.product;

import pl.expensesmanager.base.BaseService;

import java.util.List;
import java.util.Optional;

interface ProductServicePort extends BaseService<Product, String> {
	
	/**
	 * Method to search products by name.
	 *
	 * @param name - the name of product
	 * @return found products list
	 */
	List<Product> searchByName(String name);
	
	/**
	 * Method to find product by name and price.
	 *
	 * @param name  - the name of product
	 * @param price - the price of product
	 * @return found product as optional
	 */
	Optional<Product> searchByNameAndPrice(String name, Double price);
	
	/**
	 * Method to search products between price range.
	 *
	 * @param min - minimal price
	 * @param max - maximal price
	 * @return found product objects
	 */
	List<Product> searchAllByPriceRange(Double min, Double max);
	
	/**
	 * Method to search products more expensive than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<Product> searchAllExpensiveThan(Double price);
	
	/**
	 * Method to search product cheaper than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<Product> searchAllCheaperThan(Double price);
	
}
