package pl.expensesmanager.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@Api(tags = { "Product" })
public interface ProductDocumentation {
	
	@ApiOperation(value = "POST-endpoint to createObject Product.", nickname = "save", notes = "Method allow to createObject a new product.", tags = {
		"Product",
	})
	Product add(
		@ApiParam(value = "Product object which will be created.", required = true) Product product
	);
	
	@ApiOperation(value = "PUT-endpoint to updateObject Product.", nickname = "updateObject", notes = "Method allow to updateObject a product.", tags = {
		"Product",
	})
	Product update(
		@ApiParam(value = "Product object which will be updated.", required = true) Product product
	);
	
	@ApiOperation(value = "PUT-endpoint to updateObject Product of id.", nickname = "updateObject", notes = "Method allow to updateObject a product by id.", tags = {
		"Product",
	})
	Product update(
		@ApiParam(value = "ID of Product to updateObject.", required = true) String id,
		@ApiParam(value = "Product object changes to updateObject.", required = true) Product product
	);
	
	@ApiOperation(value = "DELETE-endpoint to removeById Product.", nickname = "removeById", notes = "Method allow to removeById a product.", tags = {
		"Product",
	})
	void delete(@ApiParam(value = "Product object which will be deleted.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Product by id.", nickname = "searchById", notes = "Method allow to find a product by id.", tags = {
		"Product",
	})
	Product searchForId(@ApiParam(value = "ID of Product to find.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Product by name.", nickname = "searchByName", notes = "Method allow to find a product by name.", tags = {
		"Product",
	})
	List<Product> searchForName(@ApiParam(value = "Name of Product to find.", required = true) String name);
	
	@ApiOperation(value = "GET-endpoint to find Products bu price range.", nickname = "searchAllByPriceRange", notes = "Method allow to find a product by price range.", tags = {
		"Product",
	})
	List<Product> searchAllForPriceRange(
		@ApiParam(value = "Minimal price value to find.", required = true) Double priceMin,
		@ApiParam(value = "Maximum price value to find.", required = true) Double priceMax
	);
	
	@ApiOperation(value = "GET-endpoint to find Products of price greater than value.", nickname = "searchAllExpensiveThan", notes = "Method allow to find a product by price greater than value.", tags = {
		"Product",
	})
	List<Product> searchAllForPriceGreater(
		@ApiParam(value = "Price value to find products more expensive.", required = true) Double priceBigger
	);
	
	@ApiOperation(value = "GET-endpoint to find Products of price lower than value.", nickname = "searchAllCheaperThan", notes = "Method allow to find a product by price lower than value.", tags = {
		"Product",
	})
	List<Product> searchAllForPriceLower(
		@ApiParam(value = "Price value to find products cheaper.", required = true) Double priceLower
	);
	
}
