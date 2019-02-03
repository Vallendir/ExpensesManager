package pl.expensesmanager;

import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.billofsale.BillOfSalePort;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderPort;
import pl.expensesmanager.product.ProductPort;

import java.time.Instant;
import java.util.List;

public abstract class AbstractDBInMemoryTest {
	
	protected static final String PRODUCT_ID = "PRODUCT_ID_TEST";
	
	protected static final String PRODUCT_NAME = "PRODUCT_NAME_TEST";
	
	protected static final Double PRODUCT_PRICE = 10.25;
	
	protected static final Integer PRODUCT_QUANITY = 3;
	
	protected static final Instant BOUGHT_DATE = Instant.now();
	
	protected static final String BILL_OF_SALE_DESCRIPTION = "Description test";
	
	
	protected ProductPort createProduct(String id, String name, Double price) {
		ProductPort expectedProduct = new Product();
		expectedProduct.setId(id);
		expectedProduct.setName(name);
		expectedProduct.setPrice(price);
		
		return expectedProduct;
	}
	
	protected ProductPort createProduct(Double price) {
		return createProduct(PRODUCT_ID, PRODUCT_NAME, price);
	}
	
	protected ProductPort createProduct() {
		return createProduct(PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE);
	}
	
	protected ProductOrderPort createProductOrder(Integer quanity) {
		return new ProductOrder(createProduct(), quanity);
	}
	
	protected ProductOrderPort createProductOrder() {
		return createProductOrder(PRODUCT_QUANITY);
	}
	
	protected ProductOrderPort createOrder() {
		ProductOrderPort order = new ProductOrder();
		order.setQuanity(PRODUCT_QUANITY);
		order.setProduct(createProduct(PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE));
		
		return order;
	}
	
	protected BillOfSalePort createBillOfSale() {
		BillOfSalePort billOfSale = new BillOfSale();
		billOfSale.setId(PRODUCT_ID);
		billOfSale.setBoughtDate(BOUGHT_DATE);
		billOfSale.setDescription(BILL_OF_SALE_DESCRIPTION);
		billOfSale.setProductList(List.of(createOrder()));
		
		return billOfSale;
	}
	
}
