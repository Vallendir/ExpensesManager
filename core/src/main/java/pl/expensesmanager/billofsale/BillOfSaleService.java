package pl.expensesmanager.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expensesmanager.util.MergeUtil;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.ValidationExceptionFactory.invalidIdException;

@RequiredArgsConstructor
@Service
class BillOfSaleService implements BillOfSaleServicePort {
	
	private final BillOfSaleStorePort storage;
	
	@Override
	public Optional<BillOfSalePort> searchByDescription(String description) {
		return storage.findByDescription(BillOfSaleValidator.validateDescription(description));
	}
	
	@Override
	public List<BillOfSalePort> searchAllByBoughtDate(Instant boughtDate) {
		return storage.findByBoughtDate(BillOfSaleValidator.validateBoughtDate(boughtDate));
	}
	
	@Override
	public List<BillOfSalePort> searchAllByBoughtDateRange(Instant min, Instant max) {
		if (min.isAfter(max)) {
			throw new RuntimeException();
		}
		
		return storage.findByBoughtDateBetween(
			BillOfSaleValidator.validateBoughtDate(min), BillOfSaleValidator.validateBoughtDate(max));
	}
	
	@Override
	public BillOfSalePort create(BillOfSalePort object) {
		BillOfSaleValidator.validateBillOfSale(object);
		
		return storage.save(object);
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort object) {
		BillOfSaleValidator.validateBillOfSale(object);
		
		return storage.save(object);
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort originalObject, BillOfSalePort changes) {
		checkChangesInBillOfSale(changes);
		
		return storage.save(MergeUtil.merge(originalObject, changes));
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort changes, String id) {
		checkChangesInBillOfSale(changes);
		
		Optional<BillOfSalePort> originalObject = searchById(id);
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
	public Optional<BillOfSalePort> searchById(String id) {
		return storage.findById(id);
	}
	
	@Override
	public List<BillOfSalePort> searchAll() {
		return storage.findAll();
	}
	
	private void checkChangesInBillOfSale(BillOfSalePort changes) {
		if (changes.getDescription() != null) {
			BillOfSaleValidator.validateDescription(changes.getDescription());
		}
		
		if (changes.getBoughtDate() != null) {
			BillOfSaleValidator.validateBoughtDate(changes.getBoughtDate());
		}
	}
	
}
