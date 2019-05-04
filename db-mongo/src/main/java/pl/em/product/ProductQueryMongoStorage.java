package pl.em.product;

import pl.em.common.DomainID;
import pl.em.common.MongoStorage;

import java.util.List;
import java.util.Optional;

class ProductQueryMongoStorage extends MongoStorage<ProductDocument, Product, ProductMongoMapper, ProductMongoRepository> implements ProductQueryStorage {
	
	private final ProductMongoRepository repository;
	
	ProductQueryMongoStorage(ProductMongoRepository repository) {
		super(new ProductMongoMapperImpl(), repository);
		this.repository = repository;
	}
	
	@Override
	public Optional<Product> searchById(DomainID id) {
		return Optional.empty();
	}
	
	@Override
	public List<Product> searchAll() {
		return null;
	}
	
}
