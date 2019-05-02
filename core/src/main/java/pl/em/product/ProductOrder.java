package pl.em.product;

import lombok.*;
import pl.em.common.DomainID;
import pl.em.common.DomainModel;

/**
 * Representation of Product Order.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductOrder extends DomainModel {
	
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
