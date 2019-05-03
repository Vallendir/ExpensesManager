package pl.em.billofsale;

import pl.em.common.ExceptionMessage;
import pl.em.common.ExpensesManagerException;
import pl.em.common.ObjectIsNullException;

final class BillOfSaleExceptionFactory {
	
	static ExpensesManagerException billOfSaleIsNull() {
		return new ObjectIsNullException(message(BillOfSaleExceptionMessage.BILL_OF_SALE_IS_NULL));
	}
	
	static ExpensesManagerException billOfSaleNotSaved() {
		return new ObjectIsNullException(message(BillOfSaleExceptionMessage.BILL_OF_SALE_NOT_SAVED));
	}
	
	static ExpensesManagerException billOfSaleDescriptionIsNull() {
		return new ObjectIsNullException(message(BillOfSaleExceptionMessage.BILL_OF_SALE_DESCRIPTION_IS_NULL));
	}
	
	static ExpensesManagerException billOfSaleDescriptionIsEmpty() {
		return new ObjectIsNullException(message(BillOfSaleExceptionMessage.BILL_OF_SALE_DESCRIPTION_IS_EMPTY));
	}
	
	static ExpensesManagerException billOfSaleDateIsNull() {
		return new ObjectIsNullException(message(BillOfSaleExceptionMessage.BILL_OF_SALE_DATE_IS_NULL));
	}
	
	static ExpensesManagerException billOfSaleOrdersListIsNull() {
		return new ObjectIsNullException(message(BillOfSaleExceptionMessage.BILL_OF_SALE_ORDERS_IS_NULL));
	}
	
	private static ExceptionMessage message(BillOfSaleExceptionMessage message) {
		return new ExceptionMessage(message.getCode(), message.getMessage());
	}
	
}
