package pl.em.budget;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum BudgetExceptionMessage {
	BUDGET_IS_NULL("budget.is.null", "Budget cannot be null."),
	BUDGET_NOT_SAVED("budget.not.saved", "Budget cannot be saved."),
	
	BUDGET_NAME_IS_NULL("budget.name.is.null", "Budget name cannot be null."),
	BUDGET_NAME_IS_EMPTY("budget.name.is.empty", "Budget name cannot be empty."),
	
	BUDGET_VALUE_IS_NULL("budget.value.is.null", "Budget value cannot be null."),
	BUDGET_VALUE_IS_INVALID("budget.value.is.invalid", "Budget value cannot be infinite or is not a number."),
	
	BUDGET_BILLS_IS_NULL("budget.bills.is.null", "Budget bills of sale list cannot be null.");
	
	private final String code;
	
	private final String message;
}
