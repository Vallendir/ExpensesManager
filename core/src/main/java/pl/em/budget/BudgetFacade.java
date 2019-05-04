package pl.em.budget;

import lombok.RequiredArgsConstructor;
import pl.em.common.CQRSHandler;
import pl.em.common.CommonValidator;
import pl.em.common.DomainID;

import static pl.em.budget.BudgetExceptionFactory.budgetIsNull;
import static pl.em.common.CommonExceptionFactory.idIsNull;

@RequiredArgsConstructor
public final class BudgetFacade {
	
	private final BudgetCommandStorage command;
	
	private final BudgetQueryStorage query;
	
	private final CQRSHandler handler;
	
	public Budget createNew(Budget budget) {
		CommonValidator.validateNullObject(budget, budgetIsNull());
		
		return handler.executeCommand(
			new CreateNewBudget(
				command::create,
				budget,
				new BudgetValidator(budget)
			)
		);
	}
	
	public void remove(DomainID id) {
		CommonValidator.validateNullObject(id, idIsNull());
		CommonValidator.validateId(command::isIdValid, id);
		
		handler.executeCommand(
			new RemoveBudget(
				command::remove,
				id
			)
		);
	}

}
