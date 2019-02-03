package pl.expensesmanager.product;

import pl.expensesmanager.base.BaseService;

import java.util.List;
import java.util.Optional;

interface ProductServicePort extends BaseService<ProductPort, String> {
	
	/**
	 * Method to search product by name.
	 *
	 * @param name - the name of product
	 * @return found product as optional
	 */
	Optional<ProductPort> searchForName(String name);
	
	/**
	 * Method to search products between price range.
	 *
	 * @param min - minimal price
	 * @param max - maximal price
	 * @return found product objects
	 */
	List<ProductPort> searchAllForPriceRange(Double min, Double max);
	
	/**
	 * Method to search products more expensive than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductPort> searchAllForPriceGreater(Double price);
	
	/**
	 * Method to search product cheaper than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductPort> searchAllForPriceLower(Double price);
	
}
