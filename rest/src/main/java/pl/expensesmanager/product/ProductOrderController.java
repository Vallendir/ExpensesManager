package pl.expensesmanager.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.productOrderNotFoundException;

@RequiredArgsConstructor
@RestController
class ProductOrderController implements ProductOrderApi, ProductOrderDocumentation {
	
	private final ProductOrderService service;
	
	public ProductOrder add(ProductOrder product) {
		return service.create(product);
	}
	
	public ProductOrder update(ProductOrder product) {
		return service.update(product);
	}
	
	public ProductOrder update(String id, ProductOrder product) {
		return service.update(product, id);
	}
	
	public void delete(String id) {
		service.removeById(id);
	}
	
	public ProductOrder searchForId(String id) {
		Optional<ProductOrder> order = service.searchById(id);
		if (!order.isPresent()) {
			throw productOrderNotFoundException();
		}
		
		return order.get();
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
	
	@Override
	public List<ProductOrder> searchAllForProductName(String productName) {
		return service.searchAllByProductName(productName);
	}
	
	@Override
	public ProductOrder searchAllForProductNameAndProductPrice(String productName, Double productPrice) {
		Optional<ProductOrder> order = service.searchAllByProductNameAndProductPrice(productName, productPrice);
		if (!order.isPresent()) {
			throw productOrderNotFoundException();
		}
		
		return order.get();
	}
	
}