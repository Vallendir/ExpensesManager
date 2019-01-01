package pl.expensesmanager.domain;

/**
 * Interface repsentate Product quanity. Should be implemented in any place where is created other representation of Product quanity like DTOs etc.
 */
public interface ProductQuanityApi {
	
	/**
	 * Method to get the product.
	 *
	 * @return product
	 */
	ProductApi getProduct();
	
	/**
	 * Method to set the product.
	 *
	 * @param product product
	 */
	void setProduct(ProductApi product);
	
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
