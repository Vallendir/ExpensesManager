package pl.expensesmanager.storage;

import pl.expensesmanager.domain.BillOfSalePort;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface BillOfSaleStorePort extends BaseStorage<BillOfSalePort, String> {
	
	/**
	 * Method to find bill of sale by description.
	 *
	 * @param description - the description of bill of sale
	 * @return found bill of sale as optional
	 */
	Optional<BillOfSalePort> findByDescription(String description);
	
	/**
	 * Method to find bill of sale by bought date.
	 *
	 * @param boughtDate - the bought date of bill of sale
	 * @return found bills of sale list
	 */
	List<BillOfSalePort> findByBoughtDate(Instant boughtDate);
	
	/**
	 * Method to find bill of sale by bought date range.
	 *
	 * @param min - start bought date
	 * @param max - end bought date
	 * @return found bills of sale list
	 */
	List<BillOfSalePort> findByBoughtDateBetween(Instant min, Instant max);
	
}
