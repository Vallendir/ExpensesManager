package pl.expensesmanager.billofsale;

import io.swagger.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;

@Api(tags = { "BillOfSale" })
public interface BillOfSaleDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "BillOfSale was found."),
		@ApiResponse(code = 404, message = "BillOfSale not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Find bill of sale by id.", nickname = "searchForId", notes = "Method allow to find a bill of sale by id.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	BillOfSale searchForId(@ApiParam(value = "ID of BillOfSale to find.", required = true) String id);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "BillOfSale was found."),
		@ApiResponse(code = 404, message = "BillOfSale not found."),
		@ApiResponse(code = 409, message = "BillOfSale description cannot be null.")
	})
	@ApiOperation(value = "Find bill of sale by description.", nickname = "searchForDescription", notes = "Method allow to find a bill of sale by description.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	BillOfSale searchForDescription(
		@ApiParam(value = "Description of BillOfSale to find.", required = true) String description
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "BillOfSales were found."),
		@ApiResponse(code = 404, message = "BillOfSales are not found.")
	})
	@ApiOperation(value = "Retrieve all bills of sale.", nickname = "searchAll", notes = "Method allow to find all bills of sale.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	List<BillOfSale> searchAll();
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "BillOfSale was found."),
		@ApiResponse(code = 404, message = "BillOfSale not found."),
		@ApiResponse(code = 409, message = "BillOfSale bought date cannot be null.")
	})
	@ApiOperation(value = "Find bill of sale by bought date.", nickname = "searchForBoughtDate", notes = "Method allow to find a bill of sale by bought date.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	List<BillOfSale> searchForBoughtDate(
		@ApiParam(value = "Bought date of bill of sale to find.", required = true) Instant boughtDate
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "BillOfSale was found."),
		@ApiResponse(code = 404, message = "BillOfSale not found."),
		@ApiResponse(code = 409, message = "BillOfSale bought date cannot be null."),
		@ApiResponse(code = 409, message = "Minimum bought date cannot be after maximum bought date.")
	})
	@ApiOperation(value = "Find bill of sale by bought date range.", nickname = "searchAllForBoughtDateRange", notes = "Method allow to find a bill of sale by bought date range.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	List<BillOfSale> searchAllForBoughtDateRange(
		@ApiParam(value = "Start bought date.", required = true) Instant boughtDateMin,
		@ApiParam(value = "End bought date.", required = true) Instant boughtDateMax
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "BillOfSale was created."),
		@ApiResponse(code = 409, message = "BillOfSale cannot be null."),
		@ApiResponse(code = 409, message = "BillOfSale description cannot be null."),
		@ApiResponse(code = 409, message = "BillOfSale bought date cannot be null.")
	})
	@ApiOperation(value = "Create bill of sale.", nickname = "add", notes = "Method allow to create a new bill of sale.", httpMethod = "POST", code = 201, tags = {
		"BillOfSale",
	})
	BillOfSale add(
		@ApiParam(value = "BillOfSale object which will be created.", required = true) BillOfSale billOfSale
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "BillOfSale was updated."),
		@ApiResponse(code = 404, message = "BillOfSale not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Update bill of sale.", nickname = "updateObject", notes = "Method allow to update a bill of sale.", httpMethod = "PUT", tags = {
		"BillOfSale",
	})
	BillOfSale update(
		@ApiParam(value = "BillOfSale object which will be updated.", required = true) BillOfSale billOfSale
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "BillOfSale was updated."),
		@ApiResponse(code = 404, message = "BillOfSale not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Update bill of sale by id.", nickname = "updateById", notes = "Method allow to update a bill of sale by id.", httpMethod = "PUT", tags = {
		"BillOfSale",
	})
	BillOfSale update(
		@ApiParam(value = "ID of BillOfSale to updateObject.", required = true) String id,
		@ApiParam(value = "BillOfSale object changes to updateObject.", required = true) BillOfSale billOfSale
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "BillOfSale was removed."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Remove bill of sale.", nickname = "deleteById", notes = "Method allow to remove a bill of sale.", httpMethod = "DELETE", code = 204, tags = {
		"BillOfSale",
	})
	void delete(@ApiParam(value = "BillOfSale object which will be deleted.", required = true) String id);
	
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "BillOfSale image was uploaded."),
		@ApiResponse(code = 400, message = "BillOfSale image is empty."),
		@ApiResponse(code = 500, message = "BillOfSale cannot be reproduced in system.")
	})
	@ApiOperation(value = "Upload image of bill of sale.", nickname = "uploadBillOfSaleAsImage", notes = "Method allow to upload an image of bill of sale.", httpMethod = "POST", code = 201, tags = {
		"BillOfSale",
	})
	BillOfSaleImageAsText uploadBillOfSaleAsImage(@ApiParam(value = "Image of BillOfSale.", required = true) MultipartFile file);
	
}
