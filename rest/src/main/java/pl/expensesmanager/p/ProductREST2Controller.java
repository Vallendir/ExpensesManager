package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class ProductREST2Controller implements ProductApi, ProductDocumentation {
	
	private final ProductFacade facade;
	
	@Override
	public Product searchForId(String id) {
		return facade.findById(id);
	}
	
	@Override
	public List<Product> searchAll() {
		return facade.findAll();
	}
	
	@Override
	public List<Product> searchForName(String name) {
		return facade.findByName(name);
	}
	
	@Override
	public List<Product> searchAllForPriceRange(Double priceMin, Double priceMax) {
		return facade.findByPriceRange(priceMin, priceMax);
	}
	
	@Override
	public List<Product> searchAllForPriceGreater(Double priceBigger) {
		return facade.findByPriceExpensiveThan(priceBigger);
	}
	
	@Override
	public List<Product> searchAllForPriceLower(Double priceLower) {
		return facade.findByPriceCheaperThan(priceLower);
	}
	
	@Override
	public void add(Product product) {
		facade.create(product);
	}
	
	@Override
	public void update(String id, Product product) {
		facade.update(id, product);
	}
	
	@Override
	public void delete(String id) {
		facade.remove(id);
	}
	
}