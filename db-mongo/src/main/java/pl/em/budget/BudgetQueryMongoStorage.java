package pl.em.budget;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.List;
import java.util.Optional;

class BudgetQueryMongoStorage extends MongoStorage<BudgetDocument, Budget, BudgetMongoMapper, BudgetMongoRepository> implements BudgetQueryStorage {
	
	private final BudgetMongoRepository repository;
	
	BudgetQueryMongoStorage(BudgetMongoRepository repository) {
		super(new BudgetMapperMongo(), repository);
		this.repository = repository;
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
