package pl.expensesmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import pl.expensesmanager.api.ProductApi;
import pl.expensesmanager.documentation.ProductDocumentation;
import pl.expensesmanager.domain.ProductPort;

import java.util.List;

@Slf4j
@RestController
public class ProductController implements ProductApi, ProductDocumentation {
	
	public ProductPort add(ProductPort product) {
		return null;
	}
	
	public ProductPort update(ProductPort product) {
		return null;
	}
	
	public ProductPort update(String id, ProductPort product) {
		return null;
	}
	
	public void delete(String id) {
	
	}
	
	public ProductPort searchForId(String id) {
		return null;
	}
	
	public ProductPort searchForName(String name) {
		return null;
	}
	
	public List<ProductPort> searchAllForPriceRange(Double min, Double max) {
		return null;
	}
	
	public List<ProductPort> searchAllForPriceGreater(Double price) {
		return null;
	}
	
	public List<ProductPort> searchAllForPriceLower(Double price) {
		return null;
	}
	
	public List<ProductPort> searchAllForQuanityRange(Integer min, Integer max) {
		return null;
	}
	
	public List<ProductPort> searchAllForQuanityGreater(Integer quanity) {
		return null;
	}
	
	public List<ProductPort> searchAllForQuanityLower(Integer quanity) {
		return null;
	}
	
}