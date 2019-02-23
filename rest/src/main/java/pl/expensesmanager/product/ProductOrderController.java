package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class ProductOrderController implements ProductOrderApi, ProductOrderDocumentation {
	
	private final ProductOrderService service;
	
	public ProductOrderPort add(ProductOrder product) {
		return service.create(product);
	}
	
	/*public ProductOrderPort update(ProductOrder product) {
		return service.update(product);
	}
	
	public ProductOrderPort update(String id, ProductOrder product) {
		return service.update(product, id);
	}*/
	
	public void delete(String id) {
		service.deleteById(id);
	}
	
	public ProductOrderPort searchForId(String id) {
		// FIXME
		return service.searchForId(id)
		              .get();
	}
	
	public List<ProductOrderPort> searchAllForQuanityRange(Integer min, Integer max) {
		return service.searchAllForQuanityRange(min, max);
	}
	
	public List<ProductOrderPort> searchAllForQuanityGreater(Integer quanity) {
		return service.searchAllForQuanityGreater(quanity);
	}
	
	public List<ProductOrderPort> searchAllForQuanityLower(Integer quanity) {
		return service.searchAllForQuanityLower(quanity);
	}
	
	@Override
	public List<ProductOrderPort> searchAllForProductName(String productName) {
		return service.searchAllForProductName(productName);
	}
	
	@Override
	public List<ProductOrderPort> searchAllForProductNameAndProductPrice(String productName, Double price) {
		return service.searchAllForProductNameAndProductPrice(productName, price);
	}
	
}