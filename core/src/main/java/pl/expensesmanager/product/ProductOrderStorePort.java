package pl.expensesmanager.product;

import pl.expensesmanager.base.BaseStorage;

import java.util.List;

public interface ProductOrderStorePort extends BaseStorage<ProductOrderPort, String> {
	
	/**
	 * Method to find order by product name.
	 *
	 * @param name - the product name
	 * @return found products
	 */
	List<ProductOrderPort> findByProductName(String name);
	
	/**
	 * Method to find order by product name and price.
	 *
	 * @param name - the product name
	 * @param price - the product price
	 * @return found product
	 */
	List<ProductOrderPort> findByProductNameAndProductPrice(String name, Double price);
	
	/**
	 * Method to find product between quanity range.
	 *
	 * @param min - minimal quanity
	 * @param max - maximal quanity
	 * @return found product objects
	 */
	List<ProductOrderPort> findByQuanityBetween(Integer min, Integer max);
	
	/**
	 * Method to find product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrderPort> findByQuanityGreaterThan(Integer quanity);
	
	/**
	 * Method to find product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrderPort> findByQuanityLessThan(Integer quanity);
	
}
