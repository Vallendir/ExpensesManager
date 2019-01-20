package pl.expensesmanager.budget;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
class BudgetController implements BudgetApi, BudgetDocumentation {
	
	private final BudgetServicePort service;
	
	public BudgetPort add(Budget budget) {
		return service.create(budget);
	}
	
	public BudgetPort update(Budget budget) {
		return service.update(budget);
	}
	
	public BudgetPort update(String id, Budget budget) {
		return service.update(budget, id);
	}
	
	public void delete(String id) {
		service.delete(id);
	}
	
	public BudgetPort searchForId(String id) {
		return service.searchForId(id);
	}
	
	public BudgetPort searchForName(String name) {
		return service.searchForName(name);
	}
	
	public List<BudgetPort> searchAllForBudgetValue(Double budgetValue) {
		return service.searchAllForBudgetValue(budgetValue);
	}
	
	public List<BudgetPort> searchAllForBudgetValueRange(Double min, Double max) {
		return service.searchAllForBudgetValueRange(min, max);
	}
	
	public List<BudgetPort> searchAllForBudgetValueGreater(Double budgetValue) {
		return service.searchAllForBudgetValueGreater(budgetValue);
	}
	
	public List<BudgetPort> searchAllForBudgetValueLower(Double budgetValue) {
		return service.searchAllForBudgetValueLower(budgetValue);
	}
	
	
}
