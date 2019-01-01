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
public class Product extends BaseModel implements ProductPort {
	
	private String name;
	
	private Double price;
	
	private Integer quanity;
	
	@Override
	public Double summaryPrice() {
		return price * quanity;
	}
	
}
