package pl.expensesmanager.billofsale;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Profile("dev")
public class BillOfSaleStorage extends BaseMongoStorage implements BillOfSaleStorePort {
	
	private final BillOfSaleRepositoryMongo repository;
	
	@Override
	public Optional<BillOfSalePort> findByDescription(String description) {
		return repository.findByDescription(description);
	}
	
	@Override
	public List<BillOfSalePort> findByBoughtDate(Instant boughtDate) {
		return repository.findByBoughtDate(boughtDate);
	}
	
	@Override
	public List<BillOfSalePort> findByBoughtDateBetween(Instant min, Instant max) {
		return repository.findByBoughtDateBetween(min, max);
	}
	
	@Override
	public BillOfSalePort save(BillOfSalePort object) {
		return repository.save(object);
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<BillOfSalePort> findById(String id) {
		return repository.findById(id);
	}
	
	@Override
	public List<BillOfSalePort> findAll() {
		return repository.findAll();
	}
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
