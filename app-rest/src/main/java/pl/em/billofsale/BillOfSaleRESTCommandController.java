package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.em.common.DomainID;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
class BillOfSaleRESTCommandController implements BillOfSaleApiCommandDocumentation {
	
	private final BillOfSaleFacade service;
	
	private final BillOfSaleRESTMapper mapper;
	
	@PostMapping
	@Override
	public BillOfSale add(BillOfSale billOfSale) {
		return service.createNew(billOfSale);
	}
	
	@DeleteMapping("/{id}")
	@Override
	public void delete(String id) {
		service.remove(new DomainID(id));
	}
	
}
