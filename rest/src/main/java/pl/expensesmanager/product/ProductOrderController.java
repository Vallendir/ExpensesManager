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
		service.removeById(id);
	}
	
	public ProductOrderPort searchForId(String id) {
		// FIXME
		return service.searchById(id)
		              .get();
	}
	
	public List<ProductOrderPort> searchAllForQuanityRange(Integer min, Integer max) {
		return service.searchAllByQuanityRange(min, max);
	}
	
	public List<ProductOrderPort> searchAllForQuanityGreater(Integer quanity) {
		return service.searchAllByBiggerQuanityThan(quanity);
	}
	
	public List<ProductOrderPort> searchAllForQuanityLower(Integer quanity) {
		return service.searchAllByLessQuanityThan(quanity);
	}
	
	@Override
	public List<ProductOrderPort> searchAllForProductName(String productName) {
		return service.searchAllByProductName(productName);
	}
	
	@Override
	public List<ProductOrderPort> searchAllForProductNameAndProductPrice(String productName, Double price) {
		return service.searchAllByProductNameAndPrice(productName, price);
	}
	
}