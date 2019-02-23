package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;

@Component
@Profile("dev")
public class ProductOrderStorage extends BaseMongoStorage<ProductOrderPort> implements ProductOrderStorePort {
	
	private ProductOrderRepositoryMongo repository;
	
	public ProductOrderStorage(ProductOrderRepositoryMongo repository) {
		super(repository);
		
		this.repository = repository;
	}
	
	@Override
	public List<ProductOrderPort> findByProductName(String name) {
		return repository.findByProductName(name);
	}
	
	@Override
	public List<ProductOrderPort> findByProductNameAndProductPrice(String name, Double price) {
		return repository.findByProductNameAndProductPrice(name, price);
	}
	
	@Override
	public List<ProductOrderPort> findByQuanityBetween(Integer min, Integer max) {
		return repository.findByQuanityBetween(min, max);
	}
	
	@Override
	public List<ProductOrderPort> findByQuanityGreaterThan(Integer quanity) {
		return repository.findByQuanityGreaterThan(quanity);
	}
	
	@Override
	public List<ProductOrderPort> findByQuanityLessThan(Integer quanity) {
		return repository.findByQuanityLessThan(quanity);
	}
	
}
