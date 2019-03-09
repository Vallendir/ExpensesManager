package pl.expensesmanager.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

interface ProductOrderApi {
	
	@GetMapping(value = "/orders/{id}")
	ProductOrder searchForId(@PathVariable("id") String id);
	
	@GetMapping(value = "/orders", params = { "productName", "productPrice" })
	ProductOrder searchForProductNameAndProductPrice(
		@RequestParam(value = "productName") String productName,
		@RequestParam(value = "productPrice") Double productPrice
	);
	
	@GetMapping(value = "/orders")
	List<ProductOrder> searchAll();
	
	@GetMapping(value = "/orders", params = { "quanityMin", "quanityMax" })
	List<ProductOrder> searchAllForQuanityRange(
		@RequestParam(value = "quanityMin") Integer quanityMin, @RequestParam(value = "quanityMax") Integer quanityMax
	);
	
	@GetMapping(value = "/orders", params = "quanityBigger")
	List<ProductOrder> searchAllForQuanityGreater(@RequestParam(value = "quanityBigger") Integer quanityBigger);
	
	@GetMapping(value = "/orders", params = "quanityLower")
	List<ProductOrder> searchAllForQuanityLower(@RequestParam(value = "quanityLower") Integer quanityLower);
	
	@GetMapping(value = "/orders", params = { "productName" })
	List<ProductOrder> searchAllForProductName(@RequestParam("productName") String productName);
	
	@PostMapping(value = "/orders")
	ProductOrder add(@RequestBody ProductOrder product);
	
	@PutMapping(value = "/orders")
	ProductOrder update(@RequestBody ProductOrder product);
	
	@PutMapping(value = "/orders/{id}")
	ProductOrder update(@PathVariable("id") String id, @RequestBody ProductOrder product);
	
	@DeleteMapping(value = "/orders/{id}")
	void delete(@PathVariable("id") String id);
	
}
