package pl.expensesmanager.product;

import lombok.NoArgsConstructor;

/**
 * Representation of Product null object pattern.
 */
@NoArgsConstructor
final class ProductNullObject implements ProductPort {
	
	public String getId() {
		return "ID_null";
	}
	
	public void setId(String id) {
	
	}
	
	public String getName() {
		return "NAME_null";
	}
	
	
	public void setName(String name) {
	
	}
	
	
	public Double getPrice() {
		return 0.0;
	}
	
	
	public void setPrice(Double price) {
	
	}
	
	
	public Integer getQuanity() {
		return 0;
	}
	
	
	public void setQuanity(Integer quanity) {
	
	}
	
	
	public Double summaryPrice() {
		return 0.0;
	}
	
	@Override
	public String toString() {
		return "NULL object.";
	}
	
}
