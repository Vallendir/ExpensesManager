package pl.expensesmanager.budget;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.budgetNotFoundException;

@Slf4j
@RequiredArgsConstructor
@RestController
class BudgetController implements BudgetApi, BudgetDocumentation {
	
	private final BudgetServicePort service;
	
	public Budget add(Budget budget) {
		return service.create(budget);
	}
	
	public Budget update(Budget budget) {
		return service.update(budget);
	}
	
	public Budget update(String id, Budget budget) {
		return service.update(budget, id);
	}
	
	public void delete(String id) {
		service.removeById(id);
	}
	
	public Budget searchForId(String id) {
		Optional<Budget> budget = service.searchById(id);
		checkIfBudgetNotFound(budget);
		
		return budget.get();
	}
	
	public Budget searchForName(String name) {
		Optional<Budget> budget = service.searchByName(name);
		checkIfBudgetNotFound(budget);
		
		return budget.get();
	}
	
	public List<Budget> searchAllForBudgetValue(Double budgetValue) {
		return service.searchAllByValue(budgetValue);
	}
	
	public List<Budget> searchAllForBudgetValueRange(Double min, Double max) {
		return service.searchAllByValueRange(min, max);
	}
	
	public List<Budget> searchAllForBudgetValueGreater(Double budgetValue) {
		return service.searchAllByBiggerValueThan(budgetValue);
	}
	
	public List<Budget> searchAllForBudgetValueLower(Double budgetValue) {
		return service.searchAllByLessValueThan(budgetValue);
	}
	
	private void checkIfBudgetNotFound(Optional<Budget> budget) {
		if (!budget.isPresent()) {
			throw budgetNotFoundException();
		}
	}
	
}
