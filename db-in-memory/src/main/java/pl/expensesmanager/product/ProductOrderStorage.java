package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of product order storage
 */
@Repository
@Profile("in-memory")
public class ProductOrderStorage implements ProductOrderStorePort {
	
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
	
	/*@Override
	public ProductOrderPort update(ProductOrderPort object) {
		Optional<ProductOrderPort> result = ProductOrderSimulatedData.LIST.stream()
		                                                                  .filter(product -> product.getId()
		                                                                                            .equals(
			                                                                                            object.getId()))
		                                                                  .findFirst();
		
		if (!result.isPresent()) {
			return null;
		}
		
		ProductOrderPort updatedProduct = MergeUtil.merge(result.get(), object);
		ProductOrderSimulatedData.LIST.remove(result.get());
		ProductOrderSimulatedData.LIST.save(updatedProduct);
		
		return updatedProduct;
		
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort originalObject, ProductOrderPort changes) {
		Optional<ProductOrderPort> result = ProductOrderSimulatedData.LIST.stream()
		                                                                  .filter(product -> product.getId()
		                                                                                            .equals(
			                                                                                            originalObject.getId()))
		                                                                  .findFirst();
		
		if (!result.isPresent()) {
			return null;
		}
		
		ProductOrderPort updatedProduct = MergeUtil.merge(result.get(), changes);
		
		ProductOrderSimulatedData.LIST.remove(result.get());
		ProductOrderSimulatedData.LIST.save(updatedProduct);
		
		return updatedProduct;
		
	}
	
	@Override
	public ProductOrderPort update(String id, ProductOrderPort changes) {
		Optional<ProductOrderPort> result = ProductOrderSimulatedData.LIST.stream()
		                                                                  .filter(product -> product.getId()
		                                                                                            .equals(id))
		                                                                  .findFirst();
		
		if (!result.isPresent()) {
			return null;
		}
		
		ProductOrderPort updatedProduct = MergeUtil.merge(result.get(), changes);
		ProductOrderSimulatedData.LIST.remove(result.get());
		ProductOrderSimulatedData.LIST.save(updatedProduct);
		
		return updatedProduct;
		
	}*/
	
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
