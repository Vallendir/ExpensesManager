package pl.expensesmanager.base;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.billofsale.BillOfSaleDocument;
import pl.expensesmanager.budget.Budget;
import pl.expensesmanager.budget.BudgetDocument;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductDocument;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderDocument;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Basic storage adapter for mongo operations.
 */
@RequiredArgsConstructor
public abstract class BaseMongoStorage<MongoDocument, DomainObject> implements IdValidatorPort<String> {
	
	private final MongoRepository<MongoDocument, String> repository;
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	/**
	 * method to find object by identificator
	 *
	 * @param id       identificator for object
	 * @param function mappoing function
	 * @return mapped found object
	 */
	protected Optional<DomainObject> findObjectById(String id, Function<MongoDocument, DomainObject> function) {
		return repository.findById(id)
		                 .map(function);
	}
	
	/**
	 * Method to find all objects
	 *
	 * @param function mapping function
	 * @return list of all objects
	 */
	protected List<DomainObject> findAllObjects(Function<MongoDocument, DomainObject> function) {
		return readFromStream(repository.findAll(), function);
	}
	
	/**
	 * Method to save/update object
	 *
	 * @param object   object to save/update
	 * @param function mapping function
	 * @return saved/updated object
	 */
	protected DomainObject saveObject(Supplier<MongoDocument> object, Function<MongoDocument, DomainObject> function) {
		return function.apply(repository.save(object.get()));
	}
	
	/**
	 * Method to map and collect found objects into list
	 *
	 * @param list     list on whioch will be done maping and collection
	 * @param function maping function
	 * @return mapped list of objects
	 */
	protected List<DomainObject> readFromStream(
		List<MongoDocument> list, Function<MongoDocument, DomainObject> function
	) {
		return list.stream()
		           .map(function)
		           .collect(Collectors.toList());
	}
	
	protected ProductDocument map(Product product) {
		return ProductDocument.builder()
		                      .id(product.getId())
		                      .name(product.getName())
		                      .price(product.getPrice())
		                      .build();
	}
	
	protected Product map(ProductDocument productDocument) {
		Product product = Product.builder()
		                         .name(productDocument.getName())
		                         .price(productDocument.getPrice())
		                         .build();
		product.setId(productDocument.getId());
		
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
		ProductOrder order = ProductOrder.builder()
		                                 .product(map(orderDocument.getProduct()))
		                                 .quanity(orderDocument.getQuanity())
		                                 .build();
		order.setId(orderDocument.getId());
		
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
		BillOfSale billOfSale = BillOfSale.builder()
		                                  .description(billOfSaleDocument.getDescription())
		                                  .boughtDate(billOfSaleDocument.getBoughtDate())
		                                  .productList(billOfSaleDocument.getProductList()
		                                                                 .stream()
		                                                                 .map(this::map)
		                                                                 .collect(Collectors.toList()))
		                                  .build();
		billOfSale.setId(billOfSaleDocument.getId());
		
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
		Budget budget = Budget.builder()
		                      .name(budgetDocument.getName())
		                      .budgetValue(budgetDocument.getBudgetValue())
		                      .billsOfSaleList(budgetDocument.getBillsOfSaleList()
		                                                     .stream()
		                                                     .map(this::map)
		                                                     .collect(Collectors.toList()))
		                      .build();
		budget.setId(budgetDocument.getId());
		
		return budget;
	}
	
}
