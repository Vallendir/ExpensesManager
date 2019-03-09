package pl.expensesmanager.product;

import org.springframework.web.bind.annotation.RestController;
import pl.expensesmanager.base.BaseRESTController;

import java.util.List;

@RestController
class ProductRESTController extends BaseRESTController<Product> implements ProductApi, ProductDocumentation {
	
	private final ProductService service;
	
	ProductRESTController(ProductService service) {
		super(service);
		this.service = service;
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
	
	public List<Product> searchAll() {
		return super.searchAll();
	}
	
	public void delete(String id) {
		super.delete(id);
	}
	
}