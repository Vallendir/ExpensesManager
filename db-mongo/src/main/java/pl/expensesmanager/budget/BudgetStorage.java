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
		return null;
	}
	
	@Override
	public List<Budget> findByBudgetValue(Double budgetValue) {
		return null;
	}
	
	@Override
	public List<Budget> findByBudgetValueBetween(Double min, Double max) {
		return null;
	}
	
	@Override
	public List<Budget> findByBudgetValueGreaterThan(Double budgetValue) {
		return null;
	}
	
	@Override
	public List<Budget> findByBudgetValueLessThan(Double budgetValue) {
		return null;
	}
	
	@Override
	public Budget save(Budget object) {
		return null;
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<Budget> findById(String id) {
		return null;
	}
	
	@Override
	public List<Budget> findAll() {
		return null;
	}
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
}
