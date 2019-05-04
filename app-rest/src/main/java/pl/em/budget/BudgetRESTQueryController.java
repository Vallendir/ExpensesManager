package pl.em.budget;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/budgets")
@RequiredArgsConstructor
class BudgetRESTQueryController implements BudgetApiQueryDocumentation {
	
	private final BudgetFacade service;
	
	@Override
	public Budget searchForId(String id) {
		return null;
	}
	
	@Override
	public List<Budget> searchAll() {
		return null;
	}
	
}
