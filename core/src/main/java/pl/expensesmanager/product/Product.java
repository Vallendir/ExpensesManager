package pl.expensesmanager.product;

import lombok.*;
import pl.expensesmanager.base.BaseModel;

/**
 * Representation of Product.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class Product extends BaseModel {
	
	private String name;
	
	private Double price;
	
}
