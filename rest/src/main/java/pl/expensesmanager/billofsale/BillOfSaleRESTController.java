package pl.expensesmanager.billofsale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import pl.expensesmanager.base.BaseRESTController;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
class BillOfSaleRESTController extends BaseRESTController<BillOfSale> implements BillOfSaleApi, BillOfSaleDocumentation {
	
	private final BillOfSaleService service;
	
	BillOfSaleRESTController(BillOfSaleService service) {
		super(service);
		this.service = service;
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
	
	public List<BillOfSale> searchAll() {
		return super.searchAll();
	}
	
	public void delete(String id) {
		super.delete(id);
	}
	
}
