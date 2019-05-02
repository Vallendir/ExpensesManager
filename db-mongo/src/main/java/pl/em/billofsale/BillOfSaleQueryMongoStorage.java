package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
class BillOfSaleQueryMongoStorage implements BillOfSaleQueryStorage {
	
	private final BillOfSaleMongoRepository repository;
	
	@Override
	public Optional<BillOfSale> searchById(DomainID id) {
		return Optional.empty();
	}
	
	@Override
	public List<BillOfSale> searchAll() {
		return null;
	}
	
}
