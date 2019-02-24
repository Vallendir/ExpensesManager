package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expensesmanager.util.IdValidateUtil;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.minBiggerThanMaxException;
import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.productOrderNotFoundException;

@Service
@RequiredArgsConstructor
class ProductOrderService implements ProductOrderServicePort {
	
	private final ProductOrderStorePort storage;
	
	@Override
	public List<ProductOrder> searchAllByProductName(String name) {
		return storage.findByProductName(ProductValidator.validateName(name));
	}
	
	@Override
	public List<ProductOrder> searchAllByProductNameAndProductPrice(String name, Double price) {
		return storage.findByProductNameAndProductPrice(
			ProductValidator.validateName(name), ProductValidator.validatePrice(price));
	}
	
	@Override
	public List<ProductOrder> searchAllByQuanityRange(Integer min, Integer max) {
		if (min > max) {
			throw minBiggerThanMaxException();
		}
		
		return storage.findByQuanityBetween(
			ProductValidator.validateQuanity(min), ProductValidator.validateQuanity(max));
	}
	
	@Override
	public List<ProductOrder> searchAllByBiggerQuanityThan(Integer quanity) {
		return storage.findByQuanityGreaterThan(ProductValidator.validateQuanity(quanity));
	}
	
	@Override
	public List<ProductOrder> searchAllByLessQuanityThan(Integer quanity) {
		return storage.findByQuanityLessThan(ProductValidator.validateQuanity(quanity));
	}
	
	@Override
	public ProductOrder create(ProductOrder object) {
		ProductValidator.validateOrder(object);
		
		return storage.save(object);
	}
	
	@Override
	public ProductOrder update(ProductOrder object) {
		ProductValidator.validateOrder(object);
		
		return storage.save(object);
	}
	
	@Override
	public ProductOrder update(ProductOrder originalObject, ProductOrder changes) {
		checkChangesInOrder(changes);
		
		return storage.save(MergeUtil.merge(originalObject, changes));
	}
	
	@Override
	public ProductOrder update(ProductOrder changes, String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		checkChangesInOrder(changes);
		
		Optional<ProductOrder> originalObject = searchById(id);
		if (!originalObject.isPresent()) {
			throw productOrderNotFoundException();
		}
		
		return storage.save(MergeUtil.merge(originalObject.get(), changes));
	}
	
	@Override
	public void removeById(String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		storage.deleteById(id);
	}
	
	@Override
	public Optional<ProductOrder> searchById(String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		return storage.findById(id);
	}
	
	@Override
	public List<ProductOrder> searchAll() {
		return storage.findAll();
	}
	
	private void checkChangesInOrder(ProductOrder changes) {
		if (changes.getQuanity() != null) {
			ProductValidator.validateQuanity(changes.getQuanity());
		}
		
		if (changes.getProduct() != null) {
			ProductValidator.validateProduct(changes.getProduct());
		}
	}
	
}
