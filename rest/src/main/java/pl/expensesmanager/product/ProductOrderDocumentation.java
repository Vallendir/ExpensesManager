package pl.expensesmanager.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@Api(tags = { "Order" })
public interface ProductOrderDocumentation {
	
	@ApiOperation(value = "POST-endpoint to create Order.", nickname = "add", notes = "Method allow to create a new order.", tags = {
		"Order",
	})
	ProductOrderPort add(
		@ApiParam(value = "Order object which will be created.", required = true) ProductOrder order
	);
	
	@ApiOperation(value = "PUT-endpoint to update Order.", nickname = "update", notes = "Method allow to update a order.", tags = {
		"Order",
	})
	ProductOrderPort update(
		@ApiParam(value = "Order object which will be updated.", required = true) ProductOrder order
	);
	
	@ApiOperation(value = "PUT-endpoint to update Order of id.", nickname = "update", notes = "Method allow to update a order by id.", tags = {
		"Order",
	})
	ProductOrderPort update(
		@ApiParam(value = "ID of Order to update.", required = true) String id,
		@ApiParam(value = "Order object changes to update.", required = true) ProductOrder order
	);
	
	@ApiOperation(value = "DELETE-endpoint to remove Order.", nickname = "delete", notes = "Method allow to remove a order.", tags = {
		"Order",
	})
	void delete(@ApiParam(value = "Order object which will be deleted.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Order by id.", nickname = "searchForId", notes = "Method allow to find a order by id.", tags = {
		"Order",
	})
	ProductOrderPort searchForId(@ApiParam(value = "ID of Order to find.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Products by quanity range.", nickname = "searchAllForQuanityRange", notes = "Method allow to find a order by quanity range.", tags = {
		"Order",
	})
	List<ProductOrderPort> searchAllForQuanityRange(
		@ApiParam(value = "Minimal quanity value to find.", required = true) Integer min,
		@ApiParam(value = "Maximum quanity value to find.", required = true) Integer max
	);
	
	@ApiOperation(value = "GET-endpoint to find Products by quanity greater than value.", nickname = "searchAllForQuanityGreater", notes = "Method allow to find a order by quanity greater than value.", tags = {
		"Order",
	})
	List<ProductOrderPort> searchAllForQuanityGreater(
		@ApiParam(value = "Quanity value to find products of more value.", required = true) Integer quanity
	);
	
	@ApiOperation(value = "GET-endpoint to find all Products of quanity lower than value.", nickname = "searchAllForQuanityLower", notes = "Method allow to find a order by quanity lower than.", tags = {
		"Order",
	})
	List<ProductOrderPort> searchAllForQuanityLower(
		@ApiParam(value = "Quanity value to find products of less value.", required = true) Integer quanity
	);
	
	@ApiOperation(value = "GET-endpoint to find Order by name.", nickname = "searchAllForProductName", notes = "Method allow to find a order by name.", tags = {
		"Order",
	})
	List<ProductOrderPort> searchAllForProductName(
		@ApiParam(value = "Product name to find orders of this product.", required = true) String productName
	);
	
	@ApiOperation(value = "GET-endpoint to find Order by name and price.", nickname = "searchAllForProductNameAndProductPrice", notes = "Method allow to find a order by name and price.", tags = {
		"Order",
	})
	List<ProductOrderPort> searchAllForProductNameAndProductPrice(
		@ApiParam(value = "Product name to find orders of this product.", required = true) String productName,
		@ApiParam(value = "Product price to find orders of this product.", required = true) Double price
	);
	
}
