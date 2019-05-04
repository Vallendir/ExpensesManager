package pl.em.budget;

import pl.em.billofsale.BillOfSaleMongoStorageProxy;
import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.List;
import java.util.Optional;

class BudgetQueryMongoStorage extends MongoStorage<BudgetDocument, Budget, BudgetMongoMapper, BudgetMongoRepository> implements BudgetQueryStorage {
	
	private final BudgetMongoRepository repository;
	
	private final BillOfSaleMongoStorageProxy billProxy;
	
	BudgetQueryMongoStorage(BudgetMongoRepository repository, BillOfSaleMongoStorageProxy billProxy) {
		super(new BudgetMapperMongo(), repository);
		this.repository = repository;
		this.billProxy = billProxy;
	}
	
	@Override
	public Optional<Budget> searchById(DomainID id) {
		return Optional.empty();
	}
	
	@Override
	public List<Budget> searchAll() {
		return null;
	}
	
}
