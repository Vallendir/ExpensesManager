package pl.expensesmanager;

import pl.expensesmanager.billofsale.BillOfSaleDocument;
import pl.expensesmanager.budget.BudgetDocument;
import pl.expensesmanager.product.ProductDocumentOld;
import pl.expensesmanager.product.ProductOrderDocument;

import java.time.Instant;
import java.util.List;

public abstract class AbstractMongoDBTest {
	
	protected static final String ID = "PRODUCT_ID_TEST_MONGO";
	
	protected static final String PRODUCT_NAME = "PRODUCT_NAME_TEST_MONGO";
	
	protected static final Double PRODUCT_PRICE = 9.75;
	
	protected static final Integer PRODUCT_QUANITY = 4;
	
	protected static final Instant BOUGHT_DATE = Instant.now();
	
	protected static final String BILL_OF_SALE_DESCRIPTION = "Description test mongo";
	
	protected static final String BUDGET_NAME = "BudgetDocument name mongo";
	
	protected static final Double BUDGET_VALUE = 375.0;
	
	
	protected ProductDocumentOld createProduct() {
		return createProduct(ID, PRODUCT_NAME, PRODUCT_PRICE);
	}
	
	protected ProductDocumentOld createProduct(String id, String name, Double price) {
		ProductDocumentOld expectedProduct = new ProductDocumentOld();
		expectedProduct.setId(id);
		expectedProduct.setName(name);
		expectedProduct.setPrice(price);
		
		return expectedProduct;
	}
	
	protected ProductDocumentOld createProduct(Double price) {
		return createProduct(ID, PRODUCT_NAME, price);
	}
	
	protected ProductOrderDocument createProductOrder(Integer quanity) {
		ProductOrderDocument order = new ProductOrderDocument();
		order.setId(ID);
		order.setQuanity(quanity);
		order.setProduct(createProduct(ID, PRODUCT_NAME, PRODUCT_PRICE));
		
		return order;
	}
	
	protected ProductOrderDocument createProductOrder() {
		return createProductOrder(PRODUCT_QUANITY);
	}
	
	protected BillOfSaleDocument createBillOfSale() {
		BillOfSaleDocument billOfSale = new BillOfSaleDocument();
		billOfSale.setId(ID);
		billOfSale.setBoughtDate(BOUGHT_DATE);
		billOfSale.setDescription(BILL_OF_SALE_DESCRIPTION);
		billOfSale.setProductList(List.of(createProductOrder()));
		
		return billOfSale;
	}
	
	protected BudgetDocument createBudget() {
		BudgetDocument budget = new BudgetDocument();
		budget.setId(ID);
		budget.setName(BUDGET_NAME);
		budget.setBillsOfSaleList(List.of(createBillOfSale()));
		budget.setBudgetValue(BUDGET_VALUE);
		
		return budget;
	}
	
}
