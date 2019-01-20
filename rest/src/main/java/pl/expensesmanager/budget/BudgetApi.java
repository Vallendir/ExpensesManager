package pl.expensesmanager.budget;

import org.springframework.web.bind.annotation.*;

import java.util.List;

interface BudgetApi {
	
	@PostMapping(value = "/budgets")
	BudgetPort add(@RequestBody Budget budget);
	
	@PutMapping(value = "/budgets")
	BudgetPort update(@RequestBody Budget budget);
	
	@PutMapping(value = "/budgets/{id}")
	BudgetPort update(String id, @RequestBody Budget budget);
	
	@DeleteMapping(value = "/budgets/{id}")
	void delete(String id);
	
	@GetMapping(value = "/budgets/{id}")
	BudgetPort searchForId(String id);
	
	@GetMapping(value = "/budgets", params = "name")
	BudgetPort searchForName(@RequestParam(value = "name") String name);
	
	@GetMapping(value = "/budgets", params = "value")
	List<BudgetPort> searchAllForBudgetValue(@RequestParam(value = "value") Double budgetValue);
	
	@GetMapping(value = "/budgets", params = { "budget-min", "budget-max" })
	List<BudgetPort> searchAllForBudgetValueRange(
		@RequestParam(value = "budget-min") Double min, @RequestParam(value = "budget-max") Double max
	);
	
	@GetMapping(value = "/budgets", params = "budget-bigger")
	List<BudgetPort> searchAllForBudgetValueGreater(@RequestParam(value = "budget-bigger") Double budgetValue);
	
	@GetMapping(value = "/budgets", params = "budget-lower")
	List<BudgetPort> searchAllForBudgetValueLower(@RequestParam(value = "budget-lower") Double budgetValue);
	
}
