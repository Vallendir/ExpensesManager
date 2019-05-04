package pl.em.billofsale;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;
import pl.em.order.OrderMongoStorageProxy;

import java.util.Optional;

class BillOfSaleCommandMongoStorage extends MongoStorage<BillOfSaleDocument, BillOfSale, BillOfSaleMongoMapper, BillOfSaleMongoRepository> implements BillOfSaleCommandStorage {
	
	private final BillOfSaleMongoRepository repository;
	
	private final OrderMongoStorageProxy orderProxy;
	
	BillOfSaleCommandMongoStorage(BillOfSaleMongoRepository repository, OrderMongoStorageProxy orderProxy) {
		super(new BillOfSaleMapperMongo(), repository);
		this.repository = repository;
		this.orderProxy = orderProxy;
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
