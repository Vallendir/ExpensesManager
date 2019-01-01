package pl.expensesmanager.domain;

/**
 * Interface repsentate Product. Should be implemented in any place where is created other representation of Product like DTOs etc.
 */
public interface ProductPort {
	
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
	
	/**
	 * Method to get the quanity of product.
	 *
	 * @return product quanity
	 */
	Integer getQuanity();
	
	/**
	 * Method to set the quanity of product.
	 *
	 * @param quanity the quanity of product
	 */
	void setQuanity(Integer quanity);
	
	/**
	 * Method to get the summary price of all products.
	 *
	 * @return product summary price
	 */
	Double summaryPrice();
	
}
