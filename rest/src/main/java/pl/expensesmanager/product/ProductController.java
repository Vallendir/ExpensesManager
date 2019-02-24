package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class ProductController implements ProductApi, ProductDocumentation {
	
	private final ProductService service;
	
	public Product add(Product product) {
		Product p = new Product();
		p.setName("jakas nazwa");
		p.setPrice(5.75);
		
		service.create(p);
		
		
		return service.create(product);
	}
	
	/*public Product update(Product product) {
		return service.update(product);
	}
	
	public Product update(String id, Product product) {
		return service.update(product, id);
	}*/
	
	public void delete(String id) {
		service.removeById(id);
	}
	
	public Product searchForId(String id) {
		// FIXME
		Product p = service.searchById(id)
		                       .get();
		
		System.err.println(p);
		
		return p;
	}
	
	public Product searchForName(String name) {
		// FIXME
		return service.searchByName(name)
		              .get();
	}
	
	public List<Product> searchAllForPriceRange(Double min, Double max) {
		return service.searchAllByPriceRange(min, max);
	}
	
	public List<Product> searchAllForPriceGreater(Double price) {
		return service.searchAllExpensiveThan(price);
	}
	
	public List<Product> searchAllForPriceLower(Double price) {
		return service.searchAllCheaperThan(price);
	}
	
}