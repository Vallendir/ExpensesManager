package pl.em.order;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;
import pl.em.product.ProductMongoStorageProxy;

import java.util.List;
import java.util.Optional;

class OrderQueryMongoStorage extends MongoStorage<OrderDocument, Order, OrderMongoMapper, OrderMongoRepository> implements OrderQueryStorage {
	
	private final OrderMongoRepository repository;
	
	private final ProductMongoStorageProxy productProxy;
	
	OrderQueryMongoStorage(OrderMongoRepository repository, ProductMongoStorageProxy productProxy) {
		super(new OrderMapperMongo(), repository);
		this.repository = repository;
		this.productProxy = productProxy;
	}
	
	@Override
	public Optional<Order> searchById(DomainID id) {
		return Optional.empty();
	}
	
	@Override
	public List<Order> searchAll() {
		return null;
	}
	
}
