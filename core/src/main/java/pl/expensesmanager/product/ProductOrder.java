package pl.expensesmanager.product;

import lombok.*;

/**
 * Representation of Product order.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class ProductOrder extends ProductOrderPort.BaseModel implements ProductOrderPort {
	
	private ProductPort product;
	
	private Integer quanity;
	
	@Override
	public Double summaryPrice() {
		return product.getPrice() * quanity;
	}
	
}
