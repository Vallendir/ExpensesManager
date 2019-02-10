package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class ProductOrderService implements ProductOrderServicePort {
	
	private final ProductOrderStorePort storage;
	
	@Override
	public List<ProductOrderPort> searchAllForProductName(String name) {
		return storage.findByProductName(ProductValidator.validateProductName(name));
	}
	
	@Override
	public List<ProductOrderPort> searchAllForProductNameAndProductPrice(String name, Double price) {
		return storage.findByProductNameAndProductPrice(
			ProductValidator.validateProductName(name), ProductValidator.validatePrice(price));
	}
	
	@Override
	public List<ProductOrderPort> searchAllForQuanityRange(Integer min, Integer max) {
		if (min > max) {
			throw new RuntimeException();
		}
		
		return storage.findByQuanityBetween(
			ProductValidator.validateQuanity(min), ProductValidator.validateQuanity(max));
	}
	
	@Override
	public List<ProductOrderPort> searchAllForQuanityGreater(Integer quanity) {
		return storage.findByQuanityGreaterThan(ProductValidator.validateQuanity(quanity));
	}
	
	@Override
	public List<ProductOrderPort> searchAllForQuanityLower(Integer quanity) {
		return storage.findByQuanityLessThan(ProductValidator.validateQuanity(quanity));
	}
	
	@Override
	public ProductOrderPort create(ProductOrderPort object) {
		ProductValidator.validateOrder(object);
		
		return storage.add(object);
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort object) {
		ProductValidator.validateOrder(object);
		
		return storage.update(object);
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort originalObject, ProductOrderPort changes) {
		checkChangesInOrder(changes);
		
		return storage.update(originalObject, changes);
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort changes, String id) {
		checkChangesInOrder(changes);
		
		return storage.update(id, changes);
	}
	
	@Override
	public boolean delete(String id) {
		return storage.remove(id);
	}
	
	@Override
	public Optional<ProductOrderPort> searchForId(String id) {
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
