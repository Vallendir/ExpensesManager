package pl.expensesmanager.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@Api(tags = { "Product" })
public interface ProductDocumentation {
	
	@ApiOperation(value = "Find product by id.", nickname = "searchForId", notes = "Method allow to find a product by id.", httpMethod = "GET", tags = {
		"Product",
	})
	Product searchForId(@ApiParam(value = "ID of Product to find.", required = true) String id);
	
	@ApiOperation(value = "Retrieve all products.", nickname = "searchAll", notes = "Method allow to find all products.", httpMethod = "GET", tags = {
		"Product",
	})
	List<Product> searchAll();
	
	@ApiOperation(value = "Find product by name.", nickname = "searchForName", notes = "Method allow to find a product by name.", httpMethod = "GET", tags = {
		"Product",
	})
	List<Product> searchForName(@ApiParam(value = "Name of product to find.", required = true) String name);
	
	@ApiOperation(value = "Find products by price range.", nickname = "searchAllForPriceRange", notes = "Method allow to find a product by price range.", httpMethod = "GET", tags = {
		"Product",
	})
	List<Product> searchAllForPriceRange(
		@ApiParam(value = "Minimal price value to find.", required = true) Double priceMin,
		@ApiParam(value = "Maximum price value to find.", required = true) Double priceMax
	);
	
	@ApiOperation(value = "Find products of price greater than value.", nickname = "searchAllForPriceGreater", notes = "Method allow to find a product by price greater than value.", httpMethod = "GET", tags = {
		"Product",
	})
	List<Product> searchAllForPriceGreater(
		@ApiParam(value = "Price value to find products more expensive.", required = true) Double priceBigger
	);
	
	@ApiOperation(value = "Find products of price lower than value.", nickname = "searchAllForPriceLower", notes = "Method allow to find a product by price lower than value.", httpMethod = "GET", tags = {
		"Product",
	})
	List<Product> searchAllForPriceLower(
		@ApiParam(value = "Price value to find products cheaper.", required = true) Double priceLower
	);
	
	@ApiOperation(value = "Create product.", nickname = "add", notes = "Method allow to create a new product.", httpMethod = "POST", tags = {
		"Product",
	})
	Product add(
		@ApiParam(value = "Product object which will be created.", required = true) Product product
	);
	
	@ApiOperation(value = "Update product.", nickname = "updateObject", notes = "Method allow to update a product.", httpMethod = "PUT", tags = {
		"Product",
	})
	Product update(
		@ApiParam(value = "Product object which will be updated.", required = true) Product product
	);
	
	@ApiOperation(value = "Update Product by id.", nickname = "updateById", notes = "Method allow to update a product by id.", httpMethod = "PUT", tags = {
		"Product",
	})
	Product update(
		@ApiParam(value = "ID of Product to update.", required = true) String id,
		@ApiParam(value = "Changes to updated product.", required = true) Product product
	);
	
	@ApiOperation(value = "Remove product.", nickname = "deleteById", notes = "Method allow to remove a product by id.", httpMethod = "DELETE", tags = {
		"Product",
	})
	void delete(@ApiParam(value = "Product object which will be deleted.", required = true) String id);
	
}
