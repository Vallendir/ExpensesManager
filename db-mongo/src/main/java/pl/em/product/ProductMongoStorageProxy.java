package pl.em.product;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainID;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public final class ProductMongoStorageProxy {

	private final ProductCommandMongoStorage command;
	
	private final ProductQueryMongoStorage query;
	
	public Optional<Product> create(Product product) {
		return command.create(product);
	}
	
	public void remove(DomainID id) {
		command.remove(id);
	}
	
	public Optional<Product> searchById(DomainID id) {
		return query.searchById(id);
	}
	
	public List<Product> searchAll() {
		return query.searchAll();
	}
	
}
