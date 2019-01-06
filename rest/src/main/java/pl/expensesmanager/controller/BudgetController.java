package pl.expensesmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import pl.expensesmanager.api.BudgetApi;
import pl.expensesmanager.documentation.BudgetDocumentation;
import pl.expensesmanager.domain.BudgetPort;

import java.util.List;

@Slf4j
@RestController
public class BudgetController implements BudgetApi, BudgetDocumentation {
	
	public BudgetPort add(BudgetPort budget) {
		return null;
	}
	
	public BudgetPort update(BudgetPort budget) {
		return null;
	}
	
	public BudgetPort update(String id, BudgetPort budget) {
		return null;
	}
	
	public void delete(String id) {
	
	}
	
	public BudgetPort searchForId(String id) {
		return null;
	}
	
	public BudgetPort searchForName(String name) {
		return null;
	}
	
	public List<BudgetPort> searchAllForBudgetValue(Double budgetValue) {
		return null;
	}
	
	public List<BudgetPort> searchAllForBudgetValueRange(Double min, Double max) {
		return null;
	}
	
	public List<BudgetPort> searchAllForBudgetValueGreater(Double budgetValue) {
		return null;
	}
	
	public List<BudgetPort> searchAllForBudgetValueLower(Double budgetValue) {
		return null;
	}
	
	
}
