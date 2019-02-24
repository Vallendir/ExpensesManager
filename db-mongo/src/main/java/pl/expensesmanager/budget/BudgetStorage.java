package pl.expensesmanager.budget;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Profile("dev")
public class BudgetStorage extends BaseMongoStorage implements BudgetStorePort {
	
	private final BudgetRepositoryMongo repository;
	
	@Override
	public Optional<Budget> findByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public List<Budget> findByBudgetValue(Double budgetValue) {
		return repository.findByBudgetValue(budgetValue);
	}
	
	@Override
	public List<Budget> findByBudgetValueBetween(Double min, Double max) {
		return repository.findByBudgetValueBetween(min, max);
	}
	
	@Override
	public List<Budget> findByBudgetValueGreaterThan(Double budgetValue) {
		return repository.findByBudgetValueGreaterThan(budgetValue);
	}
	
	@Override
	public List<Budget> findByBudgetValueLessThan(Double budgetValue) {
		return repository.findByBudgetValueLessThan(budgetValue);
	}
	
	@Override
	public Budget save(Budget object) {
		return repository.save(object);
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<Budget> findById(String id) {
		return repository.findById(id);
	}
	
	@Override
	public List<Budget> findAll() {
		return repository.findAll();
	}
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
