package pl.expensesmanager.product;

import io.swagger.annotations.*;

import java.util.List;

@Api(tags = { "Order" })
public interface ProductOrderDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Order was found."),
		@ApiResponse(code = 404, message = "Order not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Find Order by id.", nickname = "searchForId", notes = "Method allow to find a order by id.", httpMethod = "GET", tags = {
		"Order",
	})
	ProductOrder searchForId(@ApiParam(value = "ID of Order to find.", required = true) String id);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Order was found."),
		@ApiResponse(code = 404, message = "Order not found."),
		@ApiResponse(code = 409, message = "Product name cannot be null."),
		@ApiResponse(code = 409, message = "Product price cannot be null or is infinite.")
	})
	@ApiOperation(value = "Find order by name and price.", nickname = "searchForProductNameAndProductPrice", notes = "Method allow to find an order by name and price.", httpMethod = "GET", tags = {
		"Order",
	})
	ProductOrder searchForProductNameAndProductPrice(
		@ApiParam(value = "Product name to find orders of this product.", required = true) String productName,
		@ApiParam(value = "Product price to find orders of this product.", required = true) Double productPrice
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Orders were found."),
		@ApiResponse(code = 404, message = "Orders are not found.")
	})
	@ApiOperation(value = "Retrieve all product orders.", nickname = "searchAll", notes = "Method allow to find all product orders.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAll();
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Order was found."),
		@ApiResponse(code = 404, message = "Order not found."),
		@ApiResponse(code = 409, message = "Order quanity cannot be null."),
		@ApiResponse(code = 409, message = "Minimum quanity cannot be bigger than maximum quanity.")
	})
	@ApiOperation(value = "Find product orders by quanity range.", nickname = "searchAllForQuanityRange", notes = "Method allow to find an order by quanity range.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForQuanityRange(
		@ApiParam(value = "Minimum quanity value to find.", required = true) Integer quanityMin,
		@ApiParam(value = "Maximum quanity value to find.", required = true) Integer quanityMax
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Order was found."),
		@ApiResponse(code = 404, message = "Order not found."),
		@ApiResponse(code = 409, message = "Order quanity cannot be null.")
	})
	@ApiOperation(value = "Find product orders by quanity greater than value.", nickname = "searchAllForQuanityGreater", notes = "Method allow to find an order by quanity greater than value.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForQuanityGreater(
		@ApiParam(value = "Quanity value to find products of more value.", required = true) Integer quanityBigger
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Order was found."),
		@ApiResponse(code = 404, message = "Order not found."),
		@ApiResponse(code = 409, message = "Order quanity cannot be null.")
	})
	@ApiOperation(value = "Find all product orders of quanity lower than value.", nickname = "searchAllForQuanityLower", notes = "Method allow to find an order by quanity lower than.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForQuanityLower(
		@ApiParam(value = "Quanity value to find products of less value.", required = true) Integer quanityLower
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Order was found."),
		@ApiResponse(code = 404, message = "Order not found."),
		@ApiResponse(code = 409, message = "Product name cannot be null.")
	})
	@ApiOperation(value = "Find order by name.", nickname = "searchAllForProductName", notes = "Method allow to find an order by name.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForProductName(
		@ApiParam(value = "Product name to find orders of this product.", required = true) String productName
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Order was created."),
		@ApiResponse(code = 409, message = "Order cannot be null."),
		@ApiResponse(code = 409, message = "Ordered product cannot be null."),
		@ApiResponse(code = 409, message = "Order quanity cannot be null or is infinite.")
	})
	@ApiOperation(value = "Create order.", nickname = "add", notes = "Method allow to create a new order.", httpMethod = "POST", code = 201, tags = {
		"Order",
	})
	ProductOrder add(
		@ApiParam(value = "Order object which will be created.", required = true) ProductOrder order
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Order was updated."),
		@ApiResponse(code = 404, message = "Order not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Update order.", nickname = "updateObject", notes = "Method allow to update an order.", httpMethod = "PUT", tags = {
		"Order",
	})
	ProductOrder update(
		@ApiParam(value = "Order object which will be updated.", required = true) ProductOrder order
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Order was updated."),
		@ApiResponse(code = 404, message = "Order not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Update order by id.", nickname = "updateById", notes = "Method allow to update a order by id.", httpMethod = "PUT", tags = {
		"Order",
	})
	ProductOrder update(
		@ApiParam(value = "ID of Order to update.", required = true) String id,
		@ApiParam(value = "Changes to updated order.", required = true) ProductOrder order
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "Order was removed."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Remove order.", nickname = "deleteById", notes = "Method allow to remove an order by id.", httpMethod = "DELETE", code = 204, tags = {
		"Order",
	})
	void delete(@ApiParam(value = "Order object which will be deleted.", required = true) String id);
	
}
