package pl.expensesmanager.product;

import org.springframework.web.bind.annotation.RestController;
import pl.expensesmanager.base.BaseRESTController;

import java.util.List;
import java.util.Optional;

@RestController
class ProductOrderRESTController extends BaseRESTController<ProductOrder>
	implements ProductOrderApi, ProductOrderDocumentation {
	
	private final ProductOrderService service;
	
	ProductOrderRESTController(ProductOrderService service) {
		super(service);
		this.service = service;
	}
	
	public List<ProductOrder> searchAllForQuanityRange(Integer quanityMin, Integer quanityMax) {
		return service.searchAllByQuanityRange(quanityMin, quanityMax);
	}
	
	public List<ProductOrder> searchAllForQuanityGreater(Integer quanityBigger) {
		return service.searchAllByBiggerQuanityThan(quanityBigger);
	}
	
	public List<ProductOrder> searchAllForQuanityLower(Integer quanityLower) {
		return service.searchAllByLessQuanityThan(quanityLower);
	}
	
	public List<ProductOrder> searchAllForProductName(String productName) {
		return service.searchAllByProductName(productName);
	}
	
	public ProductOrder searchForProductNameAndProductPrice(String productName, Double productPrice) {
		Optional<ProductOrder> order = service.searchAllByProductNameAndProductPrice(productName, productPrice);
		
		return order.get();
	}
	
	public List<ProductOrder> searchAll() {
		return super.searchAll();
	}
	
	public void delete(String id) {
		super.delete(id);
	}
	
}