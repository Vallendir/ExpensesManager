package pl.expensesmanager.billofsale;

import lombok.*;
import pl.expensesmanager.base.BaseModel;
import pl.expensesmanager.product.ProductOrder;

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
@EqualsAndHashCode(callSuper = true)
public final class BillOfSale extends BaseModel {
	
	private List<ProductOrder> productList;
	
	private Instant boughtDate;
	
	private String description;
	
	/**
	 * Method to get the final price of bill of sale.
	 *
	 * @return the final price of bill of sale
	 */
	public Double finalPrice() {
		return productList.stream()
		                  .mapToDouble(ProductOrder::summaryPrice)
		                  .summaryStatistics()
		                  .getSum();
	}
	
}
