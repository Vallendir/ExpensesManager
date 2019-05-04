package pl.em.product;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.Optional;

class ProductCommandMongoStorage extends MongoStorage<ProductDocument, Product, ProductMongoMapper, ProductMongoRepository> implements ProductCommandStorage {
	
	private final ProductMongoRepository repository;
	
	ProductCommandMongoStorage(ProductMongoRepository repository) {
		super(new ProductMapperMongo(), repository);
		this.repository = repository;
	}
	
	@Override
	public Optional<Product> create(Product product) {
		return Optional.of(store(product));
	}
	
	@Override
	public void remove(DomainID id) {
		delete(id.getId());
	}
	
}
