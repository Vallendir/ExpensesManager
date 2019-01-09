package pl.expensesmanager.budget;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
class BudgetController implements BudgetApi, BudgetDocumentation {
	
	public Budget add(Budget budget) {
		return null;
	}
	
	public Budget update(Budget budget) {
		return null;
	}
	
	public Budget update(String id, Budget budget) {
		return null;
	}
	
	public void delete(String id) {
	
	}
	
	public Budget searchForId(String id) {
		return null;
	}
	
	public Budget searchForName(String name) {
		return null;
	}
	
	public List<Budget> searchAllForBudgetValue(Double budgetValue) {
		return null;
	}
	
	public List<Budget> searchAllForBudgetValueRange(Double min, Double max) {
		return null;
	}
	
	public List<Budget> searchAllForBudgetValueGreater(Double budgetValue) {
		return null;
	}
	
	public List<Budget> searchAllForBudgetValueLower(Double budgetValue) {
		return null;
	}
	
	
}
