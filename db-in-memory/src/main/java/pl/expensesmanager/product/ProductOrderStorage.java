package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.expensesmanager.IdValidationPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of product order storage
 */
@Repository
@Profile("in-memory")
public class ProductOrderStorage extends IdValidationPort implements ProductOrderStorePort {
	
	@Override
	public List<ProductOrderPort> findByProductName(String name) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(order -> order.getProduct()
		                                                           .getName()
		                                                           .equals(name))
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrderPort> findByProductNameAndProductPrice(String name, Double price) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(order -> order.getProduct()
		                                                           .getName()
		                                                           .equals(name) && order.getProduct()
		                                                                                 .getPrice() == price)
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrderPort> findByQuanityBetween(Integer min, Integer max) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(
			                                     product -> product.getQuanity() > min && product.getQuanity() < max)
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrderPort> findByQuanityGreaterThan(Integer quanity) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(product -> product.getQuanity() > quanity)
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrderPort> findByQuanityLessThan(Integer quanity) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(product -> product.getQuanity() < quanity)
		                                     .collect(Collectors.toList());
	}
	
	@Override
	public ProductOrderPort save(ProductOrderPort object) {
		ProductOrderSimulatedData.LIST.add(object);
		return object;
		
	}
	
	@Override
	public void deleteById(String id) {
		ProductOrderSimulatedData.LIST.removeIf(product -> product.getId()
		                                                          .equals(id));
	}
	
	@Override
	public Optional<ProductOrderPort> findById(String id) {
		return ProductOrderSimulatedData.LIST.stream()
		                                     .filter(product -> product.getId()
		                                                               .equals(id))
		                                     .findFirst();
	}
	
	@Override
	public List<ProductOrderPort> findAll() {
		return ProductOrderSimulatedData.LIST;
	}
	
}
