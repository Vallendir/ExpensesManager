package pl.em.billofsale;

import io.swagger.annotations.*;

import java.util.List;

@Api(tags = { "BillOfSale Query" })
interface BillOfSaleApiQueryDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "BillOfSale was found."),
		@ApiResponse(code = 404, message = "BillOfSale not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Find bill of sale by id.", nickname = "searchForId", notes = "Method allow to find a bill of sale by id.", httpMethod = "GET", tags = {
		"BillOfSale Query",
	})
	BillOfSale searchForId(@ApiParam(value = "ID of BillOfSale to find.", required = true) String id);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "BillOfSales were found."),
		@ApiResponse(code = 404, message = "BillOfSales are not found.")
	})
	@ApiOperation(value = "Retrieve all bills of sale.", nickname = "searchAll", notes = "Method allow to find all bills of sale.", httpMethod = "GET", tags = {
		"BillOfSale Query",
	})
	List<BillOfSale> searchAll();
	
}
