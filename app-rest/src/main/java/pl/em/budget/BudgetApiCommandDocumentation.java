package pl.em.budget;

import io.swagger.annotations.*;

@Api(tags = { "Budget Command" })
interface BudgetApiCommandDocumentation {
	
	@ApiResponses(value = {
		@ApiResponse(code = 201, message = "Budget was created."),
		@ApiResponse(code = 409, message = "Budget cannot be null."),
		@ApiResponse(code = 409, message = "Budget name cannot be null."),
		@ApiResponse(code = 409, message = "Budget value cannot be null or is infinite.")
	})
	@ApiOperation(value = "Create budget.", nickname = "add", notes = "Method allow to create a new budget.", httpMethod = "POST", code = 201, tags = {
		"Budget",
	})
	Budget add(
		@ApiParam(value = "Budget object which will be created.", required = true) Budget budget
	);
	
	@ApiResponses(value = {
		@ApiResponse(code = 204, message = "Budget was removed."),
		@ApiResponse(code = 409, message = "ID has invalid format.")
	})
	@ApiOperation(value = "Remove budget.", nickname = "deleteById", notes = "Method allow to remove a budget.", httpMethod = "DELETE", code = 204, tags = {
		"Budget",
	})
	void delete(@ApiParam(value = "Budget object which will be deleted.", required = true) String id);
	
}
