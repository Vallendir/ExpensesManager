package pl.em.product;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.Optional;

@RequiredArgsConstructor
class ProductCommandMongoStorage implements ProductCommandStorage {
	
	private final ProductMongoRepository repository;
	
	@Override
	public Optional<Product> create(Product object) {
		return Optional.empty();
	}
	
	@Override
	public void remove(DomainID id) {
	
	}
	
}
