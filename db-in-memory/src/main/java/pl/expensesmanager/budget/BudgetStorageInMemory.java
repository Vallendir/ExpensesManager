package pl.expensesmanager.budget;

import org.springframework.context.annotation.Profile;
import pl.expensesmanager.IdValidationPort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of budget storage
 */
@Profile("in-memory")
public class BudgetStorageInMemory extends IdValidationPort implements BudgetStorePort {
	
	@Override
	public Optional<Budget> findByName(String name) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getName()
		                                                       .equals(name))
		                               .findFirst();
	}
	
	@Override
	public List<Budget> findByBudgetValue(Double budgetValue) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getBudgetValue()
		                                                       .equals(budgetValue))
		                               .collect(Collectors.toList());
	}
	
	@Override
	public List<Budget> findByBudgetValueBetween(Double min, Double max) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getBudgetValue() > min && budget.getBudgetValue() < max)
		                               .collect(Collectors.toList());
	}
	
	@Override
	public List<Budget> findByBudgetValueGreaterThan(Double budgetValue) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getBudgetValue() > budgetValue)
		                               .collect(Collectors.toList());
	}
	
	@Override
	public List<Budget> findByBudgetValueLessThan(Double budgetValue) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getBudgetValue() < budgetValue)
		                               .collect(Collectors.toList());
	}
	
	@Override
	public Budget save(Budget object) {
		BudgetSimulatedData.LIST.add(object);
		return object;
		
	}
	
	@Override
	public void deleteById(String id) {
		BudgetSimulatedData.LIST.removeIf(budget -> budget.getId()
		                                                  .equals(id));
	}
	
	@Override
	public Optional<Budget> findById(String id) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getId()
		                                                       .equals(id))
		                               .findFirst();
	}
	
	@Override
	public List<Budget> findAll() {
		return BudgetSimulatedData.LIST;
	}
	
}
