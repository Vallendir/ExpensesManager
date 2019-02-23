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
	public Optional<ProductPort> findByName(String name) {
		return repository.findByName(name)
		                 .map(this::map);
	}
	
	@Override
	public List<ProductPort> findByPrice(Double price) {
		return repository.findByPrice(price)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductPort> findByPriceBetween(Double min, Double max) {
		return repository.findByPriceBetween(min, max)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductPort> findByPriceGreaterThan(Double price) {
		return repository.findByPriceGreaterThan(price)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductPort> findByPriceLessThan(Double price) {
		return repository.findByPriceLessThan(price)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public Optional<ProductPort> findById(String id) {
		return repository.findById(id)
		                 .map(this::map);
	}
	
	@Override
	public ProductPort save(ProductPort object) {
		return repository.save(map(object));
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<ProductPort> findAll() {
		return repository.findAll()
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	private ProductDocument map(ProductPort productPort) {
		return ProductDocument.builder()
		                      .id(productPort.getId())
		                      .name(productPort.getName())
		                      .price(productPort.getPrice())
		                      .build();
	}
	
	private ProductPort map(ProductDocument productDocument) {
		return ProductDocument.builder()
		                      .id(productDocument.getId())
		                      .name(productDocument.getName())
		                      .price(productDocument.getPrice())
		                      .build();
	}
	
}
