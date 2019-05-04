package pl.em.order;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.List;
import java.util.Optional;

class OrderQueryMongoStorage extends MongoStorage<OrderDocument, Order, OrderMongoMapper, OrderMongoRepository> implements OrderQueryStorage {
	
	private final OrderMongoRepository repository;
	
	OrderQueryMongoStorage(OrderMongoRepository repository) {
		super(new OrderMapperMongo(), repository);
		this.repository = repository;
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
