package pl.em.product;

import lombok.*;
import pl.em.common.DomainID;
import pl.em.common.DomainModel;

/**
 * Representation of Product.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public final class Product extends DomainModel {
	
	private DomainID productId;
	
	private String name;
	
	private Double price;
	
}
