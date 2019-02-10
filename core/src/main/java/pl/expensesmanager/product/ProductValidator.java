package pl.expensesmanager.product;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

@UtilityClass
class ProductValidator {
	
	static String validateProductName(String name) {
		if (StringUtils.isBlank(name)) {
			throw new RuntimeException();
		}
		
		return StringEscapeUtils.escapeHtml4(name)
		                        .trim();
	}
	
	static Double validatePrice(Double price) {
		if (price.isNaN() || price == null) {
			throw new RuntimeException();
		}
		
		return price;
	}
	
	static Integer validateQuanity(Integer quanity) {
		if (quanity == null) {
			throw new RuntimeException();
		}
		
		return quanity;
	}
	
	static ProductPort validateProduct(ProductPort product) {
		if (product == null) {
			throw new RuntimeException();
		}
		
		validateProductName(product.getName());
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
