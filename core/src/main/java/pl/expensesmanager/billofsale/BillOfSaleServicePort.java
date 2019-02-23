package pl.expensesmanager.billofsale;

import pl.expensesmanager.base.BaseService;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

interface BillOfSaleServicePort extends BaseService<BillOfSalePort, String> {
	
	/**
	 * Method to search bill of sale by description.
	 *
	 * @param description - the description of bill of sale
	 * @return found bill of sale as optional
	 */
	Optional<BillOfSalePort> searchByDescription(String description);
	
	/**
	 * Method to search bill of sale by bought date.
	 *
	 * @param boughtDate - the bought date of bill of sale
	 * @return found bills of sale list
	 */
	List<BillOfSalePort> searchAllByBoughtDate(Instant boughtDate);
	
	/**
	 * Method to search bill of sale by bought date range.
	 *
	 * @param min - start bought date
	 * @param max - end bought date
	 * @return found bills of sale list
	 */
	List<BillOfSalePort> searchAllByBoughtDateRange(Instant min, Instant max);
	
}
