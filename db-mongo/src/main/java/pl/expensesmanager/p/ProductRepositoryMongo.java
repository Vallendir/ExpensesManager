package pl.expensesmanager.p;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Profile("mongo")
@Repository
interface ProductRepositoryMongo extends MongoRepository<ProductDocument, String> {
	
	/**
	 * Method to find products by name.
	 *
	 * @param name - the name of product
	 * @return found products list
	 */
	List<ProductDocument> findByName(String name);
	
	/**
	 * Method to find products by price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductDocument> findByPrice(Double price);
	
	/**
	 * Method to find product between price range.
	 *
	 * @param min - minimal price
	 * @param max - maximal price
	 * @return found product objects
	 */
	List<ProductDocument> findByPriceBetween(Double min, Double max);
	
	/**
	 * Method to find product more expensive than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductDocument> findByPriceGreaterThan(Double price);
	
	/**
	 * Method to find product cheaper than price.
	 *
	 * @param price - price
	 * @return found product objects
	 */
	List<ProductDocument> findByPriceLessThan(Double price);
	
}