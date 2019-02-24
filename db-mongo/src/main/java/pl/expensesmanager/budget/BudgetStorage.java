package pl.expensesmanager.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;
import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.billofsale.BillOfSaleStorage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@Profile("dev")
public class BudgetStorage extends BaseMongoStorage implements BudgetStorePort {
	
	private final BudgetRepositoryMongo repository;
	
	private final BillOfSaleStorage billOfSaleStorage;
	
	@Override
	public Optional<Budget> findByName(String name) {
		return repository.findByName(name)
		                 .map(this::map);
	}
	
	@Override
	public List<Budget> findByBudgetValue(Double budgetValue) {
		return repository.findByBudgetValue(budgetValue)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<Budget> findByBudgetValueBetween(Double min, Double max) {
		return repository.findByBudgetValueBetween(min, max)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<Budget> findByBudgetValueGreaterThan(Double budgetValue) {
		return repository.findByBudgetValueGreaterThan(budgetValue)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<Budget> findByBudgetValueLessThan(Double budgetValue) {
		return repository.findByBudgetValueLessThan(budgetValue)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public Optional<Budget> findById(String id) {
		return repository.findById(id)
		                 .map(this::map);
	}
	
	@Override
	public Budget save(Budget object) {
		object.getBillsOfSaleList()
		      .forEach(billOfSale -> {
			      if (billOfSale.getId() == null) {
				      BillOfSale ifNoId = billOfSaleStorage.save(billOfSale);
				
				      billOfSale.setId(ifNoId.getId());
			      } else {
				      Optional<BillOfSale> ifExists = billOfSaleStorage.findById(billOfSale.getId());
				      if (!ifExists.isPresent()) {
					      BillOfSale existed = billOfSaleStorage.save(billOfSale);
					
					      billOfSale.setId(existed.getId());
				      }
			      }
		      });
		
		return map(repository.save(map(object)));
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<Budget> findAll() {
		return repository.findAll()
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
}
