package pl.expensesmanager.base;

import org.bson.types.ObjectId;
import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.billofsale.BillOfSaleDocument;
import pl.expensesmanager.budget.Budget;
import pl.expensesmanager.budget.BudgetDocument;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductDocument;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderDocument;

import java.util.stream.Collectors;

/**
 * Basic storage adapter for mongo operations.
 */
public abstract class BaseMongoStorage implements IdValidatorPort<String> {
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
	protected ProductDocument map(Product product) {
		return ProductDocument.builder()
		                      .id(product.getId())
		                      .name(product.getName())
		                      .price(product.getPrice())
		                      .build();
	}
	
	protected Product map(ProductDocument productDocument) {
		Product product = new Product();
		product.setId(productDocument.getId());
		product.setName(productDocument.getName());
		product.setPrice(productDocument.getPrice());
		
		return product;
	}
	
	protected ProductOrderDocument map(ProductOrder order) {
		return ProductOrderDocument.builder()
		                           .id(order.getId())
		                           .product(map(order.getProduct()))
		                           .quanity(order.getQuanity())
		                           .build();
	}
	
	protected ProductOrder map(ProductOrderDocument orderDocument) {
		ProductOrder order = new ProductOrder();
		order.setId(orderDocument.getId());
		order.setProduct(map(orderDocument.getProduct()));
		order.setQuanity(orderDocument.getQuanity());
		
		return order;
	}
	
	protected BillOfSaleDocument map(BillOfSale billOfSale) {
		return BillOfSaleDocument.builder()
		                         .id(billOfSale.getId())
		                         .description(billOfSale.getDescription())
		                         .boughtDate(billOfSale.getBoughtDate())
		                         .productList(billOfSale.getProductList()
		                                                .stream()
		                                                .map(this::map)
		                                                .collect(Collectors.toList()))
		                         .build();
	}
	
	protected BillOfSale map(BillOfSaleDocument billOfSaleDocument) {
		BillOfSale billOfSale = new BillOfSale();
		billOfSale.setId(billOfSaleDocument.getId());
		billOfSale.setDescription(billOfSaleDocument.getDescription());
		billOfSale.setBoughtDate(billOfSaleDocument.getBoughtDate());
		billOfSale.setProductList(billOfSaleDocument.getProductList()
		                                            .stream()
		                                            .map(this::map)
		                                            .collect(Collectors.toList()));
		
		return billOfSale;
	}
	
	protected BudgetDocument map(Budget budget) {
		return BudgetDocument.builder()
		                     .id(budget.getId())
		                     .name(budget.getName())
		                     .budgetValue(budget.getBudgetValue())
		                     .billsOfSaleList(budget.getBillsOfSaleList()
		                                            .stream()
		                                            .map(this::map)
		                                            .collect(Collectors.toList()))
		                     .build();
	}
	
	protected Budget map(BudgetDocument budgetDocument) {
		Budget budget = new Budget();
		budget.setId(budgetDocument.getId());
		budget.setName(budgetDocument.getName());
		budget.setBudgetValue(budgetDocument.getBudgetValue());
		budget.setBillsOfSaleList(budgetDocument.getBillsOfSaleList()
		                                        .stream()
		                                        .map(this::map)
		                                        .collect(Collectors.toList()));
		
		return budget;
	}
	
}
