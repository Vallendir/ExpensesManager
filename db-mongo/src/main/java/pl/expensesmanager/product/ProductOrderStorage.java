package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Profile("dev")
public class ProductOrderStorage extends BaseMongoStorage implements ProductOrderStorePort {
	
	private final ProductOrderRepositoryMongo repository;
	
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
	
	@Override
	public ProductOrderPort save(ProductOrderPort object) {
		return repository.save(object);
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<ProductOrderPort> findById(String id) {
		return repository.findById(id);
	}
	
	@Override
	public List<ProductOrderPort> findAll() {
		return repository.findAll();
	}
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
