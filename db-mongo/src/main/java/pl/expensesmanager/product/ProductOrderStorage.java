package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@Profile("dev")
public class ProductOrderStorage extends BaseMongoStorage implements ProductOrderStorePort {
	
	private final ProductOrderRepositoryMongo repository;
	
	private final ProductRepositoryMongo productRepository;
	
	@Override
	public List<ProductOrder> findByProductName(String name) {
		return repository.findByProductName(name)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public Optional<ProductOrder> findByProductNameAndProductPrice(String name, Double price) {
		return repository.findByProductNameAndProductPrice(name, price)
		                 .map(this::map);
	}
	
	@Override
	public List<ProductOrder> findByQuanityBetween(Integer min, Integer max) {
		return repository.findByQuanityBetween(min, max)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrder> findByQuanityGreaterThan(Integer quanity) {
		return repository.findByQuanityGreaterThan(quanity)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<ProductOrder> findByQuanityLessThan(Integer quanity) {
		return repository.findByQuanityLessThan(quanity)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public Optional<ProductOrder> findById(String id) {
		return repository.findById(id)
		                 .map(this::map);
	}
	
	@Override
	public ProductOrder save(ProductOrder object) {
		Optional<ProductDocument> product = productRepository.findByNameAndPrice(object.getProduct()
		                                                                               .getName(), object.getProduct()
		                                                                                                 .getPrice());
		if (product.isPresent()) {
			object.setProduct(map(product.get()));
		} else {
			ProductDocument saved = productRepository.save(map(object.getProduct()));
			object.setProduct(map(saved));
		}
		
		return map(repository.save(map(object)));
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<ProductOrder> findAll() {
		return repository.findAll()
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
}
