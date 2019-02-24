package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Profile("dev")
@Component
public class ProductStorageMongo extends BaseMongoStorage implements ProductStorePort {
	
	private final ProductRepositoryMongo repository;
	
	@Override
	public List<Product> findByName(String name) {
		return repository.findByName(name)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public Optional<Product> findByNameAndPrice(String name, Double price) {
		return repository.findByNameAndPrice(name, price)
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
	
}
