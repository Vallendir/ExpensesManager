package pl.expensesmanager.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

interface ProductApi {
	
	@PostMapping(value = "/products")
	Product add(@RequestBody Product product);
	
	@PutMapping(value = "/products")
	Product update(@RequestBody Product product);
	
	@PutMapping(value = "/products/{id}")
	Product update(@PathVariable("id") String id, @RequestBody Product product);
	
	@DeleteMapping(value = "/products/{id}")
	void delete(@PathVariable("id") String id);
	
	@GetMapping(value = "/products/{id}")
	Product searchForId(@PathVariable("id") String id);
	
	@GetMapping(value = "/products", params = "name")
	Product searchForName(@RequestParam(value = "name") String name);
	
	@GetMapping(value = "/products", params = { "price-min", "price-max" })
	List<Product> searchAllForPriceRange(
		@RequestParam(value = "price-min") Double min, @RequestParam(value = "price-max") Double max
	);
	
	@GetMapping(value = "/products", params = "price-bigger")
	List<Product> searchAllForPriceGreater(@RequestParam(value = "price-bigger") Double price);
	
	@GetMapping(value = "/products", params = "price-lower")
	List<Product> searchAllForPriceLower(@RequestParam(value = "price-lower") Double price);
	
	@GetMapping(value = "/products", params = { "quanity-min", "quanity-max" })
	List<Product> searchAllForQuanityRange(
		@RequestParam(value = "quanity-min") Integer min, @RequestParam(value = "quanity-max") Integer max
	);
	
	@GetMapping(value = "/products", params = "quanity-bigger")
	List<Product> searchAllForQuanityGreater(@RequestParam(value = "quanity-bigger") Integer quanity);
	
	@GetMapping(value = "/products", params = "quanity-lower")
	List<Product> searchAllForQuanityLower(@RequestParam(value = "quanity-lower") Integer quanity);
	
}
