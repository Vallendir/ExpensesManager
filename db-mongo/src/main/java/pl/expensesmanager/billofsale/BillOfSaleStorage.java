package pl.expensesmanager.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.expensesmanager.base.BaseMongoStorage;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderStorage;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@Profile("dev")
public class BillOfSaleStorage extends BaseMongoStorage implements BillOfSaleStorePort {
	
	private final BillOfSaleRepositoryMongo repository;
	
	private final ProductOrderStorage orderStorage;
	
	@Override
	public Optional<BillOfSale> findByDescription(String description) {
		return repository.findByDescription(description)
		                 .map(this::map);
	}
	
	@Override
	public List<BillOfSale> findByBoughtDate(Instant boughtDate) {
		return repository.findByBoughtDate(boughtDate)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public List<BillOfSale> findByBoughtDateBetween(Instant min, Instant max) {
		return repository.findByBoughtDateBetween(min, max)
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
	@Override
	public Optional<BillOfSale> findById(String id) {
		return repository.findById(id)
		                 .map(this::map);
	}
	
	@Override
	public BillOfSale save(BillOfSale object) {
		object.getProductList()
		      .forEach(order -> {
			      if (order.getId() == null) {
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
		
		return map(repository.save(map(object)));
	}
	
	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<BillOfSale> findAll() {
		return repository.findAll()
		                 .stream()
		                 .map(this::map)
		                 .collect(Collectors.toList());
	}
	
}
