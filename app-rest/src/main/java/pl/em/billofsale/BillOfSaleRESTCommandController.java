package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
class BillOfSaleRESTCommandController implements BillOfSaleApiCommandDocumentation {
	
	private final BillOfSaleFacade service;
	
	@Override
	public BillOfSale add(BillOfSale billOfSale) {
		return null;
	}
	
	@Override
	public void delete(String id) {
	
	}
	
}
