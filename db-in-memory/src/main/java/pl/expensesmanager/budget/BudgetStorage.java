package pl.expensesmanager.budget;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.expensesmanager.util.MergeUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of budget storage
 */
@Repository
@Profile("dev")
public class BudgetStorage implements BudgetStorePort {
	
	@Override
	public Optional<BudgetPort> findByName(String name) {
		return BudgetSimulatedData.LIST.stream()
		                         .filter(budget -> budget.getName().equals(name))
		                         .findFirst();
	}
	
	@Override
	public List<BudgetPort> findByBudgetValue(Double budgetValue) {
		return BudgetSimulatedData.LIST.stream()
		                                   .filter(budget -> budget.getBudgetValue().equals(budgetValue))
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
	public BudgetPort add(BudgetPort object) {
		if (BudgetSimulatedData.LIST.add(object)) {
			return object;
		} else {
			throw new RuntimeException();
		}
	}
	
	@Override
	public BudgetPort update(BudgetPort object) {
		Optional<BudgetPort> result = BudgetSimulatedData.LIST.stream()
		                                                              .filter(budget -> budget.getId().equals(object.getId()))
		                                                              .findFirst();
		
		if (result.isPresent()) {
			BudgetPort updatedBudget = MergeUtil.merge(result.get(), object);
			
			BudgetSimulatedData.LIST.remove(BudgetSimulatedData.LIST.indexOf(result.get()));
			BudgetSimulatedData.LIST.add(updatedBudget);
			
			return updatedBudget;
		} else {
			throw new RuntimeException();
		}
	}
	
	@Override
	public BudgetPort update(BudgetPort originalObject, BudgetPort changes) {
		Optional<BudgetPort> result = BudgetSimulatedData.LIST.stream()
		                                                              .filter(budget -> budget.getId().equals(originalObject.getId()))
		                                                              .findFirst();
		
		if (result.isPresent()) {
			BudgetPort updatedBudget = MergeUtil.merge(result.get(), changes);
			
			BudgetSimulatedData.LIST.remove(BudgetSimulatedData.LIST.indexOf(result.get()));
			BudgetSimulatedData.LIST.add(updatedBudget);
			
			return updatedBudget;
		} else {
			throw new RuntimeException();
		}
	}
	
	@Override
	public BudgetPort update(String id, BudgetPort changes) {
		Optional<BudgetPort> result = BudgetSimulatedData.LIST.stream()
		                                                              .filter(budget -> budget.getId().equals(id))
		                                                              .findFirst();
		
		if (result.isPresent()) {
			BudgetPort updatedBudget = MergeUtil.merge(result.get(), changes);
			
			BudgetSimulatedData.LIST.remove(BudgetSimulatedData.LIST.indexOf(result.get()));
			BudgetSimulatedData.LIST.add(updatedBudget);
			
			return updatedBudget;
		} else {
			throw new RuntimeException();
		}
	}
	
	@Override
	public boolean remove(String id) {
		return BudgetSimulatedData.LIST.removeIf(budget -> budget.getId()
		                                                               .equals(id));
	}
	
	@Override
	public Optional<BudgetPort> findById(String id) {
		return BudgetSimulatedData.LIST.stream()
		                                   .filter(budget -> budget.getId().equals(id))
		                                   .findFirst();
	}
	
	@Override
	public List<BudgetPort> findAll() {
		return BudgetSimulatedData.LIST;
	}
	
}
