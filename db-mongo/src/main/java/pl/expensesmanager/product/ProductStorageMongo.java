package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;
import java.util.Optional;

@Component
@Profile("mongo")
class ProductStorageMongo extends BaseMongoStorage<ProductDocument, Product> implements ProductStorePort {
	
	private final ProductRepositoryMongo repository;
	
	ProductStorageMongo(ProductRepositoryMongo repository) {
		super(repository);
		this.repository = repository;
	}
	
	@Override
	public List<Product> findByName(String name) {
		return readFromStream(repository.findByName(name), this::map);
	}
	
	@Override
	public Optional<Product> findByNameAndPrice(String name, Double price) {
		return repository.findByNameAndPrice(name, price)
		                 .map(this::map);
	}
	
	@Override
	public List<Product> findByPrice(Double price) {
		return readFromStream(repository.findByPrice(price), this::map);
	}
	
	@Override
	public List<Product> findByPriceBetween(Double min, Double max) {
		return readFromStream(repository.findByPriceBetween(min, max), this::map);
	}
	
	@Override
	public List<Product> findByPriceGreaterThan(Double price) {
		return readFromStream(repository.findByPriceGreaterThan(price), this::map);
	}
	
	@Override
	public List<Product> findByPriceLessThan(Double price) {
		return readFromStream(repository.findByPriceLessThan(price), this::map);
	}
	
	@Override
	public Optional<Product> findById(String id) {
		return findObjectById(id, this::map);
	}
	
	@Override
	public Product save(Product object) {
		return saveObject(() -> map(object), this::map);
	}
	
	@Override
	public List<Product> findAll() {
		return findAllObjects(this::map);
	}
	
}
