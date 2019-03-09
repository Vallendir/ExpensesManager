package pl.expensesmanager.billofsale;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.time.Instant;
import java.util.List;

@Api(tags = { "BillOfSale" })
public interface BillOfSaleDocumentation {
	
	@ApiOperation(value = "Find bill of sale by id.", nickname = "searchForId", notes = "Method allow to find a bill of sale by id.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	BillOfSale searchForId(@ApiParam(value = "ID of BillOfSale to find.", required = true) String id);
	
	@ApiOperation(value = "Find bill of sale by description.", nickname = "searchForDescription", notes = "Method allow to find a bill of sale by description.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	BillOfSale searchForDescription(
		@ApiParam(value = "Description of BillOfSale to find.", required = true) String description
	);
	
	@ApiOperation(value = "Retrieve all bills of sale.", nickname = "searchAll", notes = "Method allow to find all bills of sale.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	List<BillOfSale> searchAll();
	
	@ApiOperation(value = "Find bill of sale by bought date.", nickname = "searchForBoughtDate", notes = "Method allow to find a bill of sale by bought date.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	List<BillOfSale> searchForBoughtDate(
		@ApiParam(value = "Bought date of bill of sale to find.", required = true) Instant boughtDate
	);
	
	@ApiOperation(value = "Find bill of sale by bought date range.", nickname = "searchAllForBoughtDateRange", notes = "Method allow to find a bill of sale by bought date range.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	List<BillOfSale> searchAllForBoughtDateRange(
		@ApiParam(value = "Start bought date.", required = true) Instant boughtDateMin,
		@ApiParam(value = "End bought date.", required = true) Instant boughtDateMax
	);
	
	@ApiOperation(value = "Create bill of sale.", nickname = "add", notes = "Method allow to create a new bill of sale.", httpMethod = "POST", tags = {
		"BillOfSale",
	})
	BillOfSale add(
		@ApiParam(value = "BillOfSale object which will be created.", required = true) BillOfSale billOfSale
	);
	
	@ApiOperation(value = "Update bill of sale.", nickname = "updateObject", notes = "Method allow to update a bill of sale.", httpMethod = "PUT", tags = {
		"BillOfSale",
	})
	BillOfSale update(
		@ApiParam(value = "BillOfSale object which will be updated.", required = true) BillOfSale billOfSale
	);
	
	@ApiOperation(value = "Update bill of sale by id.", nickname = "updateById", notes = "Method allow to update a bill of sale by id.", httpMethod = "PUT", tags = {
		"BillOfSale",
	})
	BillOfSale update(
		@ApiParam(value = "ID of BillOfSale to updateObject.", required = true) String id,
		@ApiParam(value = "BillOfSale object changes to updateObject.", required = true) BillOfSale billOfSale
	);
	
	@ApiOperation(value = "Remove bill of sale.", nickname = "deleteById", notes = "Method allow to remove a bill of sale.", httpMethod = "DELETE", tags = {
		"BillOfSale",
	})
	void delete(@ApiParam(value = "BillOfSale object which will be deleted.", required = true) String id);
	
}
