package pl.em.budget;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.Optional;

class BudgetCommandMongoStorage extends MongoStorage<BudgetDocument, Budget, BudgetMongoMapper, BudgetMongoRepository> implements BudgetCommandStorage {
	
	private final BudgetMongoRepository repository;
	
	BudgetCommandMongoStorage(BudgetMongoRepository repository) {
		super(new BudgetMongoMapperImpl(), repository);
		this.repository = repository;
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
