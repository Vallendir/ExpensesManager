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
	public Optional<BudgetPort> findByName(String name) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getName()
		                                                       .equals(name))
		                               .findFirst();
	}
	
	@Override
	public List<BudgetPort> findByBudgetValue(Double budgetValue) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getBudgetValue()
		                                                       .equals(budgetValue))
		                               .collect(Collectors.toList());
	}
	
	@Override
	public List<BudgetPort> findByBudgetValueBetween(Double min, Double max) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getBudgetValue() > min && budget.getBudgetValue() < max)
		                               .collect(Collectors.toList());
	}
	
	@Override
	public List<BudgetPort> findByBudgetValueGreaterThan(Double budgetValue) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getBudgetValue() > budgetValue)
		                               .collect(Collectors.toList());
	}
	
	@Override
	public List<BudgetPort> findByBudgetValueLessThan(Double budgetValue) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getBudgetValue() < budgetValue)
		                               .collect(Collectors.toList());
	}
	
	@Override
	public BudgetPort save(BudgetPort object) {
		BudgetSimulatedData.LIST.add(object);
		return object;
		
	}
	
	/*@Override
	public BudgetPort update(BudgetPort object) {
		Optional<BudgetPort> result = BudgetSimulatedData.LIST.stream()
		                                                      .filter(budget -> budget.getId()
		                                                                              .equals(object.getId()))
		                                                      .findFirst();
		
		if (!result.isPresent()) {
			return null;
		}
		
		BudgetPort updatedBudget = MergeUtil.merge(result.get(), object);
		BudgetSimulatedData.LIST.remove(result.get());
		BudgetSimulatedData.LIST.save(updatedBudget);
		
		return updatedBudget;
		
	}
	
	@Override
	public BudgetPort update(BudgetPort originalObject, BudgetPort changes) {
		Optional<BudgetPort> result = BudgetSimulatedData.LIST.stream()
		                                                      .filter(budget -> budget.getId()
		                                                                              .equals(originalObject.getId()))
		                                                      .findFirst();
		
		if (!result.isPresent()) {
			return null;
		}
		
		BudgetPort updatedBudget = MergeUtil.merge(result.get(), changes);
		
		BudgetSimulatedData.LIST.remove(result.get());
		BudgetSimulatedData.LIST.save(updatedBudget);
		
		return updatedBudget;
		
	}
	
	@Override
	public BudgetPort update(String id, BudgetPort changes) {
		Optional<BudgetPort> result = BudgetSimulatedData.LIST.stream()
		                                                      .filter(budget -> budget.getId()
		                                                                              .equals(id))
		                                                      .findFirst();
		
		if (!result.isPresent()) {
			return null;
		}
		
		BudgetPort updatedBudget = MergeUtil.merge(result.get(), changes);
		
		BudgetSimulatedData.LIST.remove(BudgetSimulatedData.LIST.indexOf(result.get()));
		BudgetSimulatedData.LIST.save(updatedBudget);
		
		return updatedBudget;
	}*/
	
	@Override
	public void deleteById(String id) {
		BudgetSimulatedData.LIST.removeIf(budget -> budget.getId()
		                                                  .equals(id));
	}
	
	@Override
	public Optional<BudgetPort> findById(String id) {
		return BudgetSimulatedData.LIST.stream()
		                               .filter(budget -> budget.getId()
		                                                       .equals(id))
		                               .findFirst();
	}
	
	@Override
	public List<BudgetPort> findAll() {
		return BudgetSimulatedData.LIST;
	}
	
}
