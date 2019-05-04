package pl.em.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/budgets")
@RequiredArgsConstructor
class BudgetRESTCommandController implements BudgetApiCommandDocumentation {
	
	private final BudgetFacade service;
	
	@Override
	public Budget add(Budget budget) {
		return null;
	}
	
	@Override
	public void delete(String id) {
	
	}
	
}
