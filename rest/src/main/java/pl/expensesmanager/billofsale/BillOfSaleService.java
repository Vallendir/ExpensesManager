package pl.expensesmanager.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Service
class BillOfSaleService implements BillOfSaleServicePort {
	
	private final BillOfSaleStorePort storage;
	
	@Override
	public BillOfSalePort searchForDescription(String description) {
		return storage.findByDescription(description)
		              .orElse(new BillOfSaleNullObject());
	}
	
	@Override
	public List<BillOfSalePort> searchForBoughtDate(Instant boughtDate) {
		return storage.findByBoughtDate(boughtDate);
	}
	
	@Override
	public List<BillOfSalePort> searchAllForBoughtDateRange(Instant min, Instant max) {
		return storage.findByBoughtDateBetween(min, max);
	}
	
	@Override
	public BillOfSalePort create(BillOfSalePort object) {
		return storage.add(object);
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort object) {
		return storage.update(object);
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort originalObject, BillOfSalePort changes) {
		return storage.update(originalObject, changes);
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort changes, String id) {
		return storage.update(id, changes);
	}
	
	@Override
	public boolean delete(String id) {
		return storage.remove(id);
	}
	
	@Override
	public BillOfSalePort searchForId(String id) {
		return storage.findById(id)
		              .orElse(new BillOfSaleNullObject());
	}
	
	@Override
	public List<BillOfSalePort> searchAll() {
		return storage.findAll();
	}
	
}
