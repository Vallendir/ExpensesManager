package pl.em.budget;

import pl.em.common.ExceptionMessage;
import pl.em.common.ExpensesManagerException;
import pl.em.common.ObjectIsNullException;

final class BudgetExceptionFactory {
	
	static ExpensesManagerException budgetIsNull() {
		return new ObjectIsNullException(message(BudgetExceptionMessage.BUDGET_IS_NULL));
	}
	
	static ExpensesManagerException budgetNotSaved() {
		return new ObjectIsNullException(message(BudgetExceptionMessage.BUDGET_NOT_SAVED));
	}
	
	static ExpensesManagerException budgetNameIsNull() {
		return new ObjectIsNullException(message(BudgetExceptionMessage.BUDGET_NAME_IS_NULL));
	}
	
	static ExpensesManagerException budgetNameIsEmpty() {
		return new ObjectIsNullException(message(BudgetExceptionMessage.BUDGET_NAME_IS_EMPTY));
	}
	
	static ExpensesManagerException budgetValueIsNull() {
		return new ObjectIsNullException(message(BudgetExceptionMessage.BUDGET_VALUE_IS_NULL));
	}
	
	static ExpensesManagerException budgetValueIsInvalid() {
		return new ObjectIsNullException(message(BudgetExceptionMessage.BUDGET_VALUE_IS_INVALID));
	}
	
	static ExpensesManagerException budgetBillsListIsNull() {
		return new ObjectIsNullException(message(BudgetExceptionMessage.BUDGET_BILLS_IS_NULL));
	}
	
	private static ExceptionMessage message(BudgetExceptionMessage message) {
		return new ExceptionMessage(message.getCode(), message.getMessage());
	}
	
}
