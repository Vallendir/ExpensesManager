package pl.em.order;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.Optional;

@RequiredArgsConstructor
class OrderCommandMongoStorage implements OrderCommandStorage {
	
	private final OrderMongoRepository repository;
	
	@Override
	public Optional<Order> create(Order object) {
		return Optional.empty();
	}
	
	@Override
	public void remove(DomainID id) {
	
	}
	
}
