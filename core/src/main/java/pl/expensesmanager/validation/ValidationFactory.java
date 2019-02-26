package pl.expensesmanager.validation;

import lombok.experimental.UtilityClass;
import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.budget.Budget;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductOrder;

import java.time.Instant;

/**
 * Validation factory with available validations.
 */
@UtilityClass
public final class ValidationFactory {
	
	public static void validate(String value) {
		strategyValidate(new StringValidation(value));
	}
	
	public static void validate(Integer value) {
		strategyValidate(new IntegerValidation(value));
	}
	
	public static void validate(Double value) {
		strategyValidate(new DoubleValidation(value));
	}
	
	public static void validate(Instant value) {
		strategyValidate(new InstantValidation(value));
	}
	
	public static void validateProductName(String value) {
		strategyValidate(new ProductNameValidation(value));
	}
	
	public static void validateProductPrice(Double value) {
		strategyValidate(new ProductPriceValidation(value));
	}
	
	public static void validateProductQuanity(Integer value) {
		strategyValidate(new ProductQuanityValidation(value));
	}
	
	public static void validateProduct(Product value) {
		strategyValidate(new ProductValidation(value));
	}
	
	public static void validateProductOrder(ProductOrder value) {
		strategyValidate(new ProductOrderValidation(value));
	}
	
	public static void validateBillOfSaleDescription(String value) {
		strategyValidate(new BillOfSaleDescriptionValidation(value));
	}
	
	public static void validateBillOfSaleBoughtDate(Instant value) {
		strategyValidate(new BillOfSaleBoughtDateValidation(value));
	}
	
	public static void validateBillOfSale(BillOfSale value) {
		strategyValidate(new BillOfSaleValidation(value));
	}
	
	public static void validateBudgetName(String value) {
		strategyValidate(new BudgetNameValidation(value));
	}
	
	public static void validateBudgetValueName(Double value) {
		strategyValidate(new BudgetValueValidation(value));
	}
	
	public static void validateBudget(Budget value) {
		strategyValidate(new BudgetValidation(value));
	}
	
	/**
	 * Method to execute validation on specific strategy.
	 *
	 * @param value - strategy to execute
	 */
	public static void strategyValidate(ValidationStrategy value) {
		value.validate();
	}
	
}
