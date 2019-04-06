package pl.expensesmanager.product;

import lombok.*;
import pl.expensesmanager.base.BaseModel;

/**
 * Representation of Product order.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class ProductOrder extends BaseModel {
	
	private Product product;
	
	private Integer quanity;
	
	/**
	 * Method to get the summary price of product of quanity.
	 *
	 * @return product summary price
	 */
	public Double summaryPrice() {
		return product.getPrice() * quanity;
	}
	
}
