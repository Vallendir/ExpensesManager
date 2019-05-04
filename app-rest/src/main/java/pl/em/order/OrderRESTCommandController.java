package pl.em.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.em.common.DomainID;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
class OrderRESTCommandController implements OrderApiCommandDocumentation {
	
	private final OrderFacade service;
	
	private final OrderRESTMapper mapper;
	
	@PostMapping
	@Override
	public ResponseNewOrder add(RequestNewOrder order) {
		var request = mapper.requestToDomain(order);
		var response = service.createNew(request);
		
		return mapper.domainToResponse(response);
	}
	
	@DeleteMapping("/{id}")
	@Override
	public void delete(String id) {
		service.remove(new DomainID(id));
	}
	
}
