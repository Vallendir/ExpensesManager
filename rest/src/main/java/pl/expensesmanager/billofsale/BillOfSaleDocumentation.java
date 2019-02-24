package pl.expensesmanager.billofsale;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.time.Instant;
import java.util.List;

@Api(tags = { "BillOfSale" })
public interface BillOfSaleDocumentation {
	
	@ApiOperation(value = "POST-endpoint to create BillOfSale.", nickname = "save", notes = "Method allow to create a new bill of sale.", tags = {
		"BillOfSale",
	})
	BillOfSale add(
		@ApiParam(value = "BillOfSale object which will be created.", required = true) BillOfSale billOfSale
	);
	
	@ApiOperation(value = "PUT-endpoint to update BillOfSale.", nickname = "update", notes = "Method allow to update a bill of sale.", tags = {
		"BillOfSale",
	})
	BillOfSale update(
		@ApiParam(value = "BillOfSale object which will be updated.", required = true) BillOfSale billOfSale
	);
	
	@ApiOperation(value = "PUT-endpoint to update BillOfSale of id.", nickname = "update", notes = "Method allow to update a bill of sale by id.", tags = {
		"BillOfSale",
	})
	BillOfSale update(
		@ApiParam(value = "ID of BillOfSale to update.", required = true) String id,
		@ApiParam(value = "BillOfSale object changes to update.", required = true) BillOfSale billOfSale
	);
	
	@ApiOperation(value = "DELETE-endpoint to removeById BillOfSale.", nickname = "removeById", notes = "Method allow to removeById a bill of sale.", tags = {
		"BillOfSale",
	})
	void delete(@ApiParam(value = "BillOfSale object which will be deleted.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find BillOfSale by id.", nickname = "searchById", notes = "Method allow to find a bill of sale by id.", tags = {
		"BillOfSale",
	})
	BillOfSale searchForId(@ApiParam(value = "ID of BillOfSale to find.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find BillOfSale by description.", nickname = "searchByDescription", notes = "Method allow to find a bill of sale by description.", tags = {
		"BillOfSale",
	})
	BillOfSale searchForDescription(
		@ApiParam(value = "Description of BillOfSale to find.", required = true) String description
	);
	
	@ApiOperation(value = "GET-endpoint to find BillOfSale by bought date.", nickname = "searchAllByBoughtDate", notes = "Method allow to find a bill of sale by bought date.", tags = {
		"BillOfSale",
	})
	List<BillOfSale> searchForBoughtDate(
		@ApiParam(value = "Bought date of BillOfSale to find.", required = true) Instant boughtDate
	);
	
	@ApiOperation(value = "GET-endpoint to find BillOfSale by bought date range.", nickname = "searchAllByBoughtDate", notes = "Method allow to find a bill of sale by bought date range.", tags = {
		"BillOfSale",
	})
	List<BillOfSale> searchAllForBoughtDateRange(
		@ApiParam(value = "Start bought date.", required = true) Instant boughtDateMin,
		@ApiParam(value = "End bought date.", required = true) Instant boughtDateMax
	);
	
}
