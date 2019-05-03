package pl.em.budget;

import lombok.RequiredArgsConstructor;
import pl.em.common.CQRSHandler;
import pl.em.common.DomainID;

import java.util.Objects;

import static pl.em.budget.BudgetExceptionFactory.budgetIsNull;
import static pl.em.common.CommonExceptionFactory.idIsNull;

@RequiredArgsConstructor
public final class BudgetFacade {
	
	private final BudgetCommandStorage command;
	
	private final BudgetQueryStorage query;
	
	private final CQRSHandler handler;
	
	public Budget createNew(Budget budget) {
		if (Objects.isNull(budget)) {
			throw budgetIsNull();
		}
		
		return handler.executeCommand(
			new CreateNewBudget(
				command::create,
				budget,
				new BudgetValidator(budget))
		);
	}
	
	public void remove(DomainID id) {
		if (Objects.isNull(id)) {
			throw idIsNull();
		}
		
		handler.executeCommand(
			new RemoveBudget(command::remove, id)
		);
	}

}
