package pl.expensesmanager.product;

import pl.expensesmanager.base.BaseModelPort;

/**
 * Interface repsentate Product order. Should be implemented in any place where is created other representation of Product order like DTOs etc.
 */
public interface ProductOrderPort extends BaseModelPort {
	
	/**
	 * Method to get the product.
	 *
	 * @return product
	 */
	ProductPort getProduct();
	
	/**
	 * Method to set the product.
	 *
	 * @param product the product
	 */
	void setProduct(ProductPort product);
	
	/**
	 * Method to get the quanity of products.
	 *
	 * @return product quanity
	 */
	Integer getQuanity();
	
	/**
	 * Method to set the quanity of products.
	 *
	 * @param quanity the quanity of product
	 */
	void setQuanity(Integer quanity);
	
	/**
	 * Method to get the summary price of product with quanity.
	 *
	 * @return product summary price
	 */
	Double summaryPrice();
	
}
