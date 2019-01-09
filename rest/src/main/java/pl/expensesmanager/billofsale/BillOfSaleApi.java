package pl.expensesmanager.billofsale;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

interface BillOfSaleApi {
	
	@PostMapping(value = "/billofsales")
	BillOfSale add(@RequestBody BillOfSale billOfSale);
	
	@PutMapping(value = "/billofsales")
	BillOfSale update(@RequestBody BillOfSale billOfSale);
	
	@PutMapping(value = "/billofsales/{id}")
	BillOfSale update(@PathVariable("id") String id, @RequestBody BillOfSale billOfSale);
	
	@DeleteMapping(value = "/billofsales/{id}")
	void delete(@PathVariable("id") String id);
	
	@GetMapping(value = "/billofsales/{id}")
	BillOfSale searchForId(@PathVariable("id") String id);
	
	@GetMapping(value = "/billofsales", params = "name")
	BillOfSale searchForName(@RequestParam(value = "name") String name);
	
	@GetMapping(value = "/billofsales", params = "description")
	BillOfSale searchForDescription(@RequestParam(value = "description") String description);
	
	@GetMapping(value = "/billofsales", params = "bought-date")
	List<BillOfSale> searchForBoughtDate(@RequestParam(value = "bought-date") Instant boughtDate);
	
	@GetMapping(value = "/billofsales", params = { "bought-date-min", "bought-date-max" })
	List<BillOfSale> searchAllForBoughtDateRange(
		@RequestParam(value = "bought-date-min") Instant min, @RequestParam(value = "bought-date-max") Instant max
	);
	
}
