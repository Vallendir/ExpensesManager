package pl.expensesmanager.billofsale;

import lombok.*;
import pl.expensesmanager.product.ProductOrderPort;

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
public final class BillOfSale extends BillOfSalePort.BaseModel implements BillOfSalePort {
	
	private List<ProductOrderPort> productList;
	
	private Instant boughtDate;
	
	private String description;
	
	@Override
	public Double finalPrice() {
		return productList.stream()
		                  .mapToDouble(ProductOrderPort::summaryPrice)
		                  .summaryStatistics()
		                  .getSum();
	}
	
}
