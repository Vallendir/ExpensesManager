package pl.expensesmanager.budget;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@Api(tags = { "Budget" })
public interface BudgetDocumentation {
	
	@ApiOperation(value = "POST-endpoint to create Budget.", nickname = "save", notes = "Method allow to create a new budget.", tags = {
		"Budget",
	})
	Budget add(
		@ApiParam(value = "Budget object which will be created.", required = true) Budget budget
	);
	
	/*@ApiOperation(value = "PUT-endpoint to update Budget.", nickname = "update", notes = "Method allow to update a budget.", tags = {
		"Budget",
	})
	Budget update(
		@ApiParam(value = "Budget object which will be updated.", required = true) Budget budget
	);
	
	@ApiOperation(value = "PUT-endpoint to update Budget of id.", nickname = "update", notes = "Method allow to update a budget by id.", tags = {
		"Budget",
	})
	Budget update(
		@ApiParam(value = "ID of Budget to update.", required = true) String id,
		@ApiParam(value = "Budget object changes to update.", required = true) Budget budget
	);*/
	
	@ApiOperation(value = "DELETE-endpoint to removeById Budget.", nickname = "removeById", notes = "Method allow to removeById a budget.", tags = {
		"Budget",
	})
	void delete(@ApiParam(value = "Budget object which will be deleted.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Budget by id.", nickname = "searchById", notes = "Method allow to find a budget by id.", tags = {
		"Budget",
	})
	Budget searchForId(@ApiParam(value = "ID of Budget to find.", required = true) String id);
	
	@ApiOperation(value = "GET-endpoint to find Budget by name.", nickname = "searchByName", notes = "Method allow to find a budget by name.", tags = {
		"Budget",
	})
	Budget searchForName(@ApiParam(value = "Name of Budget to find.", required = true) String name);
	
	@ApiOperation(value = "GET-endpoint to find Budget by budget value.", nickname = "searchAllByValue", notes = "Method allow to find a budget by budget value.", tags = {
		"Budget",
	})
	List<Budget> searchAllForBudgetValue(
		@ApiParam(value = "Budget value to find.", required = true) Double budgetValue
	);
	
	@ApiOperation(value = "GET-endpoint to find Budget by budget value range.", nickname = "searchAllByValueRange", notes = "Method allow to find a budget by budget value range.", tags = {
		"Budget",
	})
	List<Budget> searchAllForBudgetValueRange(
		@ApiParam(value = "Minimal budget value to find.", required = true) Double min,
		@ApiParam(value = "Maximum budget value to find.", required = true) Double max
	);
	
	@ApiOperation(value = "GET-endpoint to find Budget by budget value greater than a value.", nickname = "searchAllByBiggerValueThan", notes = "Method allow to find a budget by budget value greater than a value.", tags = {
		"Budget",
	})
	List<Budget> searchAllForBudgetValueGreater(
		@ApiParam(value = "Budget value to find greaters.", required = true) Double budgetValue
	);
	
	@ApiOperation(value = "GET-endpoint to find Budget by budget value lower than a value.", nickname = "searchAllByLessValueThan", notes = "Method allow to find a budget by budget value lower than a value.", tags = {
		"Budget",
	})
	List<Budget> searchAllForBudgetValueLower(
		@ApiParam(value = "Budget value to find lowers.", required = true) Double budgetValue
	);
	
}
