package pl.expensesmanager.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@Api(tags = { "Order" })
public interface ProductOrderDocumentation {
	
	@ApiOperation(value = "Find Order by id.", nickname = "searchForId", notes = "Method allow to find a order by id.", httpMethod = "GET", tags = {
		"Order",
	})
	ProductOrder searchForId(@ApiParam(value = "ID of Order to find.", required = true) String id);
	
	@ApiOperation(value = "Find order by name and price.", nickname = "searchForProductNameAndProductPrice", notes = "Method allow to find an order by name and price.", httpMethod = "GET", tags = {
		"Order",
	})
	ProductOrder searchForProductNameAndProductPrice(
		@ApiParam(value = "Product name to find orders of this product.", required = true) String productName,
		@ApiParam(value = "Product price to find orders of this product.", required = true) Double productPrice
	);
	
	@ApiOperation(value = "Retrieve all product orders.", nickname = "searchAll", notes = "Method allow to find all product orders.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAll();
	
	@ApiOperation(value = "Find product orders by quanity range.", nickname = "searchAllForQuanityRange", notes = "Method allow to find an order by quanity range.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForQuanityRange(
		@ApiParam(value = "Minimal quanity value to find.", required = true) Integer quanityMin,
		@ApiParam(value = "Maximum quanity value to find.", required = true) Integer quanityMax
	);
	
	@ApiOperation(value = "Find product orders by quanity greater than value.", nickname = "searchAllForQuanityGreater", notes = "Method allow to find an order by quanity greater than value.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForQuanityGreater(
		@ApiParam(value = "Quanity value to find products of more value.", required = true) Integer quanityBigger
	);
	
	@ApiOperation(value = "Find all product orders of quanity lower than value.", nickname = "searchAllForQuanityLower", notes = "Method allow to find an order by quanity lower than.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForQuanityLower(
		@ApiParam(value = "Quanity value to find products of less value.", required = true) Integer quanityLower
	);
	
	@ApiOperation(value = "Find order by name.", nickname = "searchAllForProductName", notes = "Method allow to find an order by name.", httpMethod = "GET", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForProductName(
		@ApiParam(value = "Product name to find orders of this product.", required = true) String productName
	);
	
	@ApiOperation(value = "Create order.", nickname = "add", notes = "Method allow to create a new order.", httpMethod = "POST", tags = {
		"Order",
	})
	ProductOrder add(
		@ApiParam(value = "Order object which will be created.", required = true) ProductOrder order
	);
	
	@ApiOperation(value = "Update order.", nickname = "updateObject", notes = "Method allow to update an order.", httpMethod = "PUT", tags = {
		"Order",
	})
	ProductOrder update(
		@ApiParam(value = "Order object which will be updated.", required = true) ProductOrder order
	);
	
	@ApiOperation(value = "Update order by id.", nickname = "updateById", notes = "Method allow to update a order by id.", httpMethod = "PUT", tags = {
		"Order",
	})
	ProductOrder update(
		@ApiParam(value = "ID of Order to update.", required = true) String id,
		@ApiParam(value = "Changes to updated order.", required = true) ProductOrder order
	);
	
	@ApiOperation(value = "Remove order.", nickname = "deleteById", notes = "Method allow to remove an order by id.", httpMethod = "DELETE", tags = {
		"Order",
	})
	void delete(@ApiParam(value = "Order object which will be deleted.", required = true) String id);
	
}
