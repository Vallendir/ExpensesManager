package pl.em.billofsale;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.Optional;

class BillOfSaleCommandMongoStorage extends MongoStorage<BillOfSaleDocument, BillOfSale, BillOfSaleMongoMapper, BillOfSaleMongoRepository> implements BillOfSaleCommandStorage {
	
	private final BillOfSaleMongoRepository repository;
	
	BillOfSaleCommandMongoStorage(BillOfSaleMongoRepository repository) {
		super(new BillOfSaleMapperMongo(), repository);
		this.repository = repository;
	}
	
	@Override
	public Optional<BillOfSale> create(BillOfSale bill) {
		return Optional.of(store(bill));
	}
	
	@Override
	public void remove(DomainID id) {
		delete(id.getId());
	}
	
}
