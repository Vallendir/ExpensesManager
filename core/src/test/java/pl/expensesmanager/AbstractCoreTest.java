package pl.expensesmanager;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.budget.Budget;
import pl.expensesmanager.exception.business.ObjectNotFoundException;
import pl.expensesmanager.exception.business.PassedValueIsInvalidException;
import pl.expensesmanager.exception.validation.ValidateDateException;
import pl.expensesmanager.exception.validation.ValidateNumberException;
import pl.expensesmanager.exception.validation.ValidateObjectException;
import pl.expensesmanager.exception.validation.ValidateTextException;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductOrder;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public abstract class AbstractCoreTest {
	
	protected static final String ID = "ID_TEST";
	
	protected static final String PRODUCT_NAME = "PRODUCT_NAME_TEST";
	
	protected static final Double PRODUCT_PRICE = 7.75;
	
	protected static final Integer PRODUCT_QUANITY = 5;
	
	protected static final Instant BOUGHT_DATE = Instant.now();
	
	protected static final String BILL_OF_SALE_DESCRIPTION = "Description test";
	
	protected static final String BUDGET_NAME = "Budget name";
	
	protected static final Double BUDGET_VALUE = 350.0;
	
	protected static final String TEXT_WITH_HTML4_TO_ESCAPE = "<span> Test text to escape ";
	
	protected static final String TEXT_WITH_HTML4_AFTER_ESCAPE = "&lt;span&gt; Test text to escape";
	
	protected static final String BLANK_TEXT = "";
	
	protected static final String EMPTY_SPACE_TEXT = " ";
	
	protected static final Double DOUBLE_VALUE_NAN = Double.NaN;
	
	private static final String ERROR_CODE_FIELD_TO_EXTRACT = "errorCode";
	
	
	protected Product createProduct() {
		return createProduct(ID, PRODUCT_NAME, PRODUCT_PRICE);
	}
	
	protected Product createProduct(String id, String name, Double price) {
		Product expectedProduct = new Product();
		expectedProduct.setId(id);
		expectedProduct.setName(name);
		expectedProduct.setPrice(price);
		
		return expectedProduct;
	}
	
	protected Product createProduct(Double price) {
		return createProduct(ID, PRODUCT_NAME, price);
	}
	
	protected Product createProduct(Product product, Double price) {
		product.setPrice(price);
		
		return product;
	}
	
	protected ProductOrder createProductOrder(Integer quanity) {
		ProductOrder order = new ProductOrder();
		order.setId(ID);
		order.setQuanity(quanity);
		order.setProduct(createProduct(ID, PRODUCT_NAME, PRODUCT_PRICE));
		
		return order;
	}
	
	protected ProductOrder createProductOrder() {
		return createProductOrder(PRODUCT_QUANITY);
	}
	
	protected BillOfSale createBillOfSale() {
		BillOfSale billOfSale = new BillOfSale();
		billOfSale.setId(ID);
		billOfSale.setBoughtDate(BOUGHT_DATE);
		billOfSale.setDescription(BILL_OF_SALE_DESCRIPTION);
		billOfSale.setProductList(List.of(createProductOrder()));
		
		return billOfSale;
	}
	
	protected Budget createBudget() {
		Budget budget = new Budget();
		budget.setId(ID);
		budget.setName(BUDGET_NAME);
		budget.setBillsOfSaleList(List.of(createBillOfSale()));
		budget.setBudgetValue(BUDGET_VALUE);
		
		return budget;
	}
	
	protected Budget createBudget(Double value) {
		Budget budget = new Budget();
		budget.setId(ID);
		budget.setName(BUDGET_NAME);
		budget.setBillsOfSaleList(List.of(createBillOfSale()));
		budget.setBudgetValue(value);
		
		return budget;
	}
	
	protected void assertThatThrownByValidateIdException(
		ThrowingCallable throwable, String hasMessage, String errorCode
	) {
		assertException(ValidateTextException.class, throwable, hasMessage, errorCode);
	}
	
	protected void assertThatThrownByValidateTextException(
		ThrowingCallable throwable, String hasMessage, String errorCode
	) {
		assertException(ValidateTextException.class, throwable, hasMessage, errorCode);
	}
	
	protected void assertThatThrownByValidateNumberException(
		ThrowingCallable throwable, String hasMessage, String errorCode
	) {
		assertException(ValidateNumberException.class, throwable, hasMessage, errorCode);
	}
	
	protected void assertThatThrownByValidateDateException(
		ThrowingCallable throwable, String hasMessage, String errorCode
	) {
		assertException(ValidateDateException.class, throwable, hasMessage, errorCode);
	}
	
	protected void assertThatThrownByValidateObjectException(
		ThrowingCallable throwable, String hasMessage, String errorCode
	) {
		assertException(ValidateObjectException.class, throwable, hasMessage, errorCode);
	}
	
	protected void assertThatThrownByNotFoundException(
		ThrowingCallable throwable, String hasMessage, String errorCode
	) {
		assertException(ObjectNotFoundException.class, throwable, hasMessage, errorCode);
	}
	
	protected void assertThatThrownByPassedValueIsInvalidException(
		ThrowingCallable throwable, String hasMessage, String errorCode
	) {
		assertException(PassedValueIsInvalidException.class, throwable, hasMessage, errorCode);
	}
	
	private void assertException(
		Class<?> exceptionType, ThrowingCallable throwable, String hasMessage, String errorCode
	) {
		assertThatThrownBy(throwable).isInstanceOf(exceptionType)
		                             .hasMessage(hasMessage);
		assertExtractedErrorCode(exceptionType, throwable, errorCode);
	}
	
	private void assertExtractedErrorCode(Class<?> exceptionType, ThrowingCallable throwable, String errorCode) {
		assertThatThrownBy(throwable).isInstanceOf(exceptionType)
		                             .extracting(ERROR_CODE_FIELD_TO_EXTRACT)
		                             .isEqualTo(List.of(errorCode));
	}
	
}
