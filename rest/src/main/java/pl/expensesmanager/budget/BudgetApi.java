package pl.expensesmanager.budget;

import org.springframework.web.bind.annotation.*;

import java.util.List;

interface BudgetApi {
	
	@PostMapping(value = "/budgets")
	Budget add(@RequestBody Budget budget);
	
	/*@PutMapping(value = "/budgets")
	Budget update(@RequestBody Budget budget);
	
	@PutMapping(value = "/budgets/{id}")
	Budget update(String id, @RequestBody Budget budget);*/
	
	@DeleteMapping(value = "/budgets/{id}")
	void delete(String id);
	
	@GetMapping(value = "/budgets/{id}")
	Budget searchForId(String id);
	
	@GetMapping(value = "/budgets", params = "name")
	Budget searchForName(@RequestParam(value = "name") String name);
	
	@GetMapping(value = "/budgets", params = "value")
	List<Budget> searchAllForBudgetValue(@RequestParam(value = "value") Double budgetValue);
	
	@GetMapping(value = "/budgets", params = { "budget-min", "budget-max" })
	List<Budget> searchAllForBudgetValueRange(
		@RequestParam(value = "budget-min") Double min, @RequestParam(value = "budget-max") Double max
	);
	
	@GetMapping(value = "/budgets", params = "budget-bigger")
	List<Budget> searchAllForBudgetValueGreater(@RequestParam(value = "budget-bigger") Double budgetValue);
	
	@GetMapping(value = "/budgets", params = "budget-lower")
	List<Budget> searchAllForBudgetValueLower(@RequestParam(value = "budget-lower") Double budgetValue);
	
}
