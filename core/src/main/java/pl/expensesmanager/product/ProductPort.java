package pl.expensesmanager.product;

import pl.expensesmanager.base.BaseModelPort;

/**
 * Interface repsentate Product. Should be implemented in any place where is created other representation of Product like DTOs etc.
 */
public interface ProductPort extends BaseModelPort {
	
	/**
	 * Method to get the name of product.
	 *
	 * @return product name
	 */
	String getName();
	
	/**
	 * Method to set the name of product.
	 *
	 * @param name the name of product
	 */
	void setName(String name);
	
	/**
	 * Method to get the price of product.
	 *
	 * @return product price
	 */
	Double getPrice();
	
	/**
	 * Method to set the price of product.
	 *
	 * @param price the price of product
	 */
	void setPrice(Double price);
	
}
