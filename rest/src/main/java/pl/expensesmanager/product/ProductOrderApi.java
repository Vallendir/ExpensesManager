package pl.expensesmanager.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

interface ProductOrderApi {
	
	@PostMapping(value = "/orders")
	ProductOrder add(@RequestBody ProductOrder product);
	
	/*@PutMapping(value = "/orders")
	ProductOrder update(@RequestBody ProductOrder product);
	
	@PutMapping(value = "/orders/{id}")
	ProductOrder update(@PathVariable("id") String id, @RequestBody ProductOrder product);*/
	
	@DeleteMapping(value = "/orders/{id}")
	void delete(@PathVariable("id") String id);
	
	@GetMapping(value = "/orders/{id}")
	ProductOrder searchForId(@PathVariable("id") String id);
	
	@GetMapping(value = "/orders", params = { "quanity-min", "quanity-max" })
	List<ProductOrder> searchAllForQuanityRange(
		@RequestParam(value = "quanity-min") Integer min, @RequestParam(value = "quanity-max") Integer max
	);
	
	@GetMapping(value = "/orders", params = "quanity-bigger")
	List<ProductOrder> searchAllForQuanityGreater(@RequestParam(value = "quanity-bigger") Integer quanity);
	
	@GetMapping(value = "/orders", params = "quanity-lower")
	List<ProductOrder> searchAllForQuanityLower(@RequestParam(value = "quanity-lower") Integer quanity);
	
	@GetMapping(value = "/orders/{productName}")
	List<ProductOrder> searchAllForProductName(@PathVariable("productName") String productName);
	
	@GetMapping(value = "/orders/{productName}/{productPrice}")
	List<ProductOrder> searchAllForProductNameAndProductPrice(@PathVariable("productName") String productName, @PathVariable("productPrice") Double price);
	
}
