package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.productNotFoundException;

@RequiredArgsConstructor
@RestController
class ProductController implements ProductApi, ProductDocumentation {
	
	private final ProductService service;
	
	public Product add(Product product) {
		return service.create(product);
	}
	
	public Product update(Product product) {
		return service.create(product);
	}
	
	public Product update(String id, Product product) {
		return service.update(product, id);
	}
	
	public void delete(String id) {
		service.removeObjectById(id);
	}
	
	public Product searchForId(String id) {
		Product product = service.searchById(id);
		
		return product;
	}
	
	public List<Product> searchForName(String name) {
		return service.searchByName(name);
	}
	
	@GetMapping(value = "/products")
	public List<Product> searchAll() {
		return service.searchAllObjects();
	}
	
	public List<Product> searchAllForPriceRange(Double priceMin, Double priceMax) {
		return service.searchAllByPriceRange(priceMin, priceMax);
	}
	
	public List<Product> searchAllForPriceGreater(Double priceBigger) {
		return service.searchAllExpensiveThan(priceBigger);
	}
	
	public List<Product> searchAllForPriceLower(Double priceLower) {
		return service.searchAllCheaperThan(priceLower);
	}
	
}