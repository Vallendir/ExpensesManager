package pl.em.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductRESTController implements ProductApiDocumentation {
	
	private final ProductFacade service;
	
	@GetMapping
	Product s() {
		Product p = new Product();
		p.setName("name ese");
		p.setPrice(5.75);
		
		return service.createNew(p);
	}
	
}
