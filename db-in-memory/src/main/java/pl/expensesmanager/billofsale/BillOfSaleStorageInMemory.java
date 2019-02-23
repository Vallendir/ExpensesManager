package pl.expensesmanager.billofsale;

import org.springframework.context.annotation.Profile;
import pl.expensesmanager.IdValidationPort;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * MOCK of bill of sale storage
 */
@Profile("in-memory")
public class BillOfSaleStorageInMemory extends IdValidationPort implements BillOfSaleStorePort {
	
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
	public BillOfSalePort save(BillOfSalePort object) {
		BillOfSaleSimulatedData.LIST.add(object);
		return object;
		
	}
	
	@Override
	public void deleteById(String id) {
		BillOfSaleSimulatedData.LIST.removeIf(billOfSale -> billOfSale.getId()
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
