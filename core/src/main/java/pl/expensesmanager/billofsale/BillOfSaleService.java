package pl.expensesmanager.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expensesmanager.util.IdValidateUtil;
import pl.expensesmanager.util.MergeUtil;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.*;

@RequiredArgsConstructor
@Service
class BillOfSaleService implements BillOfSaleServicePort {
	
	private final BillOfSaleStorePort storage;
	
	@Override
	public Optional<BillOfSale> searchByDescription(String description) {
		return storage.findByDescription(BillOfSaleValidator.validateDescription(description));
	}
	
	@Override
	public List<BillOfSale> searchAllByBoughtDate(Instant boughtDate) {
		return storage.findByBoughtDate(BillOfSaleValidator.validateBoughtDate(boughtDate));
	}
	
	@Override
	public List<BillOfSale> searchAllByBoughtDateRange(Instant min, Instant max) {
		if (min.isAfter(max)) {
			throw minBiggerThanMaxException();
		}
		
		return storage.findByBoughtDateBetween(
			BillOfSaleValidator.validateBoughtDate(min), BillOfSaleValidator.validateBoughtDate(max));
	}
	
	@Override
	public BillOfSale create(BillOfSale object) {
		BillOfSaleValidator.validateBillOfSale(object);
		
		return storage.save(object);
	}
	
	@Override
	public BillOfSale update(BillOfSale object) {
		BillOfSaleValidator.validateBillOfSale(object);
		
		BillOfSale billOfSale = storage.save(object);
		checkIfBillOfSaleWasUpdated(billOfSale);
		
		return billOfSale;
	}
	
	@Override
	public BillOfSale update(BillOfSale originalObject, BillOfSale changes) {
		checkChangesInBillOfSale(changes);
		
		BillOfSale billOfSale = storage.save(MergeUtil.merge(originalObject, changes));
		checkIfBillOfSaleWasUpdated(billOfSale);
		
		return billOfSale;
	}
	
	@Override
	public BillOfSale update(BillOfSale changes, String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		checkChangesInBillOfSale(changes);
		
		Optional<BillOfSale> originalObject = searchById(id);
		if (!originalObject.isPresent()) {
			throw billOfSaleNotFoundException();
		}
		
		BillOfSale billOfSale = storage.save(MergeUtil.merge(originalObject.get(), changes));
		checkIfBillOfSaleWasUpdated(billOfSale);
		
		return billOfSale;
	}
	
	@Override
	public void removeById(String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		storage.deleteById(id);
	}
	
	@Override
	public Optional<BillOfSale> searchById(String id) {
		IdValidateUtil.checkIfGivenIdIsValid(storage, id);
		return storage.findById(id);
	}
	
	@Override
	public List<BillOfSale> searchAll() {
		return storage.findAll();
	}
	
	private void checkChangesInBillOfSale(BillOfSale changes) {
		if (changes.getDescription() != null) {
			BillOfSaleValidator.validateDescription(changes.getDescription());
		}
		
		if (changes.getBoughtDate() != null) {
			BillOfSaleValidator.validateBoughtDate(changes.getBoughtDate());
		}
	}
	
	private void checkIfBillOfSaleWasUpdated(BillOfSale billOfSale) {
		if (billOfSale == null) {
			throw billOfSaleNotUpdatedException();
		}
	}
	
}
