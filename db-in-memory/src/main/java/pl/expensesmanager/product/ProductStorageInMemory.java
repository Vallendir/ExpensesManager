package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import pl.expensesmanager.IdValidationPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of product storage
 */
@Profile("in-memory")
public class ProductStorageInMemory extends IdValidationPort implements ProductStorePort {
	
	@Override
	public Optional<Product> findByName(String name) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getName()
		                                                          .equals(name))
		                                .findFirst();
	}
	
	@Override
	public List<Product> findByPrice(Double price) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getPrice()
		                                                          .equals(price))
		                                .collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByPriceBetween(Double min, Double max) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getPrice() > min && product.getPrice() < max)
		                                .collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByPriceGreaterThan(Double price) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getPrice() > price)
		                                .collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByPriceLessThan(Double price) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getPrice() < price)
		                                .collect(Collectors.toList());
	}
	
	@Override
	public Product save(Product object) {
		ProductSimulatedData.LIST.add(object);
		
		return object;
	}
	
	@Override
	public void deleteById(String id) {
		ProductSimulatedData.LIST.removeIf(product -> product.getId()
		                                                     .equals(id));
	}
	
	@Override
	public Optional<Product> findById(String id) {
		return ProductSimulatedData.LIST.stream()
		                                .filter(product -> product.getId()
		                                                          .equals(id))
		                                .findFirst();
	}
	
	@Override
	public List<Product> findAll() {
		return ProductSimulatedData.LIST;
	}
	
}
