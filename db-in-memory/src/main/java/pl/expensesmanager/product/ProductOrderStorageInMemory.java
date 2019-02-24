package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import pl.expensesmanager.IdValidationPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of product order storage
 */
@Profile("in-memory")
public class ProductOrderStorageInMemory extends IdValidationPort implements ProductOrderStorePort {
	
	@Override
	public List<ProductOrder> findByProductName(String name) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(order -> order.getProduct()
		                                                           .getName()
		                                                           .equals(name))
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrder> findByProductNameAndProductPrice(String name, Double price) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(order -> order.getProduct()
		                                                           .getName()
		                                                           .equals(name) && order.getProduct()
		                                                                                 .getPrice() == price)
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrder> findByQuanityBetween(Integer min, Integer max) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(
			                                     product -> product.getQuanity() > min && product.getQuanity() < max)
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrder> findByQuanityGreaterThan(Integer quanity) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(product -> product.getQuanity() > quanity)
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrder> findByQuanityLessThan(Integer quanity) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(product -> product.getQuanity() < quanity)
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public ProductOrder save(ProductOrder object) {
		ProductOrderSimulatedData.LIST.add(object);
		return object;
		
	}
	
	@Override
	public void deleteById(String id) {
		ProductOrderSimulatedData.LIST.removeIf(product -> product.getId()
		                                                          .equals(id));
	}
	
	@Override
	public Optional<ProductOrder> findById(String id) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(product -> product.getId()
		                                                               .equals(id))
		                                     .findFirst();
	}
	
	@Override
	public List<ProductOrder> findAll() {
		return ProductOrderSimulatedData.LIST;
	}
	
}
