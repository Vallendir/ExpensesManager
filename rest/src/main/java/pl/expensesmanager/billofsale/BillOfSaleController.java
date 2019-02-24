package pl.expensesmanager.billofsale;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
class BillOfSaleController implements BillOfSaleApi, BillOfSaleDocumentation {
	
	private final BillOfSaleService service;
	
	public BillOfSale add(BillOfSale billOfSale) {
		return service.create(billOfSale);
	}
	
	/*public BillOfSale update(BillOfSale billOfSale) {
		return (BillOfSale) service.update(billOfSale);
	}
	
	public BillOfSale update(String id, BillOfSale billOfSale) {
		return service.update(billOfSale, id);
	}*/
	
	public void delete(String id) {
		service.removeById(id);
	}
	
	public BillOfSale searchForId(String id) {
		// FIXME
		return service.searchById(id).get();
	}
	
	public BillOfSale searchForDescription(String description) {
		// FIXME
		return service.searchByDescription(description).get();
	}
	
	public List<BillOfSale> searchForBoughtDate(Instant boughtDate) {
		return service.searchAllByBoughtDate(boughtDate);
	}
	
	public List<BillOfSale> searchAllForBoughtDateRange(Instant min, Instant max) {
		return service.searchAllByBoughtDateRange(min, max);
	}
	
}
