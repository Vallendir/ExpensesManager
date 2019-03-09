package pl.expensesmanager.budget;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import pl.expensesmanager.base.BaseRESTController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
class BudgetRESTController extends BaseRESTController<Budget> implements BudgetApi, BudgetDocumentation {
	
	private final BudgetService service;
	
	BudgetRESTController(BudgetService service) {
		super(service);
		this.service = service;
	}
	
	public Budget searchForName(String name) {
		Optional<Budget> budget = service.searchByName(name);
		
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
	
	public List<Budget> searchAll() {
		return super.searchAll();
	}
	
	public void delete(String id) {
		super.delete(id);
	}
	
}
