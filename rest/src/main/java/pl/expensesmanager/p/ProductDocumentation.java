package pl.expensesmanager.p;

import io.swagger.annotations.*;

import java.util.List;

@Api(tags = { "Product2" })
public interface ProductDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Product was found."),
		@ApiResponse(code = 404, message = "Product not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Find product by id.", nickname = "searchForId", notes = "Method allow to find a product by id.", httpMethod = "GET", tags = {
		"Product2",
	})
	Product searchForId(@ApiParam(value = "ID of Product to find.", required = true) String id);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Products were found."),
		@ApiResponse(code = 404, message = "Products are not found.")
	})
	@ApiOperation(value = "Retrieve all products.", nickname = "searchAll", notes = "Method allow to find all products.", httpMethod = "GET", tags = {
		"Product2",
	})
	List<Product> searchAll();
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Product was found."),
		@ApiResponse(code = 404, message = "Product not found."),
		@ApiResponse(code = 409, message = "Product name cannot be null.")
	})
	@ApiOperation(value = "Find product by name.", nickname = "searchForName", notes = "Method allow to find a product by name.", httpMethod = "GET", tags = {
		"Product2",
	})
	List<Product> searchForName(@ApiParam(value = "Name of product to find.", required = true) String name);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Product was found."),
		@ApiResponse(code = 404, message = "Product not found."),
		@ApiResponse(code = 409, message = "Product price cannot be null or is infinite."),
		@ApiResponse(code = 409, message = "Minimum price cannot be bigger than maximum price.")
	})
	@ApiOperation(value = "Find products by price range.", nickname = "searchAllForPriceRange", notes = "Method allow to find a product by price range.", httpMethod = "GET", tags = {
		"Product2",
	})
	List<Product> searchAllForPriceRange(
		@ApiParam(value = "Minimum price value to find.", required = true) Double priceMin,
		@ApiParam(value = "Maximum price value to find.", required = true) Double priceMax
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Product was found."),
		@ApiResponse(code = 404, message = "Product not found."),
		@ApiResponse(code = 409, message = "Product price cannot be null or is infinite.")
	})
	@ApiOperation(value = "Find products of price greater than value.", nickname = "searchAllForPriceGreater", notes = "Method allow to find a product by price greater than value.", httpMethod = "GET", tags = {
		"Product2",
	})
	List<Product> searchAllForPriceGreater(
		@ApiParam(value = "Price value to find products more expensive.", required = true) Double priceBigger
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Product was found."),
		@ApiResponse(code = 404, message = "Product not found."),
		@ApiResponse(code = 409, message = "Product price cannot be null or is infinite.")
	})
	@ApiOperation(value = "Find products of price lower than value.", nickname = "searchAllForPriceLower", notes = "Method allow to find a product by price lower than value.", httpMethod = "GET", tags = {
		"Product2",
	})
	List<Product> searchAllForPriceLower(
		@ApiParam(value = "Price value to find products cheaper.", required = true) Double priceLower
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Product was created."),
		@ApiResponse(code = 409, message = "Product cannot be null."),
		@ApiResponse(code = 409, message = "Product name cannot be null."),
		@ApiResponse(code = 409, message = "Product price cannot be null or is infinite.")
	})
	@ApiOperation(value = "Create product.", nickname = "add", notes = "Method allow to create a new product.", httpMethod = "POST", code = 201, tags = {
		"Product2",
	})
	void add(
		@ApiParam(value = "Product object which will be created.", required = true) Product product
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Product was updated."),
		@ApiResponse(code = 404, message = "Product not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Update Product by id.", nickname = "updateById", notes = "Method allow to update a product by id.", httpMethod = "PUT", tags = {
		"Product2",
	})
	void update(
		@ApiParam(value = "ID of Product to update.", required = true) String id,
		@ApiParam(value = "Changes to updated product.", required = true) Product product
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "Product was removed."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Remove product.", nickname = "deleteById", notes = "Method allow to remove a product by id.", httpMethod = "DELETE", code = 204, tags = {
		"Product2",
	})
	void delete(@ApiParam(value = "Product object which will be deleted.", required = true) String id);
	
}
