package pl.expensesmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import pl.expensesmanager.api.BillOfSaleApi;
import pl.expensesmanager.documentation.BillOfSaleDocumentation;
import pl.expensesmanager.domain.BillOfSalePort;

import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
public class BillOfSaleController implements BillOfSaleApi, BillOfSaleDocumentation {
	
	public BillOfSalePort add(BillOfSalePort billOfSale) {
		return null;
	}
	
	public BillOfSalePort update(BillOfSalePort billOfSale) {
		return null;
	}
	
	public BillOfSalePort update(String id, BillOfSalePort billOfSale) {
		return null;
	}
	
	public void delete(String id) {
	
	}
	
	public BillOfSalePort searchForId(String id) {
		return null;
	}
	
	public BillOfSalePort searchForName(String name) {
		return null;
	}
	
	public BillOfSalePort searchForDescription(String description) {
		return null;
	}
	
	public List<BillOfSalePort> searchForBoughtDate(Instant boughtDate) {
		return null;
	}
	
	public List<BillOfSalePort> searchAllForBoughtDateRange(
		Instant min, Instant max
	) {
		return null;
	}
	
}
