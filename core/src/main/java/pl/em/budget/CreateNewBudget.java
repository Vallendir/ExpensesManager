package pl.em.budget;

import lombok.RequiredArgsConstructor;
import pl.em.common.DomainCommand;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
final class CreateNewBudget implements DomainCommand<Budget> {
	
	private final Function<Budget, Optional<Budget>> createFunction;
	
	private final Budget toSave;
	
	private final BudgetValidator validator;
	
	@Override
	public Budget execute() {
		validator.validateName();
		validator.validateBudgetValue();
		validator.validateBills();
		
		return createFunction.apply(toSave)
		                     .orElseThrow(
			                     BudgetExceptionFactory::budgetNotSaved
		                     );
	}
	
}
