package pl.expensesmanager.product;

import lombok.*;

/**
 * Representation of Product.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public final class Product extends ProductPort.BaseModel implements ProductPort {
	
	private String name;
	
	private Double price;
	
	private Integer quanity;
	
	@Override
	public Double summaryPrice() {
		return price * quanity;
	}
	
}
