package pl.expensesmanager.budget;

import org.springframework.stereotype.Service;
import pl.expensesmanager.base.BaseService;
import pl.expensesmanager.exception.BusinessLogicExceptionFactory;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static pl.expensesmanager.exception.ValidationExceptionFactory.*;
import static pl.expensesmanager.util.CoreValidator.*;

@Service
final class BudgetService extends BaseService<Budget> {
	
	private BudgetStorePort storage;
	
	BudgetService(BudgetStorePort storage) {
		super(storage);
		this.storage = storage;
	}
	
	/**
	 * Method to search budget by name.
	 *
	 * @param name - the name of budget
	 * @return found budget as optional
	 */
	Optional<Budget> searchByName(String name) {
		return storage.findByName(validateBudgetName(name));
	}
	
	/**
	 * Method to search budgets by budget value.
	 *
	 * @param budgetValue - budget value
	 * @return found budgets objects
	 */
	List<Budget> searchAllByValue(Double budgetValue) {
		return storage.findByBudgetValue(validateBudgetValue(budgetValue));
	}
	
	/**
	 * Method to search budgets between budget value range.
	 *
	 * @param min - minimal budget value
	 * @param max - maximal budget value
	 * @return found budget objects
	 */
	List<Budget> searchAllByValueRange(Double min, Double max) {
		validateMinMaxValue(validateBudgetValue(min), validateBudgetValue(max));
		
		return storage.findByBudgetValueBetween(min, max);
	}
	
	/**
	 * Method to search budgets bigger than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<Budget> searchAllByBiggerValueThan(Double budgetValue) {
		return storage.findByBudgetValueGreaterThan(validateBudgetValue(budgetValue));
	}
	
	/**
	 * Method to search budgets less than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<Budget> searchAllByLessValueThan(Double budgetValue) {
		return storage.findByBudgetValueLessThan(validateBudgetValue(budgetValue));
	}
	
	/**
	 * Method to search budget by id.
	 *
	 * @param id - the id of budget
	 * @return found budgets list
	 */
	public Budget searchById(String id) {
		return searchObjectById(id, BusinessLogicExceptionFactory::budgetNotFoundException);
	}
	
	public Budget create(Budget object) {
		return createObject(() -> {
			if (Objects.isNull(object)) {
				throw budgetException();
			}
			
			object.setName(validateBudgetName(object.getName()));
			validateBudgetValue(object.getBudgetValue());
			
			return object;
		});
	}
	
	public Budget update(Budget originalObject, Budget changes) {
		return updateObject(originalObject, changes);
	}
	
	public Budget update(Budget changes, String id) {
		return updateObject(changes, id, BusinessLogicExceptionFactory::budgetNotFoundException);
	}
	
	@Override
	protected void checkChangesIn(Budget changes, Budget originalObject) {
		if (Objects.isNull(originalObject.getName()) && Objects.nonNull(changes.getName()) || Objects.nonNull(
			originalObject.getName()) && Objects.nonNull(changes.getName())) {
			validateBudgetName(changes.getName());
		} else if (Objects.nonNull(originalObject.getName()) && Objects.isNull(changes.getName())) {
			validateBudgetName(originalObject.getName());
		} else {
			throw budgetNameException();
		}
		
		if (Objects.isNull(originalObject.getBudgetValue()) && Objects.nonNull(changes.getBudgetValue()) ||
		    Objects.nonNull(originalObject.getBudgetValue()) && Objects.nonNull(changes.getBudgetValue())) {
			validateBudgetValue(changes.getBudgetValue());
		} else if (Objects.nonNull(originalObject.getBudgetValue()) && Objects.isNull(changes.getBudgetValue())) {
			validateBudgetValue(originalObject.getBudgetValue());
		} else {
			throw budgetValueException();
		}
	}
	
}
