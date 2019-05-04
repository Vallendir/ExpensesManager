package pl.em.order;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;
import pl.em.product.ProductMongoStorageProxy;

import java.util.Optional;

class OrderCommandMongoStorage extends MongoStorage<OrderDocument, Order, OrderMongoMapper, OrderMongoRepository> implements OrderCommandStorage {
	
	private final OrderMongoRepository repository;
	
	private final ProductMongoStorageProxy productProxy;
	
	OrderCommandMongoStorage(OrderMongoRepository repository, ProductMongoStorageProxy productProxy) {
		super(new OrderMapperMongo(), repository);
		this.repository = repository;
		this.productProxy = productProxy;
	}
	
	@Override
	public Optional<Order> create(Order order) {
		return Optional.of(store(order));
	}
	
	@Override
	public void remove(DomainID id) {
		delete(id.getId());
	}
	
}
