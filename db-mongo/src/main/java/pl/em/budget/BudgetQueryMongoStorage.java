package pl.em.budget;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
class BudgetQueryMongoStorage implements BudgetQueryStorage {
	
	private final BudgetMongoRepository repository;
	
	@Override
	public Optional<Budget> searchById(DomainID id) {
		return Optional.empty();
	}
	
	@Override
	public List<Budget> searchAll() {
		return null;
	}
	
}
