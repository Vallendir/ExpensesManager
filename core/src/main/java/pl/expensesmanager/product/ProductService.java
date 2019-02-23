package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.ValidationExceptionFactory.invalidIdException;

@Service
@RequiredArgsConstructor
class ProductService implements ProductServicePort {
	
	private final ProductStorePort storage;
	
	@Override
	public Optional<ProductPort> searchForName(String name) {
		return storage.findByName(ProductValidator.validateName(name));
	}
	
	@Override
	public List<ProductPort> searchAllForPriceRange(Double min, Double max) {
		if (min > max) {
			throw new RuntimeException();
		}
		
		return storage.findByPriceBetween(ProductValidator.validatePrice(min), ProductValidator.validatePrice(max));
	}
	
	@Override
	public List<ProductPort> searchAllForPriceGreater(Double price) {
		return storage.findByPriceGreaterThan(ProductValidator.validatePrice(price));
	}
	
	@Override
	public List<ProductPort> searchAllForPriceLower(Double price) {
		return storage.findByPriceLessThan(ProductValidator.validatePrice(price));
	}
	
	@Override
	public ProductPort create(ProductPort object) {
		ProductValidator.validateProduct(object);
		
		return storage.save(object);
	}
	
	@Override
	public ProductPort update(ProductPort object) {
		ProductValidator.validateProduct(object);
		
		return storage.save(object);
	}
	
	@Override
	public ProductPort update(ProductPort originalObject, ProductPort changes) {
		checkChangesInProduct(changes);
		
		return storage.save(MergeUtil.merge(originalObject, changes));
	}
	
	@Override
	public ProductPort update(ProductPort changes, String id) {
		checkChangesInProduct(changes);
		
		Optional<ProductPort> originalObject = searchForId(id);
		if (!originalObject.isPresent()) {
			throw invalidIdException();
		}
		
		return storage.save(MergeUtil.merge(originalObject.get(), changes));
	}
	
	@Override
	public void deleteById(String id) {
		storage.deleteById(id);
	}
	
	@Override
	public Optional<ProductPort> searchForId(String id) {
		return storage.findById(id);
	}
	
	@Override
	public List<ProductPort> searchAll() {
		return storage.findAll();
	}
	
	private void checkChangesInProduct(ProductPort changes) {
		if (changes.getName() != null) {
			ProductValidator.validateName(changes.getName());
		}
		
		if (changes.getPrice() != null) {
			ProductValidator.validatePrice(changes.getPrice());
		}
	}
	
}
