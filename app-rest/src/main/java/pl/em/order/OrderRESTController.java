package pl.em.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
class OrderRESTController implements OrderApiDocumentation {
	
	private final OrderFacade service;
	
}
