package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expensesmanager.util.IdValidateUtil;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.minBiggerThanMaxException;
import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.productNotFoundException;

@Service
@RequiredArgsConstructor
class ProductService implements ProductServicePort {
	
	private final ProductStorePort storage;
	
	@Override
	public Optional<ProductPort> searchByName(String name) {
		return storage.findByName(ProductValidator.validateName(name));
	}
	
	@Override
	public List<ProductPort> searchAllByPriceRange(Double min, Double max) {
		if (min > max) {
			throw minBiggerThanMaxException();
		}
		
		return storage.findByPriceBetween(ProductValidator.validatePrice(min), ProductValidator.validatePrice(max));
	}
	
	@Override
	public List<ProductPort> searchAllExpensiveThan(Double price) {
		return storage.findByPriceGreaterThan(ProductValidator.validatePrice(price));
	}
	
	@Override
	public List<ProductPort> searchAllCheaperThan(Double price) {
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
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		checkChangesInProduct(changes);
		
		Optional<ProductPort> originalObject = searchById(id);
		if (!originalObject.isPresent()) {
			throw productNotFoundException();
		}
		
		return storage.save(MergeUtil.merge(originalObject.get(), changes));
	}
	
	@Override
	public void removeById(String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		storage.deleteById(id);
	}
	
	@Override
	public Optional<ProductPort> searchById(String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
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
