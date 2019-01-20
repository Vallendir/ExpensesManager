package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class ProductService implements ProductServicePort {
	
	private final ProductStorePort storage;
	
	@Override
	public ProductPort searchForName(String name) {
		return storage.findByName(name)
		              .orElse(new ProductNullObject());
	}
	
	@Override
	public List<ProductPort> searchAllForPriceRange(Double min, Double max) {
		return storage.findByPriceBetween(min, max);
	}
	
	@Override
	public List<ProductPort> searchAllForPriceGreater(Double price) {
		return storage.findByPriceGreaterThan(price);
	}
	
	@Override
	public List<ProductPort> searchAllForPriceLower(Double price) {
		return storage.findByPriceLessThan(price);
	}
	
	@Override
	public List<ProductPort> searchAllForQuanityRange(Integer min, Integer max) {
		return storage.findByQuanityBetween(min, max);
	}
	
	@Override
	public List<ProductPort> searchAllForQuanityGreater(Integer quanity) {
		return storage.findByQuanityGreaterThan(quanity);
	}
	
	@Override
	public List<ProductPort> searchAllForQuanityLower(Integer quanity) {
		return storage.findByQuanityLessThan(quanity);
	}
	
	@Override
	public ProductPort create(ProductPort object) {
		return storage.add(object);
	}
	
	@Override
	public ProductPort update(ProductPort object) {
		return storage.update(object);
	}
	
	@Override
	public ProductPort update(ProductPort originalObject, ProductPort changes) {
		return storage.update(originalObject, changes);
	}
	
	@Override
	public ProductPort update(ProductPort changes, String id) {
		return storage.update(id, changes);
	}
	
	@Override
	public boolean delete(String id) {
		return storage.remove(id);
	}
	
	@Override
	public ProductPort searchForId(String id) {
		return storage.findByName(id)
		              .orElse(new ProductNullObject());
	}
	
	@Override
	public List<ProductPort> searchAll() {
		return storage.findAll();
	}
	
}
