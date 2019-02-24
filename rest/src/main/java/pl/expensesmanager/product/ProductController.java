package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.productNotFoundException;

@RequiredArgsConstructor
@RestController
class ProductController implements ProductApi, ProductDocumentation {
	
	private final ProductServicePort service;
	
	public Product add(Product product) {
		return service.create(product);
	}
	
	public Product update(Product product) {
		return service.update(product);
	}
	
	public Product update(String id, Product product) {
		return service.update(product, id);
	}
	
	public void delete(String id) {
		service.removeById(id);
	}
	
	public Product searchForId(String id) {
		Optional<Product> product = service.searchById(id);
		if (!product.isPresent()) {
			throw productNotFoundException();
		}
		
		return product.get();
	}
	
	public List<Product> searchForName(String name) {
		return service.searchByName(name);
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