package pl.expensesmanager.exception;

import pl.expensesmanager.exception.validation.ValidateDateException;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateObjectException;
import pl.expensesmanager.exception.validation.ValidateTextException;

public class ValidationExceptionFactory {
	
	public interface ErrorCode {
		
		String TEXT_BLANK = "text.blank";
		
		String NUMBER_NULL = "number.null";
		
		String NUMBER_NAN = "number.nan";
		
		String DATE_NULL = "date.null";
		
		String PRODUCT_NAME = "product.name";
		
		String PRODUCT_PRICE = "product.price";
		
		String PRODUCT_QUANITY = "product.quanity";
		
		String PRODUCT_NULL = "product.null";
		
		String PRODUCT_ORDER_NULL = "product.order.null";
		
	}
	
	public interface ExceptionMessage {
		
		String TEXT_BLANK = "Passed text cannot be blank.";
		
		String NUMBER_NULL = "Passed number value cannot be null.";
		
		String NUMBER_NAN = "Passed number value cannot be NAN.";
		
		String DATE_NULL = "Passed date cannot be null.";
		
		String PRODUCT_NAME = "Product name is invalid. Passed value is null or has wrong format.";
		
		String PRODUCT_PRICE = "Product price cannot be null or value is invalid.";
		
		String PRODUCT_QUANITY = "Product quanity cannot be null or value is invalid.";
		
		String PRODUCT_NULL = "Product cannot be null or is invalid.";
		
		String PRODUCT_ORDER_NULL = "Product order cannot be null or is invalid.";
		
	}
	
	public static ValidationException blankTextException() {
		throw new ValidateTextException(ExceptionMessage.TEXT_BLANK, ErrorCode.TEXT_BLANK);
	}
	
	public static ValidationException numberNullException() {
		throw new ValidateNumberException(ExceptionMessage.NUMBER_NULL, ErrorCode.NUMBER_NULL);
	}
	
	public static ValidationException numberNANException() {
		throw new ValidateNumberException(ExceptionMessage.NUMBER_NAN, ErrorCode.NUMBER_NAN);
	}
	
	public static ValidationException dateNullException() {
		throw new ValidateDateException(ExceptionMessage.DATE_NULL, ErrorCode.DATE_NULL);
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
		throw new ValidateObjectException(ExceptionMessage.PRODUCT_NULL, ErrorCode.PRODUCT_NULL);
	}
	
	public static ValidationException orderException() {
		throw new ValidateObjectException(ExceptionMessage.PRODUCT_ORDER_NULL, ErrorCode.PRODUCT_ORDER_NULL);
	}
	
}
