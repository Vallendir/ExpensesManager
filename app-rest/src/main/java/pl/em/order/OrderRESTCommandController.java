package pl.em.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
class OrderRESTCommandController implements OrderApiCommandDocumentation {
	
	private final OrderFacade service;
	
	@Override
	public Order searchForId(String id) {
		return null;
	}
	
	@Override
	public List<Order> searchAll() {
		return null;
	}
	
}
