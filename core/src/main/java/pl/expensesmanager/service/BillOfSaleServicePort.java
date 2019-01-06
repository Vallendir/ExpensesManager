package pl.expensesmanager.service;

import pl.expensesmanager.domain.BillOfSalePort;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface BillOfSaleServicePort extends BaseService<BillOfSalePort, String> {
	
	/**
	 * Method to search bill of sale by description.
	 *
	 * @param description - the description of bill of sale
	 * @return found bill of sale as optional
	 */
	Optional<BillOfSalePort> searchForDescription(String description);
	
	/**
	 * Method to search bill of sale by bought date.
	 *
	 * @param boughtDate - the bought date of bill of sale
	 * @return found bills of sale list
	 */
	List<BillOfSalePort> searchForBoughtDate(Instant boughtDate);
	
	/**
	 * Method to search bill of sale by bought date range.
	 *
	 * @param min - start bought date
	 * @param max - end bought date
	 * @return found bills of sale list
	 */
	List<BillOfSalePort> searchAllForBoughtDateRange(Instant min, Instant max);
	
}
