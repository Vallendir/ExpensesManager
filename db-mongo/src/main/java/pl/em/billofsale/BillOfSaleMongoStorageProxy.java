package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public final class BillOfSaleMongoStorageProxy {
	
	private final BillOfSaleCommandMongoStorage command;
	
	private final BillOfSaleQueryMongoStorage query;
	
	public Optional<BillOfSale> create(BillOfSale bill) {
		return command.create(bill);
	}
	
	public void remove(DomainID id) {
		command.remove(id);
	}
	
	public Optional<BillOfSale> searchById(DomainID id) {
		return query.searchById(id);
	}
	
	public List<BillOfSale> searchAll() {
		return query.searchAll();
	}

}
