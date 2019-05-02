package pl.em.budget;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.Optional;

@RequiredArgsConstructor
class BudgetCommandMongoStorage implements BudgetCommandStorage {
	
	private final BudgetMongoRepository repository;
	
	@Override
	public Optional<Budget> create(Budget object) {
		return Optional.empty();
	}
	
	@Override
	public void remove(DomainID id) {
	
	}
	
}
