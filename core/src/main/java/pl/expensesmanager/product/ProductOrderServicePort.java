package pl.expensesmanager.product;

import pl.expensesmanager.base.BaseService;

import java.util.List;

interface ProductOrderServicePort extends BaseService<ProductOrderPort, String> {
	
	/**
	 * Method to find order by product name.
	 *
	 * @param name - the product name
	 * @return found products
	 */
	List<ProductOrderPort> searchAllByProductName(String name);
	
	/**
	 * Method to find order by product name and price.
	 *
	 * @param name  - the product name
	 * @param price - the product price
	 * @return found product
	 */
	List<ProductOrderPort> searchAllByProductNameAndPrice(String name, Double price);
	
	/**
	 * Method to search product between quanity range.
	 *
	 * @param min - minimal quanity
	 * @param max - maximal quanity
	 * @return found product objects
	 */
	List<ProductOrderPort> searchAllByQuanityRange(Integer min, Integer max);
	
	/**
	 * Method to search product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrderPort> searchAllByBiggerQuanityThan(Integer quanity);
	
	/**
	 * Method to search product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrderPort> searchAllByLessQuanityThan(Integer quanity);
	
}
