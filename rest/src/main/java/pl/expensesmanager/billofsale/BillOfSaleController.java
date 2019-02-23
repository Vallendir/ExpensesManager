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
	
	public BillOfSalePort add(BillOfSale billOfSale) {
		return service.create(billOfSale);
	}
	
	/*public BillOfSale update(BillOfSale billOfSale) {
		return (BillOfSale) service.update(billOfSale);
	}
	
	public BillOfSalePort update(String id, BillOfSale billOfSale) {
		return service.update(billOfSale, id);
	}*/
	
	public void delete(String id) {
		service.deleteById(id);
	}
	
	public BillOfSalePort searchForId(String id) {
		// FIXME
		return service.searchForId(id).get();
	}
	
	public BillOfSalePort searchForDescription(String description) {
		// FIXME
		return service.searchForDescription(description).get();
	}
	
	public List<BillOfSalePort> searchForBoughtDate(Instant boughtDate) {
		return service.searchForBoughtDate(boughtDate);
	}
	
	public List<BillOfSalePort> searchAllForBoughtDateRange(Instant min, Instant max) {
		return service.searchAllForBoughtDateRange(min, max);
	}
	
}
