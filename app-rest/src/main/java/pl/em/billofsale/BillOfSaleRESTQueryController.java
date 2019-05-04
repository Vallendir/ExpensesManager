package pl.em.billofsale;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
class BillOfSaleRESTQueryController implements BillOfSaleApiQueryDocumentation {
	
	private final BillOfSaleFacade service;
	
	@Override
	public BillOfSale searchForId(String id) {
		return null;
	}
	
	@Override
	public List<BillOfSale> searchAll() {
		return null;
	}
	
}
