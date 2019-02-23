package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of product storage
 */
@Repository
@Profile("in-memory")
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
	public ProductPort save(ProductPort object) {
		ProductSimulatedData.LIST.add(object);
		
		return object;
	}
	
	@Override
	public void deleteById(String id) {
		ProductSimulatedData.LIST.removeIf(product -> product.getId()
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
