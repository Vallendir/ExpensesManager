package pl.em.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductRESTCommandController implements ProductApiCommandDocumentation {
	
	private final ProductFacade service;
	
	@GetMapping
	@Override
	public Product add(Product product) {
		Product p = new Product();
		p.setName("name ese");
		p.setPrice(5.75);
		
		return service.createNew(p);
	}
	
	@Override
	public void delete(String id) {
	
	}
	
}
