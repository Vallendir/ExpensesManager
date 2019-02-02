package pl.expensesmanager.product;

import lombok.NoArgsConstructor;
import pl.expensesmanager.base.BaseModelNullObject;

/**
 * Representation of Product null object pattern.
 */
@NoArgsConstructor
final class ProductNullObject extends BaseModelNullObject implements ProductPort {
	
	public String getName() {
		return "NAME_of_null_object";
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
	
}
