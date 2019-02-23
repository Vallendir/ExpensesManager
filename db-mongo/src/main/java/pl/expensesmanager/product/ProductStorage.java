package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;
import java.util.Optional;

@Component
@Profile("dev")
public class ProductStorage extends BaseMongoStorage<ProductPort> implements ProductStorePort {
	
	private ProductRepositoryMongo repository;
	
	public ProductStorage(ProductRepositoryMongo repository) {
		super(repository);
		
		this.repository = repository;
	}
	
	@Override
	public Optional<ProductPort> findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public List<ProductPort> findByPrice(Double price) {
		return repository.findByPrice(price);
	}
	
	@Override
	public List<ProductPort> findByPriceBetween(Double min, Double max) {
		return repository.findByPriceBetween(min, max);
	}
	
	@Override
	public List<ProductPort> findByPriceGreaterThan(Double price) {
		return repository.findByPriceGreaterThan(price);
	}
	
	@Override
	public List<ProductPort> findByPriceLessThan(Double price) {
		return repository.findByPriceLessThan(price);
	}
	
}
