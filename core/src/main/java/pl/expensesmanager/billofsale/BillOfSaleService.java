package pl.expensesmanager.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
class BillOfSaleService implements BillOfSaleServicePort {
	
	private final BillOfSaleStorePort storage;
	
	@Override
	public Optional<BillOfSalePort> searchForDescription(String description) {
		return storage.findByDescription(BillOfSaleValidator.validateDescription(description));
	}
	
	@Override
	public List<BillOfSalePort> searchForBoughtDate(Instant boughtDate) {
		return storage.findByBoughtDate(BillOfSaleValidator.validateBoughtDate(boughtDate));
	}
	
	@Override
	public List<BillOfSalePort> searchAllForBoughtDateRange(Instant min, Instant max) {
		if (min.isAfter(max)) {
			throw new RuntimeException();
		}
		
		return storage.findByBoughtDateBetween(
			BillOfSaleValidator.validateBoughtDate(min), BillOfSaleValidator.validateBoughtDate(max));
	}
	
	@Override
	public BillOfSalePort create(BillOfSalePort object) {
		BillOfSaleValidator.validateBillOfSale(object);
		
		return storage.add(object);
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort object) {
		BillOfSaleValidator.validateBillOfSale(object);
		
		return storage.update(object);
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort originalObject, BillOfSalePort changes) {
		checkChangesInBillOfSale(changes);
		
		return storage.update(originalObject, changes);
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort changes, String id) {
		checkChangesInBillOfSale(changes);
		
		return storage.update(id, changes);
	}
	
	@Override
	public boolean delete(String id) {
		return storage.remove(id);
	}
	
	@Override
	public Optional<BillOfSalePort> searchForId(String id) {
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
