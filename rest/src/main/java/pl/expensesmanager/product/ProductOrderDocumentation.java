package pl.expensesmanager.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@Api(tags = { "Order" })
public interface ProductOrderDocumentation {
	
	@ApiOperation(value = "POST-endpoint to createObject Order.", nickname = "save", notes = "Method allow to createObject a new order.", tags = {
		"Order",
	})
	ProductOrder add(
		@ApiParam(value = "Order object which will be created.", required = true) ProductOrder order
	);
	
	@ApiOperation(value = "PUT-endpoint to updateObject Order.", nickname = "updateObject", notes = "Method allow to updateObject a order.", tags = {
		"Order",
	})
	ProductOrder update(
		@ApiParam(value = "Order object which will be updated.", required = true) ProductOrder order
	);
	
	@ApiOperation(value = "PUT-endpoint to updateObject Order of id.", nickname = "updateObject", notes = "Method allow to updateObject a order by id.", tags = {
		"Order",
	})
	ProductOrder update(
		@ApiParam(value = "ID of Order to updateObject.", required = true) String id,
		@ApiParam(value = "Order object changes to updateObject.", required = true) ProductOrder order
	);
	
	@ApiOperation(value = "DELETE-endpoint to removeById Order.", nickname = "removeById", notes = "Method allow to removeById a order.", tags = {
		"Order",
	})
	void delete(@ApiParam(value = "Order object which will be deleted.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Order by id.", nickname = "searchById", notes = "Method allow to find a order by id.", tags = {
		"Order",
	})
	ProductOrder searchForId(@ApiParam(value = "ID of Order to find.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Products by quanity range.", nickname = "searchAllByQuanityRange", notes = "Method allow to find a order by quanity range.", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForQuanityRange(
		@ApiParam(value = "Minimal quanity value to find.", required = true) Integer quanityMin,
		@ApiParam(value = "Maximum quanity value to find.", required = true) Integer quanityMax
	);
	
	@ApiOperation(value = "GET-endpoint to find Products by quanity greater than value.", nickname = "searchAllByBiggerQuanityThan", notes = "Method allow to find a order by quanity greater than value.", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForQuanityGreater(
		@ApiParam(value = "Quanity value to find products of more value.", required = true) Integer quanityBigger
	);
	
	@ApiOperation(value = "GET-endpoint to find all Products of quanity lower than value.", nickname = "searchAllByLessQuanityThan", notes = "Method allow to find a order by quanity lower than.", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForQuanityLower(
		@ApiParam(value = "Quanity value to find products of less value.", required = true) Integer quanityLower
	);
	
	@ApiOperation(value = "GET-endpoint to find Order by name.", nickname = "searchAllByProductName", notes = "Method allow to find a order by name.", tags = {
		"Order",
	})
	List<ProductOrder> searchAllForProductName(
		@ApiParam(value = "Product name to find orders of this product.", required = true) String productName
	);
	
	@ApiOperation(value = "GET-endpoint to find Order by name and price.", nickname = "searchAllByProductNameAndProductPrice", notes = "Method allow to find a order by name and price.", tags = {
		"Order",
	})
	ProductOrder searchAllForProductNameAndProductPrice(
		@ApiParam(value = "Product name to find orders of this product.", required = true) String productName,
		@ApiParam(value = "Product price to find orders of this product.", required = true) Double productPrice
	);
	
}
