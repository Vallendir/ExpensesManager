package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Profile("mongo")
class ProductStorageQueryMongo implements ProductStoreQueryPort {
	
	private final ProductRepositoryMongo repository;
	
	@Override
	public List<Product> findByName(String name) {
		return repository.findByName(name)
		                 .stream()
		                 .map(ProductDocument::from)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByPriceBetween(Double min, Double max) {
		return repository.findByPriceBetween(min, max)
		                 .stream()
		                 .map(ProductDocument::from)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByPriceGreaterThan(Double price) {
		return repository.findByPriceGreaterThan(price)
		                 .stream()
		                 .map(ProductDocument::from)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findByPriceLessThan(Double price) {
		return repository.findByPriceLessThan(price)
		                 .stream()
		                 .map(ProductDocument::from)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public Optional<Product> findById(String id) {
		return repository.findById(id)
		                 .map(ProductDocument::from);
	}
	
	@Override
	public List<Product> findAll() {
		return repository.findAll()
		                 .stream()
		                 .map(ProductDocument::from)
		                 .collect(Collectors.toList());
	}
	
}
