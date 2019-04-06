package pl.expensesmanager.p;

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
@EqualsAndHashCode
public class Product {
	
	private String id;
	
	private String name;
	
	private Double price;
	
}
