package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class ProductController implements ProductApi, ProductDocumentation {
	
	private final ProductService service;
	
	public ProductPort add(Product product) {
		ProductPort p = new Product();
		p.setName("jakas nazwa");
		p.setPrice(5.75);
		
		service.create(p);
		
		
		return service.create(product);
	}
	
	/*public ProductPort update(Product product) {
		return service.update(product);
	}
	
	public ProductPort update(String id, Product product) {
		return service.update(product, id);
	}*/
	
	public void delete(String id) {
		service.removeById(id);
	}
	
	public ProductPort searchForId(String id) {
		// FIXME
		return service.searchById(id)
		              .get();
	}
	
	public ProductPort searchForName(String name) {
		// FIXME
		return service.searchByName(name)
		              .get();
	}
	
	public List<ProductPort> searchAllForPriceRange(Double min, Double max) {
		return service.searchAllByPriceRange(min, max);
	}
	
	public List<ProductPort> searchAllForPriceGreater(Double price) {
		return service.searchAllExpensiveThan(price);
	}
	
	public List<ProductPort> searchAllForPriceLower(Double price) {
		return service.searchAllCheaperThan(price);
	}
	
}