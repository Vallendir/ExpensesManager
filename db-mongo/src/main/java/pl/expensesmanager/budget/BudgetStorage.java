package pl.expensesmanager.budget;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;
import java.util.Optional;

@Component
@Profile("dev")
public class BudgetStorage extends BaseMongoStorage<BudgetPort> implements BudgetStorePort {
	
	private BudgetRepositoryMongo repository;
	
	public BudgetStorage(BudgetRepositoryMongo repository) {
		super(repository);
		
		this.repository = repository;
	}
	
	@Override
	public Optional<BudgetPort> findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public List<BudgetPort> findByBudgetValue(Double budgetValue) {
		return repository.findByBudgetValue(budgetValue);
	}
	
	@Override
	public List<BudgetPort> findByBudgetValueBetween(Double min, Double max) {
		return repository.findByBudgetValueBetween(min, max);
	}
	
	@Override
	public List<BudgetPort> findByBudgetValueGreaterThan(Double budgetValue) {
		return repository.findByBudgetValueGreaterThan(budgetValue);
	}
	
	@Override
	public List<BudgetPort> findByBudgetValueLessThan(Double budgetValue) {
		return repository.findByBudgetValueLessThan(budgetValue);
	}
	
}
