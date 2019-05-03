package pl.em.budget;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static pl.em.budget.BudgetExceptionFactory.*;

@RequiredArgsConstructor
final class BudgetValidator {
	
	private final Budget budget;
	
	void validateName() {
		var name = budget.getName();
		
		if (Objects.isNull(name)) {
			throw budgetNameIsNull();
		}
		
		if (StringUtils.isBlank(name)) {
			throw budgetNameIsEmpty();
		}
	}
	
	void validateBudgetValue() {
		var budgetValue = budget.getBudgetValue();
		
		if (Objects.isNull(budgetValue)) {
			throw budgetValueIsNull();
		}
		
		if (budgetValue.isInfinite() || budgetValue.isNaN()) {
			throw budgetValueIsInvalid();
		}
	}
	
	void validateBills() {
		var bills = budget.getBillsOfSalseList();
		
		if (Objects.isNull(bills)) {
			throw budgetBillsListIsNull();
		}
	}
	
}
