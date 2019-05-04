package pl.em.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductRESTQueryController implements ProductApiQueryDocumentation {
	
	private final ProductFacade service;
	
	@GetMapping("/id")
	@Override
	public Product searchForId(String id) {
		return null;
	}
	
	@Override
	public List<Product> searchAll() {
		return null;
	}
	
}
