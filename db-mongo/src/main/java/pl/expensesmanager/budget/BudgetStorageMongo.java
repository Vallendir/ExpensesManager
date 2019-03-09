package pl.expensesmanager.budget;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;
import pl.expensesmanager.billofsale.BillOfSale;
import pl.expensesmanager.billofsale.BillOfSaleStorageMongo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Profile("mongo")
public class BudgetStorageMongo extends BaseMongoStorage<BudgetDocument, Budget> implements BudgetStorePort {
	
	private final BudgetRepositoryMongo repository;
	
	private final BillOfSaleStorageMongo billOfSaleStorageMongo;
	
	public BudgetStorageMongo(BudgetRepositoryMongo repository, BillOfSaleStorageMongo billOfSaleStorageMongo) {
		super(repository);
		this.repository = repository;
		this.billOfSaleStorageMongo = billOfSaleStorageMongo;
	}
	
	@Override
	public Optional<Budget> findByName(String name) {
		return repository.findByName(name)
		                 .map(this::map);
	}
	
	@Override
	public List<Budget> findByBudgetValue(Double budgetValue) {
		return readFromStream(repository.findByBudgetValue(budgetValue), this::map);
	}
	
	@Override
	public List<Budget> findByBudgetValueBetween(Double min, Double max) {
		return readFromStream(repository.findByBudgetValueBetween(min, max), this::map);
	}
	
	@Override
	public List<Budget> findByBudgetValueGreaterThan(Double budgetValue) {
		return readFromStream(repository.findByBudgetValueGreaterThan(budgetValue), this::map);
	}
	
	@Override
	public List<Budget> findByBudgetValueLessThan(Double budgetValue) {
		return readFromStream(repository.findByBudgetValueLessThan(budgetValue), this::map);
	}
	
	@Override
	public Optional<Budget> findById(String id) {
		return findObjectById(id, this::map);
	}
	
	@Override
	public Budget save(Budget object) {
		return saveObject(() -> {
			object.getBillsOfSaleList()
			      .forEach(billOfSale -> {
				      if (Objects.isNull(billOfSale.getId())) {
					      BillOfSale ifNoId = billOfSaleStorageMongo.save(billOfSale);
					
					      billOfSale.setId(ifNoId.getId());
				      } else {
					      Optional<BillOfSale> ifExists = billOfSaleStorageMongo.findById(billOfSale.getId());
					      if (!ifExists.isPresent()) {
						      BillOfSale existed = billOfSaleStorageMongo.save(billOfSale);
						
						      billOfSale.setId(existed.getId());
					      }
				      }
			      });
			
			return map(object);
		}, this::map);
	}
	
	@Override
	public List<Budget> findAll() {
		return findAllObjects(this::map);
	}
	
}
