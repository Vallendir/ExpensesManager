package pl.expensesmanager.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
class ProductController implements ProductApi, ProductDocumentation {
	
	public Product add(Product product) {
		return null;
	}
	
	public Product update(Product product) {
		return null;
	}
	
	public Product update(String id, Product product) {
		return null;
	}
	
	public void delete(String id) {
	
	}
	
	public Product searchForId(String id) {
		return null;
	}
	
	public Product searchForName(String name) {
		return null;
	}
	
	public List<Product> searchAllForPriceRange(Double min, Double max) {
		return null;
	}
	
	public List<Product> searchAllForPriceGreater(Double price) {
		return null;
	}
	
	public List<Product> searchAllForPriceLower(Double price) {
		return null;
	}
	
	public List<Product> searchAllForQuanityRange(Integer min, Integer max) {
		return null;
	}
	
	public List<Product> searchAllForQuanityGreater(Integer quanity) {
		return null;
	}
	
	public List<Product> searchAllForQuanityLower(Integer quanity) {
		return null;
	}
	
}