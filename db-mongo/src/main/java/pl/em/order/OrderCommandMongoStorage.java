package pl.em.order;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.Optional;

class OrderCommandMongoStorage extends MongoStorage<OrderDocument, Order, OrderMongoMapper, OrderMongoRepository> implements OrderCommandStorage {
	
	private final OrderMongoRepository repository;
	
	OrderCommandMongoStorage(OrderMongoRepository repository) {
		super(new OrderMapperMongo(), repository);
		this.repository = repository;
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
