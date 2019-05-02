package pl.em.order;

import lombok.*;
import pl.em.common.DomainID;
import pl.em.common.DomainModel;
import pl.em.product.Product;

/**
 * Representation of Product Order.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public final class Order extends DomainModel {
	
	private DomainID orderId;
	
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
