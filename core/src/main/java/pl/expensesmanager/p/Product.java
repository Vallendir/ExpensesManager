package pl.expensesmanager.p;

import lombok.*;
import pl.expensesmanager.b.EmId;
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
	
	private EmId id;
	
	private String name;
	
	private Double price;
	
}
