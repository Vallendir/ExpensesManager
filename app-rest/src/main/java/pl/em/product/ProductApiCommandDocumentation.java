package pl.em.product;

import io.swagger.annotations.*;

@Api(tags = { "Product Command" })
interface ProductApiCommandDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Product was created."),
		@ApiResponse(code = 409, message = "Product cannot be null."),
		@ApiResponse(code = 409, message = "Product name cannot be null."),
		@ApiResponse(code = 409, message = "Product price cannot be null or is infinite.")
	})
	@ApiOperation(value = "Create product.", nickname = "add", notes = "Method allow to create a new product.", httpMethod = "POST", code = 201, tags = {
		"Product Command",
	})
	Product add(
		@ApiParam(value = "Product object which will be created.", required = true) Product product
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "Product was removed."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Remove product.", nickname = "deleteById", notes = "Method allow to remove a product by id.", httpMethod = "DELETE", code = 204, tags = {
		"Product Command",
	})
	void delete(@ApiParam(value = "Product object which will be deleted.", required = true) String id);
	
}
