package pl.expensesmanager.exception;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.exception.validation.ValidateDateException;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateObjectException;
import pl.expensesmanager.exception.validation.ValidateTextException;

/**
 * Factory of validation exceptions reused in system
 */
@UtilityClass
public final class ValidationExceptionFactory {
	
	@UtilityClass
	public static final class ErrorCode {
		
		public static final String INVALID_ID = code("id.invalid");
		
		public static final String TEXT_BLANK = code("text.blank");
		
		public static final String NUMBER_NAN = code("number.nan");
		
		public static final String NULL_NUMBER = code("number.null");
		
		public static final String NULL_DATE = code("date.null");
		
		public static final String NULL_PRODUCT = code("product.null");
		
		public static final String NULL_PRODUCT_ORDER = code("product.order.null");
		
		public static final String NULL_BILL_OF_SALE = code("bill.of.sale.null");
		
		public static final String NULL_BUDGET = code("budget.null");
		
		public static final String PRODUCT_NAME = code("product.name");
		
		public static final String PRODUCT_PRICE = code("product.price");
		
		public static final String PRODUCT_QUANITY = code("product.quanity");
		
		public static final String BILL_OF_SALE_DESCRIPTION = code("bill.of.sale.description");
		
		public static final String BUDGET_NAME = code("budget.name");
		
		public static final String BUDGET_VALUE = code("budget.value");
		
		private static String code(String code) {
			return "validation." + code;
		}
		
	}
	
	@UtilityClass
	public static final class ExceptionMessage {
		
		public static final String INVALID_ID = "Passed id is invalid.";
		
		public static final String TEXT_BLANK = "Text cannot be blank.";
		
		public static final String NUMBER_NAN = "Value is not a number.";
		
		public static final String NULL_NUMBER = nullInfo("Number");
		
		public static final String NULL_DATE = nullInfo("Date");
		
		public static final String NULL_PRODUCT = nullInfo("Product");
		
		public static final String NULL_PRODUCT_ORDER = nullInfo("Product order");
		
		public static final String NULL_BILL_OF_SALE = nullInfo("Bill of sale");
		
		public static final String NULL_BUDGET = nullInfo("Budget");
		
		public static final String PRODUCT_NAME = "Product name is invalid. Passed value is null or has wrong format.";
		
		public static final String PRODUCT_PRICE = "Product price cannot be null or value is invalid.";
		
		public static final String PRODUCT_QUANITY = "Product quanity cannot be null or value is invalid.";
		
		public static final String BILL_OF_SALE_DESCRIPTION = "Description of bill of sale is invalid.";
		
		public static final String BUDGET_NAME = "Budget name is invalid. Passed value is null or has wrong format.";
		
		public static final String BUDGET_VALUE = "Budget value cannot be null or value is invalid.";
		
		private static String nullInfo(String type) {
			return type + " cannot be null.";
		}
		
	}
	
	public static ValidationException invalidIdException() {
		throw new ValidateTextException(ExceptionMessage.INVALID_ID, ErrorCode.INVALID_ID);
	}
	
	public static ValidationException blankTextException() {
		throw new ValidateTextException(ExceptionMessage.TEXT_BLANK, ErrorCode.TEXT_BLANK);
	}
	
	public static ValidationException numberNullException() {
		throw new ValidateNumberException(ExceptionMessage.NULL_NUMBER, ErrorCode.NULL_NUMBER);
	}
	
	public static ValidationException numberNANException() {
		throw new ValidateNumberException(ExceptionMessage.NUMBER_NAN, ErrorCode.NUMBER_NAN);
	}
	
	public static ValidationException dateNullException() {
		throw new ValidateDateException(ExceptionMessage.NULL_DATE, ErrorCode.NULL_DATE);
	}
	
	public static ValidationException productNameException() {
		throw new ValidateTextException(ExceptionMessage.PRODUCT_NAME, ErrorCode.PRODUCT_NAME);
	}
	
	public static ValidationException productPriceException() {
		throw new ValidateNumberException(ExceptionMessage.PRODUCT_PRICE, ErrorCode.PRODUCT_PRICE);
	}
	
	public static ValidationException productQuanityException() {
		throw new ValidateNumberException(ExceptionMessage.PRODUCT_QUANITY, ErrorCode.PRODUCT_QUANITY);
	}
	
	public static ValidationException productException() {
		throw new ValidateObjectException(ExceptionMessage.NULL_PRODUCT, ErrorCode.NULL_PRODUCT);
	}
	
	public static ValidationException orderException() {
		throw new ValidateObjectException(ExceptionMessage.NULL_PRODUCT_ORDER, ErrorCode.NULL_PRODUCT_ORDER);
	}
	
	public static ValidationException billOfSaleDescriptionException() {
		throw new ValidateTextException(ExceptionMessage.BILL_OF_SALE_DESCRIPTION, ErrorCode.BILL_OF_SALE_DESCRIPTION);
	}
	
	public static ValidationException billOfSaleException() {
		throw new ValidateObjectException(ExceptionMessage.NULL_BILL_OF_SALE, ErrorCode.NULL_BILL_OF_SALE);
	}
	
	public static ValidationException budgetNameException() {
		throw new ValidateTextException(ExceptionMessage.BUDGET_NAME, ErrorCode.BUDGET_NAME);
	}
	
	public static ValidationException budgetValueException() {
		throw new ValidateNumberException(ExceptionMessage.BUDGET_VALUE, ErrorCode.BUDGET_VALUE);
	}
	
	public static ValidationException budgetException() {
		throw new ValidateObjectException(ExceptionMessage.NULL_BUDGET, ErrorCode.NULL_BUDGET);
	}
	
}
