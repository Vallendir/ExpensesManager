package pl.em.product;

import pl.em.common.ExceptionMessage;
import pl.em.common.ExpensesManagerException;
import pl.em.common.ObjectIsNullException;

final class ProductExceptionFactory {
	
	static ExpensesManagerException productIsNull() {
		return new ObjectIsNullException(message(ProductExceptionMessage.PRODUCT_IS_NULL));
	}
	
	static ExpensesManagerException productNotSaved() {
		return new ObjectIsNullException(message(ProductExceptionMessage.PRODUCT_NOT_SAVED));
	}
	
	static ExpensesManagerException productNameIsNull() {
		return new ObjectIsNullException(message(ProductExceptionMessage.PRODUCT_NAME_IS_NULL));
	}
	
	static ExpensesManagerException productNameIsEmpty() {
		return new ObjectIsNullException(message(ProductExceptionMessage.PRODUCT_NAME_IS_EMPTY));
	}
	
	static ExpensesManagerException productPriceIsNull() {
		return new ObjectIsNullException(message(ProductExceptionMessage.PRODUCT_PRICE_IS_NULL));
	}
	
	static ExpensesManagerException productPriceIsInvalid() {
		return new ObjectIsNullException(message(ProductExceptionMessage.PRODUCT_PRICE_IS_INVALID));
	}
	
	private static ExceptionMessage message(ProductExceptionMessage message) {
		return new ExceptionMessage(message.getCode(), message.getMessage());
	}
	
}
