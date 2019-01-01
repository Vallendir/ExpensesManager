package pl.expensesmanager.domain;

import java.time.Instant;
import java.util.List;

/**
 * Interface repsentate Bill Of Sale. Should be implemented in any place where is created other representation of Bill Of Sale like DTOs etc.
 */
public interface BillOfSalePort {
	
	/**
	 * Method to get the products list.
	 *
	 * @return products list
	 */
	List<ProductPort> getProductList();
	
	/**
	 * Method to set the products list.
	 *
	 * @param productList products list
	 */
	void setProductList(List<ProductPort> productList);
	
	/**
	 * Method to get the bought date of bill of sale.
	 *
	 * @return the bought date of bill of sale
	 */
	Instant getBoughtDate();
	
	/**
	 * Method to set the bought date of bill of sale.
	 *
	 * @param boughtDate the bought date of bill of sale
	 */
	void setBoughtDate(Instant boughtDate);
	
	/**
	 * Method to get the description of bill of sale.
	 *
	 * @return the description of bill of sale
	 */
	String getDescription();
	
	/**
	 * Method to set the description of bill of sale.
	 *
	 * @param description the description of bill of sale
	 */
	void setDescription(String description);
	
	/**
	 * Method to get the final price of bill of sale.
	 *
	 * @return the final price of bill of sale
	 */
	Double finalPrice();
	
}
