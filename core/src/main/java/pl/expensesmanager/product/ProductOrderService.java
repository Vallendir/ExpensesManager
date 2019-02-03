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
		return storage.findByProductName(name);
	}
	
	@Override
	public List<ProductOrderPort> searchAllForProductNameAndProductPrice(String name, Double price) {
		return storage.findByProductNameAndProductPrice(name, price);
	}
	
	@Override
	public List<ProductOrderPort> searchAllForQuanityRange(Integer min, Integer max) {
		return storage.findByQuanityBetween(min, max);
	}
	
	@Override
	public List<ProductOrderPort> searchAllForQuanityGreater(Integer quanity) {
		return storage.findByQuanityGreaterThan(quanity);
	}
	
	@Override
	public List<ProductOrderPort> searchAllForQuanityLower(Integer quanity) {
		return storage.findByQuanityLessThan(quanity);
	}
	
	@Override
	public ProductOrderPort create(ProductOrderPort object) {
		return storage.add(object);
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort object) {
		return storage.update(object);
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort originalObject, ProductOrderPort changes) {
		return storage.update(originalObject, changes);
	}
	
	@Override
	public ProductOrderPort update(ProductOrderPort changes, String id) {
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
	
}
