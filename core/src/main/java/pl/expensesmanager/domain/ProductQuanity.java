package pl.expensesmanager.domain;

import lombok.*;

/**
 * Representation of Product quanity.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductQuanity extends BaseModel implements ProductQuanityApi {
	
	private ProductApi product;
	
	private Integer quanity;
	
	@Override
	public Double summaryPrice() {
		return product.getPrice() * quanity;
	}
	
}
