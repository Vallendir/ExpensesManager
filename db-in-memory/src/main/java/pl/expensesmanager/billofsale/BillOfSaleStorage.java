package pl.expensesmanager.billofsale;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import pl.expensesmanager.util.MergeUtil;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of bill of sale storage
 */
@Repository
@Profile("dev")
public class BillOfSaleStorage implements BillOfSaleStorePort {
	
	@Override
	public Optional<BillOfSalePort> findByDescription(String description) {
		return BillOfSaleSimulatedData.LIST.stream()
		                                   .filter(billOfSale -> billOfSale.getDescription()
		                                                                   .equals(description))
		                                   .findFirst();
	}
	
	@Override
	public List<BillOfSalePort> findByBoughtDate(Instant boughtDate) {
		return BillOfSaleSimulatedData.LIST.stream()
		                                   .filter(billOfSale -> billOfSale.getBoughtDate()
		                                                                   .equals(boughtDate))
		                                   .collect(Collectors.toList());
	}
	
	@Override
	public List<BillOfSalePort> findByBoughtDateBetween(Instant min, Instant max) {
		return BillOfSaleSimulatedData.LIST.stream()
		                                   .filter(billOfSale -> billOfSale.getBoughtDate()
		                                                                   .isAfter(min) && billOfSale.getBoughtDate()
		                                                                                              .isBefore(max))
		                                   .collect(Collectors.toList());
	}
	
	@Override
	public BillOfSalePort add(BillOfSalePort object) {
		BillOfSaleSimulatedData.LIST.add(object);
		return object;
		
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort object) {
		Optional<BillOfSalePort> result = BillOfSaleSimulatedData.LIST.stream()
		                                                              .filter(billOfSale -> billOfSale.getId()
		                                                                                              .equals(
			                                                                                              object.getId()))
		                                                              .findFirst();
		
		if (!result.isPresent()) {
			return null;
		}
		
		BillOfSalePort updatedBillOfSale = MergeUtil.merge(result.get(), object);
		BillOfSaleSimulatedData.LIST.remove(BillOfSaleSimulatedData.LIST.indexOf(result.get()));
		BillOfSaleSimulatedData.LIST.add(updatedBillOfSale);
		
		return updatedBillOfSale;
		
	}
	
	@Override
	public BillOfSalePort update(BillOfSalePort originalObject, BillOfSalePort changes) {
		Optional<BillOfSalePort> result = BillOfSaleSimulatedData.LIST.stream()
		                                                              .filter(billOfSale -> billOfSale.getId()
		                                                                                              .equals(
			                                                                                              originalObject.getId()))
		                                                              .findFirst();
		
		if (!result.isPresent()) {
			return null;
		}
		
		BillOfSalePort updatedBillOfSale = MergeUtil.merge(result.get(), changes);
		
		BillOfSaleSimulatedData.LIST.remove(result.get());
		BillOfSaleSimulatedData.LIST.add(updatedBillOfSale);
		
		return updatedBillOfSale;
	}
	
	@Override
	public BillOfSalePort update(String id, BillOfSalePort changes) {
		Optional<BillOfSalePort> result = BillOfSaleSimulatedData.LIST.stream()
		                                                              .filter(billOfSale -> billOfSale.getId()
		                                                                                              .equals(id))
		                                                              .findFirst();
		
		if (!result.isPresent()) {
			return null;
		}
		
		BillOfSalePort updatedBillOfSale = MergeUtil.merge(result.get(), changes);
		
		BillOfSaleSimulatedData.LIST.remove(result.get());
		BillOfSaleSimulatedData.LIST.add(updatedBillOfSale);
		
		return updatedBillOfSale;
	}
	
	@Override
	public boolean remove(String id) {
		return BillOfSaleSimulatedData.LIST.removeIf(billOfSale -> billOfSale.getId()
		                                                                     .equals(id));
	}
	
	@Override
	public Optional<BillOfSalePort> findById(String id) {
		return BillOfSaleSimulatedData.LIST.stream()
		                                   .filter(billOfSale -> billOfSale.getId()
		                                                                   .equals(id))
		                                   .findFirst();
	}
	
	@Override
	public List<BillOfSalePort> findAll() {
		return BillOfSaleSimulatedData.LIST;
	}
	
}
