package pl.em.order;

import io.swagger.annotations.*;

import java.util.List;

@Api(tags = { "Order Command" })
interface OrderApiCommandDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Order was created."),
		@ApiResponse(code = 409, message = "Order cannot be null."),
		@ApiResponse(code = 409, message = "Ordered product cannot be null."),
		@ApiResponse(code = 409, message = "Order quanity cannot be null or is infinite.")
	})
	@ApiOperation(value = "Create order.", nickname = "add", notes = "Method allow to create a new order.", httpMethod = "POST", code = 201, tags = {
		"Order Command",
	})
	ResponseNewOrder add(
		@ApiParam(value = "Order object which will be created.", required = true) RequestNewOrder order
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "Order was removed."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Remove order.", nickname = "deleteById", notes = "Method allow to remove an order by id.", httpMethod = "DELETE", code = 204, tags = {
		"Order Command",
	})
	void delete(@ApiParam(value = "Order object which will be deleted.", required = true) String id);
	
}
