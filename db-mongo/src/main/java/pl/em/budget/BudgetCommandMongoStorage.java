package pl.em.budget;

import pl.em.billofsale.BillOfSaleMongoStorageProxy;
import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.Optional;

class BudgetCommandMongoStorage extends MongoStorage<BudgetDocument, Budget, BudgetMongoMapper, BudgetMongoRepository> implements BudgetCommandStorage {
	
	private final BudgetMongoRepository repository;
	
	private final BillOfSaleMongoStorageProxy billProxy;
	
	BudgetCommandMongoStorage(BudgetMongoRepository repository, BillOfSaleMongoStorageProxy billProxy) {
		super(new BudgetMapperMongo(), repository);
		this.repository = repository;
		this.billProxy = billProxy;
	}
	
	@Override
	public Optional<Budget> create(Budget budget) {
		return Optional.of(store(budget));
	}
	
	@Override
	public void remove(DomainID id) {
		delete(id.getId());
	}
	
}
