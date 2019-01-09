package pl.expensesmanager.billofsale;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
class BillOfSaleController implements BillOfSaleApi, BillOfSaleDocumentation {
	
	public BillOfSale add(BillOfSale billOfSale) {
		return null;
	}
	
	public BillOfSale update(BillOfSale billOfSale) {
		return null;
	}
	
	public BillOfSale update(String id, BillOfSale billOfSale) {
		return null;
	}
	
	public void delete(String id) {
	
	}
	
	public BillOfSale searchForId(String id) {
		return null;
	}
	
	public BillOfSale searchForName(String name) {
		return null;
	}
	
	public BillOfSale searchForDescription(String description) {
		return null;
	}
	
	public List<BillOfSale> searchForBoughtDate(Instant boughtDate) {
		return null;
	}
	
	public List<BillOfSale> searchAllForBoughtDateRange(
		Instant min, Instant max
	) {
		return null;
	}
	
}
