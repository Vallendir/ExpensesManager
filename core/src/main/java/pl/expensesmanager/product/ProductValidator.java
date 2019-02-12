package pl.expensesmanager.product;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateTextException;
import pl.expensesmanager.util.BasicValidator;

import static pl.expensesmanager.exception.ValidationExceptionFactory.*;

/**
 * Validator of product and product orders
 */
@UtilityClass
class ProductValidator {
	
	static String validateName(String name) {
		try {
			return BasicValidator.validateText(name);
		} catch (ValidateTextException exception) {
			throw productNameException();
		}
	}
	
	static Double validatePrice(Double price) {
		try {
			return BasicValidator.validateDouble(price);
		} catch (ValidateNumberException exception) {
			throw productPriceException();
		}
	}
	
	static Integer validateQuanity(Integer quanity) {
		try {
			return BasicValidator.validateInteger(quanity);
		} catch (ValidateNumberException exception) {
			throw productQuanityException();
		}
	}
	
	static ProductPort validateProduct(ProductPort product) {
		if (product == null) {
			throw productException();
		}
		
		validateName(product.getName());
		validatePrice(product.getPrice());
		
		return product;
	}
	
	static ProductOrderPort validateOrder(ProductOrderPort order) {
		if (order == null) {
			throw orderException();
		}
		
		validateProduct(order.getProduct());
		validateQuanity(order.getQuanity());
		
		return order;
	}
	
}
