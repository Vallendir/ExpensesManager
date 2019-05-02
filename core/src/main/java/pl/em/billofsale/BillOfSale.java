package pl.em.billofsale;

import lombok.*;
import pl.em.common.DomainID;
import pl.em.common.DomainModel;
import pl.em.product.ProductOrder;

import java.time.Instant;
import java.util.List;

/**
 * Representation of Bill of sale.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BillOfSale extends DomainModel {
	
	private DomainID billId;
	
	private List<ProductOrder> ordersList;
	
	private Instant boughtDate;
	
	private String description;
	
	/**
	 * Method to get the final price of bill of sale.
	 *
	 * @return the final price of bill of sale
	 */
	public Double finalPrice() {
		return ordersList.stream()
		                  .mapToDouble(ProductOrder::summaryPrice)
		                  .summaryStatistics()
		                  .getSum();
	}
	
}
