package pl.em.budget;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class BudgetFacade {
	
	private final BudgetCommandStorage command;
	
	private final BudgetQueryStorage query;

}
