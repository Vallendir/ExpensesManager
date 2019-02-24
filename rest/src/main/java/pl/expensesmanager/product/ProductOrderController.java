package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class ProductOrderController implements ProductOrderApi, ProductOrderDocumentation {
	
	private final ProductOrderService service;
	
	public ProductOrder add(ProductOrder product) {
		return service.create(product);
	}
	
	/*public ProductOrder update(ProductOrder product) {
		return service.update(product);
	}
	
	public ProductOrder update(String id, ProductOrder product) {
		return service.update(product, id);
	}*/
	
	public void delete(String id) {
		service.removeById(id);
	}
	
	public ProductOrder searchForId(String id) {
		// FIXME
		return service.searchById(id)
		              .get();
	}
	
	public List<ProductOrder> searchAllForQuanityRange(Integer min, Integer max) {
		return service.searchAllByQuanityRange(min, max);
	}
	
	public List<ProductOrder> searchAllForQuanityGreater(Integer quanity) {
		return service.searchAllByBiggerQuanityThan(quanity);
	}
	
	public List<ProductOrder> searchAllForQuanityLower(Integer quanity) {
		return service.searchAllByLessQuanityThan(quanity);
	}
	
	@Override
	public List<ProductOrder> searchAllForProductName(String productName) {
		return service.searchAllByProductName(productName);
	}
	
	@Override
	public List<ProductOrder> searchAllForProductNameAndProductPrice(String productName, Double price) {
		return service.searchAllByProductNameAndPrice(productName, price);
	}
	
}