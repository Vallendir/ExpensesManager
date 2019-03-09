package pl.expensesmanager.billofsale;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

interface BillOfSaleApi {
	
	@GetMapping(value = "/billofsales/{id}")
	BillOfSale searchForId(@PathVariable("id") String id);
	
	@GetMapping(value = "/billofsales", params = "description")
	BillOfSale searchForDescription(@RequestParam(value = "description") String description);
	
	@GetMapping(value = "/billofsales")
	List<BillOfSale> searchAll();
	
	@GetMapping(value = "/billofsales", params = "boughtDate")
	List<BillOfSale> searchForBoughtDate(@RequestParam(value = "boughtDate") Instant boughtDate);
	
	@GetMapping(value = "/billofsales", params = { "boughtDateMin", "boughtDateMax" })
	List<BillOfSale> searchAllForBoughtDateRange(
		@RequestParam(value = "boughtDateMin") Instant boughtDateMin,
		@RequestParam(value = "boughtDateMax") Instant boughtDateMax
	);
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/billofsales")
	BillOfSale add(@RequestBody BillOfSale billOfSale);
	
	@PutMapping(value = "/billofsales")
	BillOfSale update(@RequestBody BillOfSale billOfSale);
	
	@PutMapping(value = "/billofsales/{id}")
	BillOfSale update(@PathVariable("id") String id, @RequestBody BillOfSale billOfSale);
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/billofsales/{id}")
	void delete(@PathVariable("id") String id);
	
}
