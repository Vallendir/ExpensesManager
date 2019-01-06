package pl.expensesmanager.service;

import pl.expensesmanager.domain.ProductPort;

import java.util.List;
import java.util.Optional;

public interface ProductServicePort extends BaseService<ProductPort, String> {
	
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
	
	/**
	 * Method to search product between quanity range.
	 *
	 * @param min - minimal quanity
	 * @param max - maximal quanity
	 * @return found product objects
	 */
	List<ProductPort> searchAllForQuanityRange(Integer min, Integer max);
	
	/**
	 * Method to search product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductPort> searchAllForQuanityGreater(Integer quanity);
	
	/**
	 * Method to search product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductPort> searchAllForQuanityLower(Integer quanity);
	
}
