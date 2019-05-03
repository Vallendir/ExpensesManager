package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
class BillOfSaleRESTController implements BillOfSaleApiDocumentation {
	
	private final BillOfSaleFacade service;
	
}
