package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expensesmanager.util.IdValidateUtil;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.*;

@Service
@RequiredArgsConstructor
class ProductService implements ProductServicePort {
	
	private final ProductStorePort storage;
	
	@Override
	public List<Product> searchByName(String name) {
		return storage.findByName(ProductValidator.validateName(name));
	}
	
	@Override
	public Optional<Product> searchByNameAndPrice(String name, Double price) {
		return storage.findByNameAndPrice(ProductValidator.validateName(name), ProductValidator.validatePrice(price));
	}
	
	@Override
	public List<Product> searchAllByPriceRange(Double min, Double max) {
		if (min > max) {
			throw minBiggerThanMaxException();
		}
		
		return storage.findByPriceBetween(ProductValidator.validatePrice(min), ProductValidator.validatePrice(max));
	}
	
	@Override
	public List<Product> searchAllExpensiveThan(Double price) {
		return storage.findByPriceGreaterThan(ProductValidator.validatePrice(price));
	}
	
	@Override
	public List<Product> searchAllCheaperThan(Double price) {
		return storage.findByPriceLessThan(ProductValidator.validatePrice(price));
	}
	
	@Override
	public Product create(Product object) {
		ProductValidator.validateProduct(object);
		
		return storage.save(object);
	}
	
	@Override
	public Product update(Product object) {
		ProductValidator.validateProduct(object);
		
		Product product = storage.save(object);
		checkIfProductWasUpdated(product);
		
		return product;
	}
	
	@Override
	public Product update(Product originalObject, Product changes) {
		checkChangesInProduct(changes);
		
		Product product = storage.save(MergeUtil.merge(originalObject, changes));
		checkIfProductWasUpdated(product);
		
		return product;
	}
	
	@Override
	public Product update(Product changes, String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		checkChangesInProduct(changes);
		
		Optional<Product> originalObject = searchById(id);
		if (!originalObject.isPresent()) {
			throw productNotFoundException();
		}
		
		Product product = storage.save(MergeUtil.merge(originalObject.get(), changes));
		checkIfProductWasUpdated(product);
		
		return product;
	}
	
	@Override
	public void removeById(String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		storage.deleteById(id);
	}
	
	@Override
	public Optional<Product> searchById(String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		return storage.findById(id);
	}
	
	@Override
	public List<Product> searchAll() {
		return storage.findAll();
	}
	
	private void checkChangesInProduct(Product changes) {
		if (changes.getName() != null) {
			ProductValidator.validateName(changes.getName());
		}
		
		if (changes.getPrice() != null) {
			ProductValidator.validatePrice(changes.getPrice());
		}
	}
	
	private void checkIfProductWasUpdated(Product product) {
		if (product == null) {
			throw productNotUpdatedException();
		}
	}
	
}
