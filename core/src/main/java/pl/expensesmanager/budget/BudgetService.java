package pl.expensesmanager.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.ValidationExceptionFactory.invalidIdFormatException;

@RequiredArgsConstructor
@Service
class BudgetService implements BudgetServicePort {
	
	private final BudgetStorePort storage;
	
	@Override
	public Optional<BudgetPort> searchByName(String name) {
		return storage.findByName(BudgetValidator.validateName(name));
	}
	
	@Override
	public List<BudgetPort> searchAllByValue(Double budgetValue) {
		return storage.findByBudgetValue(BudgetValidator.validateBudgetValue(budgetValue));
	}
	
	@Override
	public List<BudgetPort> searchAllByValueRange(Double min, Double max) {
		if (min > max) {
			throw new RuntimeException();
		}
		
		return storage.findByBudgetValueBetween(
			BudgetValidator.validateBudgetValue(min), BudgetValidator.validateBudgetValue(max));
	}
	
	@Override
	public List<BudgetPort> searchAllByBiggerValueThan(Double budgetValue) {
		return storage.findByBudgetValueGreaterThan(BudgetValidator.validateBudgetValue(budgetValue));
	}
	
	@Override
	public List<BudgetPort> searchAllByLessValueThan(Double budgetValue) {
		return storage.findByBudgetValueLessThan(BudgetValidator.validateBudgetValue(budgetValue));
	}
	
	@Override
	public BudgetPort create(BudgetPort object) {
		BudgetValidator.validateBudget(object);
		
		return storage.save(object);
	}
	
	@Override
	public BudgetPort update(BudgetPort object) {
		BudgetValidator.validateBudget(object);
		
		return storage.save(object);
	}
	
	@Override
	public BudgetPort update(BudgetPort originalObject, BudgetPort changes) {
		checkChangesInBudget(changes);
		
		return storage.save(MergeUtil.merge(originalObject, changes));
	}
	
	@Override
	public BudgetPort update(BudgetPort changes, String id) {
		checkChangesInBudget(changes);
		
		Optional<BudgetPort> originalObject = searchById(id);
		if (!originalObject.isPresent()) {
			throw invalidIdFormatException();
		}
		
		return storage.save(MergeUtil.merge(originalObject.get(), changes));
	}
	
	@Override
	public void removeById(String id) {
		storage.deleteById(id);
	}
	
	@Override
	public Optional<BudgetPort> searchById(String id) {
		return storage.findById(id);
	}
	
	@Override
	public List<BudgetPort> searchAll() {
		return storage.findAll();
	}
	
	private void checkChangesInBudget(BudgetPort changes) {
		if (changes.getName() != null) {
			BudgetValidator.validateName(changes.getName());
		}
		
		if (changes.getBudgetValue() != null) {
			BudgetValidator.validateBudgetValue(changes.getBudgetValue());
		}
	}
	
}
