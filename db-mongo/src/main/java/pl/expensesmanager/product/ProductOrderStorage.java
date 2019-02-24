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
		return null;
	}
	
	@Override
	public List<ProductOrder> findByProductNameAndProductPrice(String name, Double price) {
		return null;
	}
	
	@Override
	public List<ProductOrder> findByQuanityBetween(Integer min, Integer max) {
		return null;
	}
	
	@Override
	public List<ProductOrder> findByQuanityGreaterThan(Integer quanity) {
		return null;
	}
	
	@Override
	public List<ProductOrder> findByQuanityLessThan(Integer quanity) {
		return null;
	}
	
	@Override
	public ProductOrder save(ProductOrder object) {
		return null;
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<ProductOrder> findById(String id) {
		return null;
	}
	
	@Override
	public List<ProductOrder> findAll() {
		return null;
	}
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
