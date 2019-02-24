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
	public Optional<BillOfSale> findByDescription(String description) {
		return null;
	}
	
	@Override
	public List<BillOfSale> findByBoughtDate(Instant boughtDate) {
		return null;
	}
	
	@Override
	public List<BillOfSale> findByBoughtDateBetween(Instant min, Instant max) {
		return null;
	}
	
	@Override
	public BillOfSale save(BillOfSale object) {
		return null;
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<BillOfSale> findById(String id) {
		return null;
	}
	
	@Override
	public List<BillOfSale> findAll() {
		return null;
	}
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
