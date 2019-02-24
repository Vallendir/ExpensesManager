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
	public List<ProductOrder> findByProductName(String name) {
		return repository.findByProductName(name);
	}
	
	@Override
	public List<ProductOrder> findByProductNameAndProductPrice(String name, Double price) {
		return repository.findByProductNameAndProductPrice(name, price);
	}
	
	@Override
	public List<ProductOrder> findByQuanityBetween(Integer min, Integer max) {
		return repository.findByQuanityBetween(min, max);
	}
	
	@Override
	public List<ProductOrder> findByQuanityGreaterThan(Integer quanity) {
		return repository.findByQuanityGreaterThan(quanity);
	}
	
	@Override
	public List<ProductOrder> findByQuanityLessThan(Integer quanity) {
		return repository.findByQuanityLessThan(quanity);
	}
	
	@Override
	public ProductOrder save(ProductOrder object) {
		return repository.save(object);
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<ProductOrder> findById(String id) {
		return repository.findById(id);
	}
	
	@Override
	public List<ProductOrder> findAll() {
		return repository.findAll();
	}
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
