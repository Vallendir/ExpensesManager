package pl.em.budget;

import io.swagger.annotations.*;

import java.util.List;

@Api(tags = { "Budget Query" })
interface BudgetApiQueryDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Budget was found."),
		@ApiResponse(code = 404, message = "Budget not found."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Find budget by id.", nickname = "searchForId", notes = "Method allow to find a budget by id.", httpMethod = "GET", tags = {
		"Budget Query",
	})
	Budget searchForId(@ApiParam(value = "ID of Budget to find.", required = true) String id);
	
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Budgets were found."),
		@ApiResponse(code = 404, message = "Budgets are not found.")
	})
	@ApiOperation(value = "Retrieve all budgets.", nickname = "searchAll", notes = "Method allow to find all budgets.", httpMethod = "GET", tags = {
		"Budget Query",
	})
	List<Budget> searchAll();
	
}
