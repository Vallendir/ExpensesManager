package pl.expensesmanager.billofsale;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Profile("dev")
@Repository
public interface BillOfSaleRepositoryMongo extends MongoRepository<BillOfSaleDocument, String> {
	
	/**
	 * Method to find bill of sale by description.
	 *
	 * @param description - the description of bill of sale
	 * @return found bill of sale as optional
	 */
	Optional<BillOfSaleDocument> findByDescription(String description);
	
	/**
	 * Method to find bill of sale by bought date.
	 *
	 * @param boughtDate - the bought date of bill of sale
	 * @return found bills of sale list
	 */
	List<BillOfSaleDocument> findByBoughtDate(Instant boughtDate);
	
	/**
	 * Method to find bill of sale by bought date range.
	 *
	 * @param min - start bought date
	 * @param max - end bought date
	 * @return found bills of sale list
	 */
	List<BillOfSaleDocument> findByBoughtDateBetween(Instant min, Instant max);
	
}
