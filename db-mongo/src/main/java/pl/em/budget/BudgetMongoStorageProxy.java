package pl.em.budget;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public final class BudgetMongoStorageProxy {
	
	private final BudgetCommandMongoStorage command;
	
	private final BudgetQueryMongoStorage query;
	
	public Optional<Budget> create(Budget budget) {
		return command.create(budget);
	}
	
	public void remove(DomainID id) {
		command.remove(id);
	}
	
	public Optional<Budget> searchById(DomainID id) {
		return query.searchById(id);
	}
	
	public List<Budget> searchAll() {
		return query.searchAll();
	}

}
