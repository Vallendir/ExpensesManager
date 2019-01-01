package pl.expensesmanager.domain;

import lombok.*;

import java.time.Instant;
import java.util.List;

/**
 * Representation of Bill of sale.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BillOfSale extends BaseModel implements BillOfSaleApi {
	
	private List<ProductQuanityApi> productList;
	
	private Instant boughtDate;
	
	private String description;
	
	@Override
	public Double finalPrice() {
		return productList.stream()
		                  .mapToDouble(ProductQuanityApi::summaryPrice)
		                  .summaryStatistics()
		                  .getSum();
	}
	
}
