package pl.expensesmanager.product;

import lombok.*;
import pl.expensesmanager.base.BaseModel;

/**
 * Representation of Product order.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class ProductOrder extends BaseModel {
	
	private Product product;
	
	private Integer quanity;
	
	public Double summaryPrice() {
		return product.getPrice() * quanity;
	}
	
}
