package pl.expensesmanager.p;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import pl.expensesmanager.b.Validator;

import java.util.Objects;

import static pl.expensesmanager.p.ProductExceptionFactory.productNameInvalidException;

@NoArgsConstructor
@AllArgsConstructor
class ValidateProductName implements Validator<Product> {
	
	private String name;
	
	@Override
	public void validate(Product product) {
		if (Objects.nonNull(name) && Objects.isNull(product)) {
			validate(name);
		} else {
			var productName = validate(product.getName());
			product.setName(productName);
		}
	}
	
	private String validate(String name) {
		if (Objects.isNull(name)) {
			throw productNameInvalidException("Product name cannot be null.");
		}
		var productName = name.trim();
		if (StringUtils.isBlank(productName)) {
			throw productNameInvalidException("Product name cannot be empty.");
		}
		
		return productName;
	}
	
}
