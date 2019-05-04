package pl.em.product;

import io.swagger.annotations.*;

import java.util.List;

@Api(tags = { "Product Query" })
interface ProductApiQueryDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Product was found."),
		@ApiResponse(code = 404, message = "Product not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Find product by id.", nickname = "searchForId", notes = "Method allow to find a product by id.", httpMethod = "GET", tags = {
		"Product Query",
	})
	Product searchForId(@ApiParam(value = "ID of Product to find.", required = true) String id);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Products were found."),
		@ApiResponse(code = 404, message = "Products are not found.")
	})
	@ApiOperation(value = "Retrieve all products.", nickname = "searchAll", notes = "Method allow to find all products.", httpMethod = "GET", tags = {
		"Product Query",
	})
	List<Product> searchAll();
	
}
