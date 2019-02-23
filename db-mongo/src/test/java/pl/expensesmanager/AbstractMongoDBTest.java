package pl.expensesmanager;

import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.billofsale.BillOfSalePort;
import pl.expensesmanager.budget.Budget;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderPort;
import pl.expensesmanager.product.ProductPort;

import java.time.Instant;
import java.util.List;

public abstract class AbstractMongoDBTest {
	
	protected static final String ID = "PRODUCT_ID_TEST_MONGO";
	
	protected static final String PRODUCT_NAME = "PRODUCT_NAME_TEST_MONGO";
	
	protected static final Double PRODUCT_PRICE = 9.75;
	
	protected static final Integer PRODUCT_QUANITY = 4;
	
	protected static final Instant BOUGHT_DATE = Instant.now();
	
	protected static final String BILL_OF_SALE_DESCRIPTION = "Description test mongo";
	
	protected static final String BUDGET_NAME = "Budget name mongo";
	
	protected static final Double BUDGET_VALUE = 375.0;
	
	
	protected ProductPort createProduct() {
		return createProduct(ID, PRODUCT_NAME, PRODUCT_PRICE);
	}
	
	protected ProductPort createProduct(String id, String name, Double price) {
		ProductPort expectedProduct = new Product();
		expectedProduct.setId(id);
		expectedProduct.setName(name);
		expectedProduct.setPrice(price);
		
		return expectedProduct;
	}
	
	protected ProductPort createProduct(Double price) {
		return createProduct(ID, PRODUCT_NAME, price);
	}
	
	protected ProductOrderPort createProductOrder(Integer quanity) {
		ProductOrderPort order = new ProductOrder();
		order.setId(ID);
		order.setQuanity(quanity);
		order.setProduct(createProduct(ID, PRODUCT_NAME, PRODUCT_PRICE));
		
		return order;
	}
	
	protected ProductOrderPort createProductOrder() {
		return createProductOrder(PRODUCT_QUANITY);
	}
	
	protected BillOfSalePort createBillOfSale() {
		BillOfSalePort billOfSale = new BillOfSale();
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
	
}
