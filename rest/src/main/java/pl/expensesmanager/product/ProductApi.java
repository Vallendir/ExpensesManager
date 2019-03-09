package pl.expensesmanager.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

interface ProductApi {
	
	@GetMapping(value = "/products/{id}")
	Product searchForId(@PathVariable("id") String id);
	
	@GetMapping(value = "/products")
	List<Product> searchAll();
	
	@GetMapping(value = "/products", params = "name")
	List<Product> searchForName(@RequestParam(value = "name") String name);
	
	@GetMapping(value = "/products", params = { "priceMin", "priceMax" })
	List<Product> searchAllForPriceRange(
		@RequestParam(value = "priceMin") Double priceMin, @RequestParam(value = "priceMax") Double priceMax
	);
	
	@GetMapping(value = "/products", params = "priceBigger")
	List<Product> searchAllForPriceGreater(@RequestParam(value = "priceBigger") Double priceBigger);
	
	@GetMapping(value = "/products", params = "priceLower")
	List<Product> searchAllForPriceLower(@RequestParam(value = "priceLower") Double priceLower);
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(value = "/products")
	Product add(@RequestBody Product product);
	
	@PutMapping(value = "/products")
	Product update(@RequestBody Product product);
	
	@PutMapping(value = "/products/{id}")
	Product update(@PathVariable("id") String id, @RequestBody Product product);
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/products/{id}")
	void delete(@PathVariable("id") String id);
	
}
