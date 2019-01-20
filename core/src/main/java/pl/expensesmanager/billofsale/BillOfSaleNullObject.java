package pl.expensesmanager.billofsale;

import lombok.NoArgsConstructor;
import pl.expensesmanager.product.ProductPort;

import java.time.Instant;
import java.util.List;

/**
 * Representation of Bill of sale null object.
 */
@NoArgsConstructor
final class BillOfSaleNullObject implements BillOfSalePort {
	
	@Override
	public List<ProductPort> getProductList() {
		return null;
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
		return "DESCRIPTION_null";
	}
	
	@Override
	public void setDescription(String description) {
	
	}
	
	@Override
	public Double finalPrice() {
		return 0.0;
	}
	
	@Override
	public String getId() {
		return "ID_null";
	}
	
	@Override
	public void setId(String id) {
	
	}
	
	@Override
	public String toString() {
		return "NULL object.";
	}
	
}
