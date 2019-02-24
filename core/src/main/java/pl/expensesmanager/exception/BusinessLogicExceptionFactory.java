package pl.expensesmanager.exception;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.exception.business.ObjectNotFoundException;
import pl.expensesmanager.exception.business.PassedValueIsInvalidException;

/**
 * Factory of business logic exceptions reused in system
 */
@UtilityClass
public final class BusinessLogicExceptionFactory {
	
	@UtilityClass
	public static final class ErrorCode {
		
		public static final String PRODUCT_NOT_FOUND = code("product.not.found");
		
		public static final String PRODUCT_ORDER_NOT_FOUND = code("product.order.not.found");
		
		public static final String BILL_OF_SALE_NOT_FOUND = code("billofsale.not.found");
		
		public static final String BUDGET_NOT_FOUND = code("budget.not.found");
		
		public static final String MIN_BIGGER_THAN_MAX = code("min.bigger.than.max");
		
		private static String code(String code) {
			return "business.logic." + code;
		}
		
	}
	
	@UtilityClass
	public static final class ExceptionMessage {
		
		public static final String PRODUCT_NOT_FOUND = "Product not found.";
		
		public static final String PRODUCT_ORDER_NOT_FOUND = "Product order not found.";
		
		public static final String BILL_OF_SALE_NOT_FOUND = "Bill of sale not found.";
		
		public static final String BUDGET_NOT_FOUND = "Budget not found.";
		
		public static final String MIN_BIGGER_THAN_MAX = "Minimum value cannot be bigger than maximum value";
		
	}
	
	public static BusinessLogicException productNotFoundException() {
		throw new ObjectNotFoundException(ExceptionMessage.PRODUCT_NOT_FOUND, ErrorCode.PRODUCT_NOT_FOUND);
	}
	
	public static BusinessLogicException productOrderNotFoundException() {
		throw new ObjectNotFoundException(ExceptionMessage.PRODUCT_ORDER_NOT_FOUND, ErrorCode.PRODUCT_ORDER_NOT_FOUND);
	}
	
	public static BusinessLogicException billOfSaleNotFoundException() {
		throw new ObjectNotFoundException(ExceptionMessage.BILL_OF_SALE_NOT_FOUND, ErrorCode.BILL_OF_SALE_NOT_FOUND);
	}
	
	public static BusinessLogicException budgetNotFoundException() {
		throw new ObjectNotFoundException(ExceptionMessage.BUDGET_NOT_FOUND, ErrorCode.BUDGET_NOT_FOUND);
	}
	
	public static BusinessLogicException minBiggerThanMaxException() {
		throw new PassedValueIsInvalidException(ExceptionMessage.MIN_BIGGER_THAN_MAX, ErrorCode.MIN_BIGGER_THAN_MAX);
	}
	
}
