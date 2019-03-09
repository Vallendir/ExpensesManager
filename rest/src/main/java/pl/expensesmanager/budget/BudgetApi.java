package pl.expensesmanager.budget;

import org.springframework.web.bind.annotation.*;

import java.util.List;

interface BudgetApi {
	
	@GetMapping(value = "/budgets/{id}")
	Budget searchForId(String id);
	
	@GetMapping(value = "/budgets", params = "name")
	Budget searchForName(@RequestParam(value = "name") String name);
	
	@GetMapping(value = "/budgets")
	List<Budget> searchAll();
	
	@GetMapping(value = "/budgets", params = "value")
	List<Budget> searchAllForBudgetValue(@RequestParam(value = "value") Double budgetValue);
	
	@GetMapping(value = "/budgets", params = { "budgetMin", "budgetMax" })
	List<Budget> searchAllForBudgetValueRange(
		@RequestParam(value = "budgetMin") Double budgetMin, @RequestParam(value = "budgetMax") Double budgetMax
	);
	
	@GetMapping(value = "/budgets", params = "budgetBigger")
	List<Budget> searchAllForBudgetValueGreater(@RequestParam(value = "budgetBigger") Double budgetBigger);
	
	@GetMapping(value = "/budgets", params = "budgetLower")
	List<Budget> searchAllForBudgetValueLower(@RequestParam(value = "budgetLower") Double budgetLower);
	
	@PostMapping(value = "/budgets")
	Budget add(@RequestBody Budget budget);
	
	@PutMapping(value = "/budgets")
	Budget update(@RequestBody Budget budget);
	
	@PutMapping(value = "/budgets/{id}")
	Budget update(String id, @RequestBody Budget budget);
	
	@DeleteMapping(value = "/budgets/{id}")
	void delete(String id);
	
}
