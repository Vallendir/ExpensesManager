package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;

import java.util.List;
import java.util.Optional;

@Component
@Profile("mongo")
public class ProductOrderStorageMongo extends BaseMongoStorage<ProductOrderDocument, ProductOrder>
	implements ProductOrderStorePort {
	
	private final ProductOrderRepositoryMongo repository;
	
	private final ProductRepositoryMongo productRepository;
	
	public ProductOrderStorageMongo(ProductOrderRepositoryMongo repository, ProductRepositoryMongo productRepository) {
		super(repository);
		this.repository = repository;
		this.productRepository = productRepository;
	}
	
	@Override
	public List<ProductOrder> findByProductName(String name) {
		return readFromStream(repository.findByProductName(name), this::map);
	}
	
	@Override
	public Optional<ProductOrder> findByProductNameAndProductPrice(String name, Double price) {
		return repository.findByProductNameAndProductPrice(name, price)
		                 .map(this::map);
	}
	
	@Override
	public List<ProductOrder> findByQuanityBetween(Integer min, Integer max) {
		return readFromStream(repository.findByQuanityBetween(min, max), this::map);
	}
	
	@Override
	public List<ProductOrder> findByQuanityGreaterThan(Integer quanity) {
		return readFromStream(repository.findByQuanityGreaterThan(quanity), this::map);
	}
	
	@Override
	public List<ProductOrder> findByQuanityLessThan(Integer quanity) {
		return readFromStream(repository.findByQuanityLessThan(quanity), this::map);
	}
	
	@Override
	public Optional<ProductOrder> findById(String id) {
		return findObjectById(id, this::map);
	}
	
	@Override
	public ProductOrder save(ProductOrder object) {
		return saveObject(() -> {
			Optional<ProductDocument> product = productRepository.findByNameAndPrice(
				object.getProduct()
				      .getName(), object.getProduct()
				                        .getPrice());
			if (product.isPresent()) {
				object.setProduct(map(product.get()));
			} else {
				ProductDocument saved = productRepository.save(map(object.getProduct()));
				object.setProduct(map(saved));
			}
			
			return map(object);
		}, this::map);
	}
	
	@Override
	public List<ProductOrder> findAll() {
		return findAllObjects(this::map);
	}
	
}
