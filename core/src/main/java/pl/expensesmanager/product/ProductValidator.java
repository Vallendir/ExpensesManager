package pl.expensesmanager.product;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.util.BasicValidator;

/**
 * Validator of product and product orders
 */
@UtilityClass
class ProductValidator {
	
	static String validateName(String name) {
		return BasicValidator.validateText(name);
	}
	
	static Double validatePrice(Double price) {
		return BasicValidator.validateDouble(price);
	}
	
	static Integer validateQuanity(Integer quanity) {
		return BasicValidator.validateInteger(quanity);
	}
	
	static ProductPort validateProduct(ProductPort product) {
		if (product == null) {
			throw new RuntimeException();
		}
		
		validateName(product.getName());
		validatePrice(product.getPrice());
		
		return product;
	}
	
	static ProductOrderPort validateOrder(ProductOrderPort order) {
		if (order == null) {
			throw new RuntimeException();
		}
		
		validateProduct(order.getProduct());
		validateQuanity(order.getQuanity());
		
		return order;
	}
	
}
