package pl.em.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.em.product.Product;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
class OrderRESTQueryController implements OrderApiQueryDocumentation {
	
	private final OrderFacade service;
	
	@Override
	public Product searchForId(String id) {
		return null;
	}
	
	@Override
	public List<Product> searchAll() {
		return null;
	}
	
}
