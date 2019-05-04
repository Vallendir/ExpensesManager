package pl.em.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.em.common.DomainID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductRESTCommandController implements ProductApiCommandDocumentation {
	
	private final ProductFacade service;
	
	private final ProductRESTMapper mapper;
	
	@PostMapping
	@Override
	public ResponseNewProduct add(RequestNewProduct product) {
		var request = mapper.requestToDomain(product);
		var response = service.createNew(request);
		
		return mapper.domainToResponse(response);
	}
	
	@DeleteMapping("/{id}")
	@Override
	public void delete(@PathVariable("id") String id) {
		service.remove(new DomainID(id));
	}
	
}
