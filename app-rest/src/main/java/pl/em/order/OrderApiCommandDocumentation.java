package pl.em.order;

import io.swagger.annotations.*;

import java.util.List;

@Api(tags = { "Order Command" })
interface OrderApiCommandDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Order was found."), @ApiResponse(code = 404, message = "Order not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Find Order by id.", nickname = "searchForId", notes = "Method allow to find a order by id.", httpMethod = "GET", tags = {
		"Order Command",
	})
	Order searchForId(@ApiParam(value = "ID of Order to find.", required = true) String id);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Orders were found."),
		@ApiResponse(code = 404, message = "Orders are not found.")
	})
	@ApiOperation(value = "Retrieve all product orders.", nickname = "searchAll", notes = "Method allow to find all product orders.", httpMethod = "GET", tags = {
		"Order Command",
	})
	List<Order> searchAll();
	
}
