package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;

import java.util.Optional;

@RequiredArgsConstructor
@Profile("mongo")
class ProductStorageCommandMongo implements ProductStoreCommandPort {
	
	private final ProductRepositoryMongo repository;
	
	@Override
	public Optional<Product> save(Product object) {
		ProductDocument document = ProductDocument.from(object);
		return Optional.of(repository.save(document))
		               .map(ProductDocument::from);
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
}
