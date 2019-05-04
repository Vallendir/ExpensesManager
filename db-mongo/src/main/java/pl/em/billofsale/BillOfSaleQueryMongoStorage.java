package pl.em.billofsale;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;
import pl.em.order.OrderMongoStorageProxy;

import java.util.List;
import java.util.Optional;

class BillOfSaleQueryMongoStorage extends MongoStorage<BillOfSaleDocument, BillOfSale, BillOfSaleMongoMapper, BillOfSaleMongoRepository> implements BillOfSaleQueryStorage {
	
	private final BillOfSaleMongoRepository repository;
	
	private final OrderMongoStorageProxy orderProxy;
	
	BillOfSaleQueryMongoStorage(BillOfSaleMongoRepository repository, OrderMongoStorageProxy orderProxy) {
		super(new BillOfSaleMapperMongo(), repository);
		this.repository = repository;
		this.orderProxy = orderProxy;
	}
	
	@Override
	public Optional<BillOfSale> searchById(DomainID id) {
		return Optional.empty();
	}
	
	@Override
	public List<BillOfSale> searchAll() {
		return null;
	}
	
}
