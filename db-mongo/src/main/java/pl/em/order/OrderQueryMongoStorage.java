package pl.em.order;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
class OrderQueryMongoStorage implements OrderQueryStorage {
	
	private final OrderMongoRepository repository;
	
	@Override
	public Optional<Order> searchById(DomainID id) {
		return Optional.empty();
	}
	
	@Override
	public List<Order> searchAll() {
		return null;
	}
	
}
