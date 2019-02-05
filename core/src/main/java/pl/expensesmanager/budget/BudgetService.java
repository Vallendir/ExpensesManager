package pl.expensesmanager.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
class BudgetService implements BudgetServicePort {
	
	private final BudgetStorePort storage;
	
	@Override
	public Optional<BudgetPort> searchForName(String name) {
		return storage.findByName(name);
	}
	
	@Override
	public List<BudgetPort> searchAllForBudgetValue(Double budgetValue) {
		return storage.findByBudgetValue(budgetValue);
	}
	
	@Override
	public List<BudgetPort> searchAllForBudgetValueRange(Double min, Double max) {
		return storage.findByBudgetValueBetween(min, max);
	}
	
	@Override
	public List<BudgetPort> searchAllForBudgetValueGreater(Double budgetValue) {
		return storage.findByBudgetValueGreaterThan(budgetValue);
	}
	
	@Override
	public List<BudgetPort> searchAllForBudgetValueLower(Double budgetValue) {
		return storage.findByBudgetValueLessThan(budgetValue);
	}
	
	@Override
	public BudgetPort create(BudgetPort object) {
		return storage.add(object);
	}
	
	@Override
	public BudgetPort update(BudgetPort object) {
		return storage.update(object);
	}
	
	@Override
	public BudgetPort update(BudgetPort originalObject, BudgetPort changes) {
		return storage.update(originalObject, changes);
	}
	
	@Override
	public BudgetPort update(BudgetPort changes, String id) {
		return storage.update(id, changes);
	}
	
	@Override
	public boolean delete(String id) {
		return storage.remove(id);
	}
	
	@Override
	public Optional<BudgetPort> searchForId(String id) {
		return storage.findById(id);
	}
	
	@Override
	public List<BudgetPort> searchAll() {
		return storage.findAll();
	}
	
}
