package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
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
		return service.searchForId(id);
	}
	
	public ProductPort searchForName(String name) {
		return service.searchForName(name);
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
	
	public List<ProductPort> searchAllForQuanityRange(Integer min, Integer max) {
		return service.searchAllForQuanityRange(min, max);
	}
	
	public List<ProductPort> searchAllForQuanityGreater(Integer quanity) {
		return service.searchAllForQuanityGreater(quanity);
	}
	
	public List<ProductPort> searchAllForQuanityLower(Integer quanity) {
		return service.searchAllForQuanityLower(quanity);
	}
	
}