package pl.expensesmanager.billofsale;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderStorageMongo;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Profile("mongo")
@Component
public class BillOfSaleStorageMongo extends BaseMongoStorage<BillOfSaleDocument, BillOfSale>
	implements BillOfSaleStorePort {
	
	private final BillOfSaleRepositoryMongo repository;
	
	private final ProductOrderStorageMongo orderStorage;
	
	public BillOfSaleStorageMongo(BillOfSaleRepositoryMongo repository, ProductOrderStorageMongo orderStorage) {
		super(repository);
		this.repository = repository;
		this.orderStorage = orderStorage;
	}
	
	@Override
	public Optional<BillOfSale> findByDescription(String description) {
		return repository.findByDescription(description)
		                 .map(this::map);
	}
	
	@Override
	public List<BillOfSale> findByBoughtDate(Instant boughtDate) {
		return readFromStream(repository.findByBoughtDate(boughtDate), this::map);
	}
	
	@Override
	public List<BillOfSale> findByBoughtDateBetween(Instant min, Instant max) {
		return readFromStream(repository.findByBoughtDateBetween(min, max), this::map);
	}
	
	@Override
	public Optional<BillOfSale> findById(String id) {
		return findObjectById(id, this::map);
	}
	
	@Override
	public BillOfSale save(BillOfSale object) {
		return saveObject(() -> {
			object.getProductList()
			      .forEach(order -> {
				      if (Objects.isNull(order.getId())) {
					      ProductOrder ifNoId = orderStorage.save(order);
					
					      order.setId(ifNoId.getId());
				      } else {
					      Optional<ProductOrder> ifExists = orderStorage.findById(order.getId());
					      if (!ifExists.isPresent()) {
						      ProductOrder existed = orderStorage.save(order);
						
						      order.setId(existed.getId());
					      }
				      }
			      });
			
			return map(object);
		}, this::map);
	}
	
	@Override
	public List<BillOfSale> findAll() {
		return findAllObjects(this::map);
	}
	
}
