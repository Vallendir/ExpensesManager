package pl.em.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductRESTController implements ProductApiDocumentation {
	
	private final ProductFacade service;
	
}
