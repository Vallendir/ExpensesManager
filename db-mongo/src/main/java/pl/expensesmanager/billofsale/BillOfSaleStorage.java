package pl.expensesmanager.billofsale;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Component
@Profile("dev")
public class BillOfSaleStorage extends BaseMongoStorage<BillOfSalePort> implements BillOfSaleStorePort {
	
	private BillOfSaleRepositoryMongo repository;
	
	public BillOfSaleStorage(BillOfSaleRepositoryMongo repository) {
		super(repository);
		
		this.repository = repository;
	}
	
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
	
}
