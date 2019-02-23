package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.ValidationExceptionFactory.invalidIdException;

@Service
@RequiredArgsConstructor
class ProductOrderService implements ProductOrderServicePort {
	
	private final ProductOrderStorePort storage;
	
	@Override
	public List<ProductOrderPort> searchAllByProductName(String name) {
		return storage.findByProductName(ProductValidator.validateName(name));
	}
	
	@Override
	public List<ProductOrderPort> searchAllByProductNameAndPrice(String name, Double price) {
		return storage.findByProductNameAndProductPrice(
			ProductValidator.validateName(name), ProductValidator.validatePrice(price));
	}
	
	@Override
	public List<ProductOrderPort> searchAllByQuanityRange(Integer min, Integer max) {
		if (min > max) {
			throw new RuntimeException();
		}
		
		return storage.findByQuanityBetween(
			ProductValidator.validateQuanity(min), ProductValidator.validateQuanity(max));
	}
	
	@Override
	public List<ProductOrderPort> searchAllByBiggerQuanityThan(Integer quanity) {
		return storage.findByQuanityGreaterThan(ProductValidator.validateQuanity(quanity));
	}
	
	@Override
	public List<ProductOrderPort> searchAllByLessQuanityThan(Integer quanity) {
		return storage.findByQuanityLessThan(ProductValidator.validateQuanity(quanity));
	}
	
	@Override
	public ProductOrderPort create(ProductOrderPort object) {
		ProductValidator.validateOrder(object);
		
		return storage.save(object);
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort object) {
		ProductValidator.validateOrder(object);
		
		return storage.save(object);
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort originalObject, ProductOrderPort changes) {
		checkChangesInOrder(changes);
		
		return storage.save(MergeUtil.merge(originalObject, changes));
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort changes, String id) {
		checkChangesInOrder(changes);
		
		Optional<ProductOrderPort> originalObject = searchById(id);
		if (!originalObject.isPresent()) {
			throw invalidIdException();
		}
		
		return storage.save(MergeUtil.merge(originalObject.get(), changes));
	}
	
	@Override
	public void removeById(String id) {
		storage.deleteById(id);
	}
	
	@Override
	public Optional<ProductOrderPort> searchById(String id) {
		return storage.findById(id);
	}
	
	@Override
	public List<ProductOrderPort> searchAll() {
		return storage.findAll();
	}
	
	private void checkChangesInOrder(ProductOrderPort changes) {
		if (changes.getQuanity() != null) {
			ProductValidator.validateQuanity(changes.getQuanity());
		}
		
		if (changes.getProduct() != null) {
			ProductValidator.validateProduct(changes.getProduct());
		}
	}
	
}
