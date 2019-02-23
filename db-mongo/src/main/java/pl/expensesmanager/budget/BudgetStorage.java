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
	
	@Override
	public BudgetPort save(BudgetPort object) {
		return repository.save(object);
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<BudgetPort> findById(String id) {
		return repository.findById(id);
	}
	
	@Override
	public List<BudgetPort> findAll() {
		return repository.findAll();
	}
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
