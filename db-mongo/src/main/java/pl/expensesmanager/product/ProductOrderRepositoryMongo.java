package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Profile("mongo")
@Repository
public interface ProductOrderRepositoryMongo extends MongoRepository<ProductOrderDocument, String> {
	
	/**
	 * Method to find order by product name.
	 *
	 * @param name - the product name
	 * @return found products
	 */
	@Query(value = "{'product.name' : ?0}")
	List<ProductOrderDocument> findByProductName(String name);
	
	/**
	 * Method to find order by product name and price.
	 *
	 * @param name  - the product name
	 * @param price - the product price
	 * @return found product
	 */
	@Query(value = "{'product.name' : ?0, 'product.price' : ?1}")
	Optional<ProductOrderDocument> findByProductNameAndProductPrice(String name, Double price);
	
	/**
	 * Method to find product between quanity range.
	 *
	 * @param min - minimal quanity
	 * @param max - maximal quanity
	 * @return found product objects
	 */
	List<ProductOrderDocument> findByQuanityBetween(Integer min, Integer max);
	
	/**
	 * Method to find product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrderDocument> findByQuanityGreaterThan(Integer quanity);
	
	/**
	 * Method to find product which have more quanity than value.
	 *
	 * @param quanity - quanity
	 * @return found product objects
	 */
	List<ProductOrderDocument> findByQuanityLessThan(Integer quanity);
	
}
