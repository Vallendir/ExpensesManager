package pl.em.billofsale;

import io.swagger.annotations.*;

@Api(tags = { "BillOfSale Command" })
interface BillOfSaleApiCommandDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "BillOfSale was created."),
		@ApiResponse(code = 409, message = "BillOfSale cannot be null."),
		@ApiResponse(code = 409, message = "BillOfSale description cannot be null."),
		@ApiResponse(code = 409, message = "BillOfSale bought date cannot be null.")
	})
	@ApiOperation(value = "Create bill of sale.", nickname = "add", notes = "Method allow to create a new bill of sale.", httpMethod = "POST", code = 201, tags = {
		"BillOfSale Command",
	})
	BillOfSale add(
		@ApiParam(value = "BillOfSale object which will be created.", required = true) BillOfSale billOfSale
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "BillOfSale was removed."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Remove bill of sale.", nickname = "deleteById", notes = "Method allow to remove a bill of sale.", httpMethod = "DELETE", code = 204, tags = {
		"BillOfSale Command",
	})
	void delete(@ApiParam(value = "BillOfSale object which will be deleted.", required = true) String id);
	
}
