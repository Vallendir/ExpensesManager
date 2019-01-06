package pl.expensesmanager.documentation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import pl.expensesmanager.domain.BudgetPort;

import java.util.List;

@Api(tags = { "Budget" })
public interface BudgetDocumentation {
	
	@ApiOperation(value = "POST-endpoint to create Budget.", nickname = "add", notes = "Method allow to create a new budget.", tags = {
		"Budget",
	})
	BudgetPort add(
		@ApiParam(value = "Budget object which will be created.", required = true) BudgetPort budget
	);
	
	@ApiOperation(value = "PUT-endpoint to update Budget.", nickname = "update", notes = "Method allow to update a budget.", tags = {
		"Budget",
	})
	BudgetPort update(
		@ApiParam(value = "Budget object which will be updated.", required = true) BudgetPort budget
	);
	
	@ApiOperation(value = "PUT-endpoint to update Budget of id.", nickname = "update", notes = "Method allow to update a budget by id.", tags = {
		"Budget",
	})
	BudgetPort update(
		@ApiParam(value = "ID of Budget to update.", required = true) String id,
		@ApiParam(value = "Budget object changes to update.", required = true) BudgetPort budget
	);
	
	@ApiOperation(value = "DELETE-endpoint to remove Budget.", nickname = "delete", notes = "Method allow to remove a budget.", tags = {
		"Budget",
	})
	void delete(@ApiParam(value = "Budget object which will be deleted.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Budget by id.", nickname = "searchForId", notes = "Method allow to find a budget by id.", tags = {
		"Budget",
	})
	BudgetPort searchForId(@ApiParam(value = "ID of Budget to find.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Budget by name.", nickname = "searchForName", notes = "Method allow to find a budget by name.", tags = {
		"Budget",
	})
	BudgetPort searchForName(@ApiParam(value = "Name of Budget to find.", required = true) String name);
	
	@ApiOperation(value = "GET-endpoint to find Budget by budget value.", nickname = "searchAllForBudgetValue", notes = "Method allow to find a budget by budget value.", tags = {
		"Budget",
	})
	List<BudgetPort> searchAllForBudgetValue(
		@ApiParam(value = "Budget value to find.", required = true) Double budgetValue
	);
	
	@ApiOperation(value = "GET-endpoint to find Budget by budget value range.", nickname = "searchAllForBudgetValueRange", notes = "Method allow to find a budget by budget value range.", tags = {
		"Budget",
	})
	List<BudgetPort> searchAllForBudgetValueRange(
		@ApiParam(value = "Minimal budget value to find.", required = true) Double min,
		@ApiParam(value = "Maximum budget value to find.", required = true) Double max
	);
	
	@ApiOperation(value = "GET-endpoint to find Budget by budget value greater than a value.", nickname = "searchAllForBudgetValueGreater", notes = "Method allow to find a budget by budget value greater than a value.", tags = {
		"Budget",
	})
	List<BudgetPort> searchAllForBudgetValueGreater(
		@ApiParam(value = "Budget value to find greaters.", required = true) Double budgetValue
	);
	
	@ApiOperation(value = "GET-endpoint to find Budget by budget value lower than a value.", nickname = "searchAllForBudgetValueLower", notes = "Method allow to find a budget by budget value lower than a value.", tags = {
		"Budget",
	})
	List<BudgetPort> searchAllForBudgetValueLower(
		@ApiParam(value = "Budget value to find lowers.", required = true) Double budgetValue
	);
	
}
