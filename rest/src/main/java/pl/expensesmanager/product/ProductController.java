package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class ProductController implements ProductApi, ProductDocumentation {
	
	private final ProductService service;
	
	public ProductPort add(Product product) {
		return service.create(product);
	}
	
	public ProductPort update(Product product) {
		return service.update(product);
	}
	
	public ProductPort update(String id, Product product) {
		return service.update(product, id);
	}
	
	public void delete(String id) {
		service.delete(id);
	}
	
	public ProductPort searchForId(String id) {
		// FIXME
		return service.searchForId(id)
		              .get();
	}
	
	public ProductPort searchForName(String name) {
		// FIXME
		return service.searchForName(name)
		              .get();
	}
	
	public List<ProductPort> searchAllForPriceRange(Double min, Double max) {
		return service.searchAllForPriceRange(min, max);
	}
	
	public List<ProductPort> searchAllForPriceGreater(Double price) {
		return service.searchAllForPriceGreater(price);
	}
	
	public List<ProductPort> searchAllForPriceLower(Double price) {
		return service.searchAllForPriceLower(price);
	}
	
}