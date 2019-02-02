package pl.expensesmanager.billofsale;

import lombok.NoArgsConstructor;
import pl.expensesmanager.base.BaseModelNullObject;
import pl.expensesmanager.product.ProductPort;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

/**
 * Representation of Bill of sale null object pattern.
 */
@NoArgsConstructor
final class BillOfSaleNullObject extends BaseModelNullObject implements BillOfSalePort {
	
	@Override
	public List<ProductPort> getProductList() {
		return Collections.emptyList();
	}
	
	@Override
	public void setProductList(List<ProductPort> productList) {
	
	}
	
	@Override
	public Instant getBoughtDate() {
		return Instant.now();
	}
	
	@Override
	public void setBoughtDate(Instant boughtDate) {
	
	}
	
	@Override
	public String getDescription() {
		return "DESCRIPTION_of_null_object";
	}
	
	@Override
	public void setDescription(String description) {
	
	}
	
	@Override
	public Double finalPrice() {
		return 0.0;
	}
	
}
