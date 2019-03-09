package pl.expensesmanager.budget;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

@Api(tags = { "Budget" })
public interface BudgetDocumentation {
	
	@ApiOperation(value = "Find budget by id.", nickname = "searchForId", notes = "Method allow to find a budget by id.", httpMethod = "GET", tags = {
		"Budget",
	})
	Budget searchForId(@ApiParam(value = "ID of Budget to find.", required = true) String id);
	
	@ApiOperation(value = "Find budget by name.", nickname = "searchForName", notes = "Method allow to find a budget by name.", httpMethod = "GET", tags = {
		"Budget",
	})
	Budget searchForName(@ApiParam(value = "Name of Budget to find.", required = true) String name);
	
	@ApiOperation(value = "Retrieve all budgets.", nickname = "searchAll", notes = "Method allow to find all budgets.", httpMethod = "GET", tags = {
		"BillOfSale",
	})
	List<Budget> searchAll();
	
	@ApiOperation(value = "Find budget by budget value.", nickname = "searchAllForBudgetValue", notes = "Method allow to find a budget by value.", httpMethod = "GET", tags = {
		"Budget",
	})
	List<Budget> searchAllForBudgetValue(
		@ApiParam(value = "Budget value to find.", required = true) Double budgetValue
	);
	
	@ApiOperation(value = "Find budget by value range.", nickname = "searchAllForBudgetValueRange", notes = "Method allow to find a budget by value range.", httpMethod = "GET", tags = {
		"Budget",
	})
	List<Budget> searchAllForBudgetValueRange(
		@ApiParam(value = "Minimal budget value to find.", required = true) Double min,
		@ApiParam(value = "Maximum budget value to find.", required = true) Double max
	);
	
	@ApiOperation(value = "Find budget by value greater than a value.", nickname = "searchAllForBudgetValueGreater", notes = "Method allow to find a budget by value greater than a value.", httpMethod = "GET", tags = {
		"Budget",
	})
	List<Budget> searchAllForBudgetValueGreater(
		@ApiParam(value = "Budget value to find greaters.", required = true) Double budgetValue
	);
	
	@ApiOperation(value = "Find budget by value lower than a value.", nickname = "searchAllForBudgetValueLower", notes = "Method allow to find a budget by value lower than a value.", httpMethod = "GET", tags = {
		"Budget",
	})
	List<Budget> searchAllForBudgetValueLower(
		@ApiParam(value = "Budget value to find lowers.", required = true) Double budgetValue
	);
	
	@ApiOperation(value = "Create budget.", nickname = "add", notes = "Method allow to create a new budget.", httpMethod = "POST", tags = {
		"Budget",
	})
	Budget add(
		@ApiParam(value = "Budget object which will be created.", required = true) Budget budget
	);
	
	@ApiOperation(value = "Update budget.", nickname = "updateObject", notes = "Method allow to update a budget.", httpMethod = "PUT", tags = {
		"Budget",
	})
	Budget update(
		@ApiParam(value = "Budget object which will be updated.", required = true) Budget budget
	);
	
	@ApiOperation(value = "Update budget by id.", nickname = "updateById", notes = "Method allow to update a budget by id.", httpMethod = "PUT", tags = {
		"Budget",
	})
	Budget update(
		@ApiParam(value = "ID of Budget to updateObject.", required = true) String id,
		@ApiParam(value = "Budget object changes to updateObject.", required = true) Budget budget
	);
	
	@ApiOperation(value = "Remove budget.", nickname = "deleteById", notes = "Method allow to remove a budget.", httpMethod = "DELETE", tags = {
		"Budget",
	})
	void delete(@ApiParam(value = "Budget object which will be deleted.", required = true) String id);
	
}
