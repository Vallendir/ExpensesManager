package pl.expensesmanager.billofsale;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.billOfSaleNotFoundException;

@Slf4j
@RequiredArgsConstructor
@RestController
class BillOfSaleController implements BillOfSaleApi, BillOfSaleDocumentation {
	
	private final BillOfSaleService service;
	
	public BillOfSale add(BillOfSale billOfSale) {
		return service.create(billOfSale);
	}
	
	public BillOfSale update(BillOfSale billOfSale) {
		return service.create(billOfSale);
	}
	
	public BillOfSale update(String id, BillOfSale billOfSale) {
		return service.update(billOfSale, id);
	}
	
	public void delete(String id) {
		service.removeObjectById(id);
	}
	
	public BillOfSale searchForId(String id) {
		BillOfSale billOfSale = service.searchById(id);
		
		return billOfSale;
	}
	
	public BillOfSale searchForDescription(String description) {
		Optional<BillOfSale> billOfSale = service.searchByDescription(description);
		
		return billOfSale.get();
	}
	
	public List<BillOfSale> searchForBoughtDate(Instant boughtDate) {
		return service.searchAllByBoughtDate(boughtDate);
	}
	
	public List<BillOfSale> searchAllForBoughtDateRange(Instant min, Instant max) {
		return service.searchAllByBoughtDateRange(min, max);
	}
	
}
