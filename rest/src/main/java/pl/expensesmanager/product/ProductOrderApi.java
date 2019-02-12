package pl.expensesmanager.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

interface ProductOrderApi {
	
	@PostMapping(value = "/orders")
	ProductOrderPort add(@RequestBody ProductOrder product);
	
	@PutMapping(value = "/orders")
	ProductOrderPort update(@RequestBody ProductOrder product);
	
	@PutMapping(value = "/orders/{id}")
	ProductOrderPort update(@PathVariable("id") String id, @RequestBody ProductOrder product);
	
	@DeleteMapping(value = "/orders/{id}")
	void delete(@PathVariable("id") String id);
	
	@GetMapping(value = "/orders/{id}")
	ProductOrderPort searchForId(@PathVariable("id") String id);
	
	@GetMapping(value = "/orders", params = { "quanity-min", "quanity-max" })
	List<ProductOrderPort> searchAllForQuanityRange(
		@RequestParam(value = "quanity-min") Integer min, @RequestParam(value = "quanity-max") Integer max
	);
	
	@GetMapping(value = "/orders", params = "quanity-bigger")
	List<ProductOrderPort> searchAllForQuanityGreater(@RequestParam(value = "quanity-bigger") Integer quanity);
	
	@GetMapping(value = "/orders", params = "quanity-lower")
	List<ProductOrderPort> searchAllForQuanityLower(@RequestParam(value = "quanity-lower") Integer quanity);
	
	@GetMapping(value = "/orders/{productName}")
	List<ProductOrderPort> searchAllForProductName(@PathVariable("productName") String productName);
	
	@GetMapping(value = "/orders/{productName}/{productPrice}")
	List<ProductOrderPort> searchAllForProductNameAndProductPrice(@PathVariable("productName") String productName, @PathVariable("productPrice") Double price);
	
}
