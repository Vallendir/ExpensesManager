package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Profile("dev")
@RequiredArgsConstructor
@Component
public class ProductStorageMongo extends BaseMongoStorage implements ProductStorePort {
	
	private final ProductRepositoryMongo repository;
	
	@Override
	public Optional<Product> findByName(String name) {
		return repository.findByName(name)
		                 .map(this::map);
	}
	
	@Override
	public List<Product> findByPrice(Double price) {
		return repository.findByPrice(price)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByPriceBetween(Double min, Double max) {
		return repository.findByPriceBetween(min, max)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByPriceGreaterThan(Double price) {
		return repository.findByPriceGreaterThan(price)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByPriceLessThan(Double price) {
		return repository.findByPriceLessThan(price)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public Optional<Product> findById(String id) {
		return repository.findById(id)
		                 .map(this::map);
	}
	
	@Override
	public Product save(Product object) {
		return map(repository.save(map(object)));
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<Product> findAll() {
		return repository.findAll()
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	private ProductDocument map(Product Product) {
		return ProductDocument.builder()
		                      .id(Product.getId())
		                      .name(Product.getName())
		                      .price(Product.getPrice())
		                      .build();
	}
	
	private Product map(ProductDocument productDocument) {
		Product product = new Product();
		product.setId(productDocument.getId());
		product.setName(productDocument.getName());
		product.setPrice(productDocument.getPrice());
		
		return product;
	}
	
}
