package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of product storage
 */
@Repository
@Profile("dev")
public class ProductStorage implements ProductStorePort {
	
	@Override
	public Optional<ProductPort> findByName(String name) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getName()
		                                                          .equals(name))
		                                .findFirst();
	}
	
	@Override
	public List<ProductPort> findByPrice(Double price) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getPrice()
		                                                          .equals(price))
		                                .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductPort> findByPriceBetween(Double min, Double max) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getPrice() > min && product.getPrice() < max)
		                                .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductPort> findByPriceGreaterThan(Double price) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getPrice() > price)
		                                .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductPort> findByPriceLessThan(Double price) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getPrice() < price)
		                                .collect(Collectors.toList());
	}
	
	@Override
	public ProductPort add(ProductPort object) {
		if (ProductSimulatedData.LIST.add(object)) {
			return object;
		} else {
			throw new RuntimeException();
		}
	}
	
	@Override
	public ProductPort update(ProductPort object) {
		Optional<ProductPort> result = ProductSimulatedData.LIST.stream()
		                                                        .filter(product -> product.getId()
		                                                                                  .equals(object.getId()))
		                                                        .findFirst();
		
		if (result.isPresent()) {
			ProductPort updatedProduct = MergeUtil.merge(result.get(), object);
			
			ProductSimulatedData.LIST.remove(ProductSimulatedData.LIST.indexOf(result.get()));
			ProductSimulatedData.LIST.add(updatedProduct);
			
			return updatedProduct;
		} else {
			throw new RuntimeException();
		}
	}
	
	@Override
	public ProductPort update(ProductPort originalObject, ProductPort changes) {
		Optional<ProductPort> result = ProductSimulatedData.LIST.stream()
		                                                        .filter(product -> product.getId()
		                                                                                  .equals(
			                                                                                  originalObject.getId()))
		                                                        .findFirst();
		
		if (result.isPresent()) {
			ProductPort updatedProduct = MergeUtil.merge(result.get(), changes);
			
			ProductSimulatedData.LIST.remove(ProductSimulatedData.LIST.indexOf(result.get()));
			ProductSimulatedData.LIST.add(updatedProduct);
			
			return updatedProduct;
		} else {
			throw new RuntimeException();
		}
	}
	
	@Override
	public ProductPort update(String id, ProductPort changes) {
		Optional<ProductPort> result = ProductSimulatedData.LIST.stream()
		                                                        .filter(product -> product.getId()
		                                                                                  .equals(id))
		                                                        .findFirst();
		
		if (result.isPresent()) {
			ProductPort updatedProduct = MergeUtil.merge(result.get(), changes);
			
			ProductSimulatedData.LIST.remove(ProductSimulatedData.LIST.indexOf(result.get()));
			ProductSimulatedData.LIST.add(updatedProduct);
			
			return updatedProduct;
		} else {
			throw new RuntimeException();
		}
	}
	
	@Override
	public boolean remove(String id) {
		return ProductSimulatedData.LIST.removeIf(product -> product.getId()
		                                                            .equals(id));
	}
	
	@Override
	public Optional<ProductPort> findById(String id) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getId()
		                                                          .equals(id))
		                                .findFirst();
	}
	
	@Override
	public List<ProductPort> findAll() {
		return ProductSimulatedData.LIST;
	}
	
}
