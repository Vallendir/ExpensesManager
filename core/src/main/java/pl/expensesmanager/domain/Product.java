package pl.expensesmanager.domain;

import lombok.*;

/**
 * Representation of Product.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseModel implements ProductApi {
	
	private String name;
	
	private Double price;
	
}
