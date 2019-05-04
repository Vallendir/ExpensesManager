package pl.em.order;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public final class OrderMongoStorageProxy {
	
	private final OrderCommandMongoStorage command;
	
	private final OrderQueryMongoStorage query;
	
	public Optional<Order> create(Order order) {
		return command.create(order);
	}
	
	public void remove(DomainID id) {
		command.remove(id);
	}
	
	public Optional<Order> searchById(DomainID id) {
		return query.searchById(id);
	}
	
	public List<Order> searchAll() {
		return query.searchAll();
	}
	
}
