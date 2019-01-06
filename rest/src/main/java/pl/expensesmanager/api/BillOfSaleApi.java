package pl.expensesmanager.api;

import org.springframework.web.bind.annotation.*;
import pl.expensesmanager.domain.BillOfSalePort;

import java.time.Instant;
import java.util.List;

public interface BillOfSaleApi {
	
	@PostMapping(value = "/billofsales")
	public BillOfSalePort add(@RequestBody BillOfSalePort billOfSale);
	
	@PutMapping(value = "/billofsales")
	public BillOfSalePort update(@RequestBody BillOfSalePort billOfSale);
	
	@PutMapping(value = "/billofsales/{id}")
	public BillOfSalePort update(@PathVariable("id") String id, @RequestBody BillOfSalePort billOfSale);
	
	@DeleteMapping(value = "/billofsales/{id}")
	public void delete(@PathVariable("id") String id);
	
	@GetMapping(value = "/billofsales/{id}")
	public BillOfSalePort searchForId(@PathVariable("id") String id);
	
	@GetMapping(value = "/billofsales", params = "name")
	public BillOfSalePort searchForName(@RequestParam(value = "name") String name);
	
	@GetMapping(value = "/billofsales", params = "description")
	public BillOfSalePort searchForDescription(@RequestParam(value = "description") String description);
	
	@GetMapping(value = "/billofsales", params = "bought-date")
	public List<BillOfSalePort> searchForBoughtDate(@RequestParam(value = "bought-date") Instant boughtDate);
	
	@GetMapping(value = "/billofsales", params = { "bought-date-min", "bought-date-max" })
	public List<BillOfSalePort> searchAllForBoughtDateRange(
		@RequestParam(value = "bought-date-min") Instant min, @RequestParam(value = "bought-date-max") Instant max
	);
	
}
