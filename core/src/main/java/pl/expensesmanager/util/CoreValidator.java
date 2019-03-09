package pl.expensesmanager.util;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateTextException;
import pl.expensesmanager.product.Product;

import java.time.Instant;
import java.util.Objects;

import static pl.expensesmanager.exception.ValidationExceptionFactory.*;

/**
 * Core validator for product, bill of sale, order and budget validation.
 */
@UtilityClass
public class CoreValidator extends BasicValidator {
	
	public static String validateProductName(String name) {
		try {
			return validateText(name);
		} catch (ValidateTextException exception) {
			throw productNameException();
		}
	}
	
	public static Double validateProductPrice(Double price) {
		try {
			return validateDouble(price);
		} catch (ValidateNumberException exception) {
			throw productPriceException();
		}
	}
	
	public static Integer validateOrderQuanity(Integer quanity) {
		try {
			return validateInteger(quanity);
		} catch (ValidateNumberException exception) {
			throw productQuanityException();
		}
	}
	
	public static Product validateProduct(Product product) {
		if (Objects.isNull(product)) {
			throw productException();
		}
		
		product.setName(validateProductName(product.getName()));
		validateProductPrice(product.getPrice());
		
		return product;
	}
	
	public static String validateBillOfSaleDescription(String description) {
		try {
			return validateText(description);
		} catch (ValidateTextException exception) {
			throw billOfSaleDescriptionException();
		}
	}
	
	public static Instant validateBillOfSaleBoughtDate(Instant boughtDate) {
		try {
			return validateInstantDate(boughtDate);
		} catch (ValidateTextException exception) {
			throw dateNullException();
		}
	}
	
	public static String validateBudgetName(String name) {
		try {
			return validateText(name);
		} catch (ValidateTextException exception) {
			throw budgetNameException();
		}
	}
	
	public static Double validateBudgetValue(Double budgetValue) {
		try {
			return validateDouble(budgetValue);
		} catch (ValidateNumberException exception) {
			throw budgetValueException();
		}
	}
	
}
