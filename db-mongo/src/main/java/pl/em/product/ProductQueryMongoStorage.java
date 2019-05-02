package pl.em.product;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
class ProductQueryMongoStorage implements ProductQueryStorage {
	
	private final ProductMongoRepository repository;
	
	@Override
	public Optional<Product> searchById(DomainID id) {
		return Optional.empty();
	}
	
	@Override
	public List<Product> searchAll() {
		return null;
	}
	
}
