package pl.expensesmanager.p;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import pl.expensesmanager.exception.ValidationException;
import pl.expensesmanager.exception.ValidationExceptionFactory;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateObjectException;
import pl.expensesmanager.exception.validation.ValidateTextException;

import java.text.MessageFormat;

final class ProductExceptionFactory {
	
	public static ValidationException productNameInvalidException(String message) {
		throw new ValidateTextException(Error.PRODUCT_NAME_INVALID.getCode(), MessageFormat.format(Error.PRODUCT_NAME_INVALID.getMessage(), message));
	}
	
	public static ValidationException productPriceInvalidException(String message) {
		throw new ValidateNumberException(Error.PRODUCT_PRICE_INVALID.getCode(), MessageFormat.format(Error.PRODUCT_PRICE_INVALID.getMessage(), message));
	}
	
	public static ValidationException productIsNullException() {
		throw new ValidateObjectException(Error.NULL_PRODUCT.getCode(), Error.NULL_PRODUCT.getMessage());
	}
	
	public static ValidationException productCannotBeCreatedException() {
		throw new ValidateObjectException(Error.PRODUCT_NOT_SAVED.getCode(), Error.PRODUCT_NOT_SAVED.getMessage());
	}
	
	public static ValidationException productIdInvalidException() {
		throw new ValidateObjectException(Error.PRODUCT_ID.getCode(), Error.PRODUCT_ID.getMessage());
	}
	
	public static ValidationException productNotFoundException() {
		throw new ValidateObjectException(Error.PRODUCT_NOT_FOUND.getCode(), Error.PRODUCT_NOT_FOUND.getMessage());
	}
	
	public static ValidationException productNotFounAndWontBeUpdatedException() {
		throw new ValidateObjectException(Error.PRODUCT_NOT_FOUND_TO_UPDATE.getCode(), Error.PRODUCT_NOT_FOUND_TO_UPDATE.getMessage());
	}
	
	public static ValidationException productNotRemovedException() {
		throw new ValidateObjectException(Error.PRODUCT_NOT_REMOVED.getCode(), Error.PRODUCT_NOT_REMOVED.getMessage());
	}
	
	@Getter
	@RequiredArgsConstructor
	enum Error {
		NULL_PRODUCT("product.null", "Product cannot be null."),
		PRODUCT_ID("product.id.invalid", "Product id is invalid."),
		PRODUCT_PRICE_INVALID("product.price.invalid", "Product price is invalid. {0}"),
		PRODUCT_NOT_SAVED("product.not.saved", "Product cannot be created and saved."),
		PRODUCT_NOT_FOUND("product.not.found", "Product not found."),
		PRODUCT_NOT_FOUND_TO_UPDATE("product.not.found.wont.be.updated", "Product not found and will not be updated."),
		PRODUCT_NOT_REMOVED("product.not.removed", "Product cannot be removed."),
		PRODUCT_NAME_INVALID("product.name.invalid", "Product name is invalid. {0}");
		
		private final String code;
		
		private final String message;
		
	}
	
}
