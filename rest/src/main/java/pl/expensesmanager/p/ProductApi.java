package pl.expensesmanager.p;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

interface ProductApi {
	
	@GetMapping(value = "/products2/{id}")
	Product searchForId(@PathVariable("id") String id);
	
	@GetMapping(value = "/products2")
	List<Product> searchAll();
	
	@GetMapping(value = "/products2", params = "name")
	List<Product> searchForName(@RequestParam(value = "name") String name);
	
	@GetMapping(value = "/products2", params = { "priceMin", "priceMax" })
	List<Product> searchAllForPriceRange(
		@RequestParam(value = "priceMin") Double priceMin, @RequestParam(value = "priceMax") Double priceMax
	);
	
	@GetMapping(value = "/products2", params = "priceBigger")
	List<Product> searchAllForPriceGreater(@RequestParam(value = "priceBigger") Double priceBigger);
	
	@GetMapping(value = "/products2", params = "priceLower")
	List<Product> searchAllForPriceLower(@RequestParam(value = "priceLower") Double priceLower);
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/products2")
	void add(@RequestBody Product product);
	
	@PutMapping(value = "/products2/{id}")
	void update(@PathVariable("id") String id, @RequestBody Product product);
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/products2/{id}")
	void delete(@PathVariable("id") String id);
	
}
