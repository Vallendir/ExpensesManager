package pl.em.order;

import pl.em.common.ExceptionMessage;
import pl.em.common.ExpensesManagerException;
import pl.em.common.ObjectIsNullException;

final class OrderExceptionFactory {
	
	static ExpensesManagerException orderIsNull() {
		return new ObjectIsNullException(message(OrderExceptionMessage.ORDER_IS_NULL));
	}
	
	static ExpensesManagerException orderNotSaved() {
		return new ObjectIsNullException(message(OrderExceptionMessage.ORDER_NOT_SAVED));
	}
	
	static ExpensesManagerException orderQuanityIsNull() {
		return new ObjectIsNullException(message(OrderExceptionMessage.ORDER_QUANITY_IS_NULL));
	}
	
	static ExpensesManagerException orderProductIsNull() {
		return new ObjectIsNullException(message(OrderExceptionMessage.ORDER_PRODUCT_IS_NULL));
	}
	
	private static ExceptionMessage message(OrderExceptionMessage message) {
		return new ExceptionMessage(message.getCode(), message.getMessage());
	}
	
}
