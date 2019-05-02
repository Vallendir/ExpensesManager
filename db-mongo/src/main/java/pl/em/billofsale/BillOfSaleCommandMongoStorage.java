package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.Optional;

@RequiredArgsConstructor
class BillOfSaleCommandMongoStorage implements BillOfSaleCommandStorage {
	
	private final BillOfSaleMongoRepository repository;
	
	@Override
	public Optional<BillOfSale> create(BillOfSale object) {
		return Optional.empty();
	}
	
	@Override
	public void remove(DomainID id) {
	
	}
	
}
