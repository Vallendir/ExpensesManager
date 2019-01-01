package pl.expensesmanager.storage;

import pl.expensesmanager.domain.ProductApi;

import java.util.List;
import java.util.Optional;

public interface ProductStore extends BaseStorage<ProductApi, String> {
	
	/**
	 * Method to find product by name.
	 *
	 * @param name - the name of product
	 * @return found product as optional
	 */
	Optional<ProductApi> findByName(String name);
	
	/**
	 * Method to find products by price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductApi> findByPrice(Double price);
	
	/**
	 * Method to find product between price range.
	 *
	 * @param min - minimal price
	 * @param max - maximal price
	 * @return found product objects
	 */
	List<ProductApi> findByPriceBetween(Double min, Double max);
	
	/**
	 * Method to find product more expensive than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductApi> findByPriceGreaterThan(Double price);
	
	/**
	 * Method to find product cheaper than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductApi> findByPriceLessThan(Double price);
	
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
